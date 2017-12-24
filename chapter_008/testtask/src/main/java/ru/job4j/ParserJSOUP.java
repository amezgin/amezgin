package ru.job4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimerTask;

/**
 * The class ParserJSOUP.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.12.2017
 */
public class ParserJSOUP extends TimerTask {

    /**
     * The url with java vacancies.
     */
    private final String url = "http://www.sql.ru/forum/job-offers";

    /**
     * The number of page.
     */
    private int page = 1;

    /**
     * The ConnectDB.
     */
    private ConnectDB connectDB = null;

    /**
     * The SimpleDateFormat for converting dates from forum.
     */
    private final SimpleDateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));

    /**
     * The logger for parser.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ParserJSOUP.class);

    /**
     * Date of the oldest vacancies.
     */
    private Timestamp dateInspectionsVacancies = null;

    /**
     * The count starts the program.
     */
    private int countStartProgram = 0;

    /**
     * The constructor.
     */
    public ParserJSOUP(ConnectDB connectDB) {
        this.connectDB = connectDB;
    }

    /**
     * The run.
     */
    @Override
    public void run() {
        LOG.info("The parser is started!");
        try (Connection conn = this.connectDB.getConnectToDB()) {
            this.connectDB.createTable();
            parseSite();
            LOG.info("The parser is stopped!");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The connection is stopped!");
        }
    }

    /**
     * This method parsing the site and save result to database.
     */

    private void parseSite() {
        this.countStartProgram++;
        if (this.countStartProgram == 1) {
            this.dateInspectionsVacancies = setDateToBeginningYear();
        }
        boolean isParseComplete = false;
        String currentPage = this.url;
        do {
            if (this.page > 1) {
                currentPage = String.format("%s/%d", this.url, this.page);
            }
            Document doc = null;
            Elements topics = null;
            try {
                doc = Jsoup.connect(currentPage).get();
                topics = doc.select("tr:has(.postslisttopic)");
                for (Element topic : topics) {
                    if (topic.text().toLowerCase().contains("java") && !topic.text().toLowerCase().contains("script")) {
                        Elements link = topic.select("td.postslisttopic > a[href]");
                        Elements data = topic.select("td");
                        String linkVacancy = link.attr("href");
                        String description = link.get(0).text();
                        Timestamp createDate = parseDate(data.get(5).text());
                        if (createDate.before(this.dateInspectionsVacancies)) {
                            isParseComplete = true;
                            break;
                        }
                        this.connectDB.saveToDB(new Vacancy(linkVacancy, description, createDate));
                    }
                }
                this.page++;
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        } while (!isParseComplete);
        this.dateInspectionsVacancies = setDateStartProgram();
    }

    /**
     * This method converts the current string in format Timestamp.
     *
     * @param date date in string.
     * @return Timestamp date.
     */
    private Timestamp parseDate(String date) {
        Calendar calendar = Calendar.getInstance();
        if (date.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(9, 11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(12, 14)));
            calendar.set(Calendar.SECOND, 0);
        } else if (date.contains("вчера")) {
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(7, 9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(10, 12)));
            calendar.set(Calendar.SECOND, 0);
        } else {
            try {
                calendar.setTime(this.format.parse(date));
            } catch (ParseException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * This method sets the time at the beginning of the year.
     *
     * @return time at the beginning of the year.
     */
    private Timestamp setDateToBeginningYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(LocalDate.now().getYear(), 0, 1, 0, 0, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * This method sets the time when the program start.
     *
     * @return the time when the program start.
     */
    private Timestamp setDateStartProgram() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTimeInMillis());
    }
}