package ru.job4j.model;

/**
 * The class Role.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class Role {

    /**
     * The id of the role.
     */
    private Integer id;

    /**
     * The name of the role.
     */
    private final String name;

    /**
     * The constructor.
     *
     * @param name name.
     */
    public Role(String name) {
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
     * The getter for the role name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }
}