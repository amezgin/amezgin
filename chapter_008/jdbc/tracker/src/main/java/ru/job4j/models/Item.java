package ru.job4j.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The class Item.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.12.2016
 */
public class Item {

    /**
     * Private field "id" for class Item.
     */
    private String id;
    /**
     * Private field "name" for class Item.
     */
    private String name;
    /**
     * Private field "description" for class Item.
     */
    private String description;
    /**
     * Private field "dateCreate" for class Item.
     */
    private Date dateCreat;

    /**
     * Constructor for the class Item.
     *
     * @param name        for the Constructor
     * @param description for the Constructor
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreat = new Date();
    }

    /**
     * Getter for the field "id".
     *
     * @return id of Item
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for the field "id".
     *
     * @param id of Item
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the field "name".
     *
     * @return name of Item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the field "description".
     *
     * @return description of Item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for the field "dateCreat".
     *
     * @return dateCreat of Item
     */
    public Date getDateCreat() {
        return this.dateCreat;
    }

    /**
     * Setter for the field "dateCreat".
     *
     * @param dateCreat of Item
     */
    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }


    /**
     * Override the nethod toString".
     *
     * @return item toString
     */
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
        return "Item{"
                + "id = '" + id + '\''
                + ", name = '" + name + '\''
                + ", description = '" + description + '\''
                + ", dateCreat = " + dateFormat.format(dateCreat)
                + '}';
    }
}
