package ru.job4j;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class ConsoleChat.
 * This class emulate the work of the chat.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 08.01.2017
 */
public class ConsoleChat {

    /**
     * This field contains all answers.
     */
    private List<String> answersList = new ArrayList<>();

    /**
     * This field description a line which stops the response of the bot.
     */
    private final String stop = "Стоп";
    /**
     * This field description a line which continue the response of the bot.
     */
    private final String contin = "Продолжить";
    /**
     * This field description a line which stops the chat.
     */
    private final String end = "Закончить";

    /**
     * This field is the stop sign of the response of the bot.
     */
    private boolean isStop = false;

    /**
     * This method describes the main logic of the program.
     *
     * @throws IOException IOException
     */
    public void init() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter log = new BufferedWriter(new FileWriter(new File("./log.txt")))) {
            int countLine = generatorAnswersList();
            String text;
            String answer;
            do {
                text = bufferedReader.readLine();
                if (text.equalsIgnoreCase(stop)) {
                    setStop(true);
                    log.write(String.format("user: %s%s", text, System.getProperty("line.separator")));
                    System.out.println(text);
                }
                if (text.equalsIgnoreCase(contin)) {
                    setStop(false);
                    log.write(String.format("user: %s%s", text, System.getProperty("line.separator")));
                    System.out.println(text);
                    answer = generatorResponse(countLine);
                    log.write(String.format("bot: %s%s", answer, System.getProperty("line.separator")));
                    System.out.println(answer);
                    continue;
                }
                if (text.equalsIgnoreCase(end)) {
                    log.write(String.format("user: %s%s", text, System.getProperty("line.separator")));
                    System.out.println(text);
                }
                if (!isStop() && !text.equalsIgnoreCase(end)) {
                    log.write(String.format("user: %s%s", text, System.getProperty("line.separator")));
                    System.out.println(text);
                    answer = generatorResponse(countLine);
                    log.write(String.format("bot: %s%s", answer, System.getProperty("line.separator")));
                    System.out.println(answer);
                }
            }
            while (!text.equalsIgnoreCase(end));
        }
    }

    /**
     * Getter for stop.
     *
     * @return isStop
     */
    public boolean isStop() {
        return isStop;
    }

    /**
     * Setter for stop.
     *
     * @param stop stop
     */
    public void setStop(boolean stop) {
        isStop = stop;
    }

    /**
     * This method generate the list of answers and return count acceptable responses.
     *
     * @return count acceptable responses.
     * @throws IOException is exception.
     */
    private int generatorAnswersList() throws IOException {
        File answerFile = new File(this.getClass().getResource("/answers.txt").getPath());
        if (!answerFile.exists()) {
            System.out.println("The file answers not found!");
        }
        try (RandomAccessFile raf = new RandomAccessFile(answerFile, "r")) {
            int countLine = 0;
            String line;
            while ((line = raf.readLine()) != null) {
                if (!"".equals(line)) {
                    this.answersList.add(line);
                    countLine++;
                }
            }
            return countLine;
        }
    }

    /**
     * This method return the random answer.
     *
     * @param countLines count lines
     * @return answer.
     */
    private String generatorResponse(int countLines) {
        return this.answersList.get(new Random().nextInt(countLines));
    }
}