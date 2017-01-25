package ru.job4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class SearchByRegExp.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.01.2017
 */
public class SearchByRegExp {
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
    public SearchByRegExp(String name, String arg) {
        this.name = name;
        this.arg = arg;
    }

    /**
     * This method checks equals name to mask.
     *
     * @return true if name equals mask.
     */
    public boolean checkName() {
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
