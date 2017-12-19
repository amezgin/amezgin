package ru.job4j;

import java.sql.Timestamp;

/**
 * The class Vacancy.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.12.2017
 */
public class Vacancy {

    /**
     * The link on the vacancy.
     */
    private final String link;

    /**
     * The description the vacancy.
     */
    private final String description;

    /**
     * The date of the vacancy.
     */
    private final Timestamp createDate;

    /**
     * The constructor.
     *
     * @param link link.
     * @param description description.
     * @param createDate create_date.
     */
    public Vacancy(final String link, final String description, final Timestamp createDate) {
        this.link = link;
        this.description = description;
        this.createDate = createDate;
    }

    /**
     * The getter for link.
     *
     * @return link.
     */
    public String getLink() {
        return this.link;
    }

    /**
     * The getter for description.
     *
     * @return description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * The getter for date of create.
     *
     * @return date of create.
     */
    public Timestamp getCreateDate() {
        return this.createDate;
    }
}