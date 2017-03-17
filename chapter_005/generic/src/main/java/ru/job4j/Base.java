package ru.job4j;

/**
 * The abstract class Base.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.03.2017
 */
public abstract class Base {

    /**
     * Identifier.
     */
    private String id;

    /**
     * Getter.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter.
     *
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
