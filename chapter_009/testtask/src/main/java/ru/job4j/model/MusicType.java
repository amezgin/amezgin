package ru.job4j.model;

/**
 * The class MusicType.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class MusicType {

    /**
     * The id.
     */
    private Integer id;

    /**
     * The name of the music type.
     */
    private final String name;

    /**
     * The constructor.
     *
     * @param name name.
     */
    public MusicType(String name) {
        this.name = name;
    }

    /**
     * The getter for id.
     *
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * The setter for id.
     *
     * @param id id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * The getter for the music type name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }
}