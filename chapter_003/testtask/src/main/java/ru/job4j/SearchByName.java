package ru.job4j;

/**
 * The class SearchByName.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.01.2017
 */
public class SearchByName {

    /**
     * Name of file.
     */
    private String name;

    /**
     * Argument for mask.
     */
    private String arg;

    /**
     * Constructor.
     *
     * @param name name of file.
     * @param arg  argument for mask.
     */
    public SearchByName(String name, String arg) {
        this.name = name;
        this.arg = arg;
    }

    /**
     * This method checks equals name to mask.
     *
     * @return true if name equals mask.
     */
    public boolean checkName() {
        return name.equalsIgnoreCase(arg);
    }
}
