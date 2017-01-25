package ru.job4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class SearchByMask.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.01.2017
 */
public class SearchByMask {

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
    public SearchByMask(String name, String arg) {
        this.name = name;
        this.arg = arg;
    }

    /**
     * This method checks equals name to mask.
     *
     * @return true if name equals mask.
     */
    public boolean checkName() {
        StringBuilder patt = new StringBuilder();
        char[] chArr = arg.toCharArray();
        patt.append("^");
        for (char ch : chArr) {
            switch (ch) {
                case '.': {
                    patt.append("\\.");
                    break;
                }
                case '?': {
                    patt.append(".");
                    break;
                }
                case '*': {
                    patt.append(".*");
                    break;
                }
                default: {
                    patt.append(ch);
                    break;
                }
            }
        }
        patt.append("$");
        Pattern pattern = Pattern.compile(patt.toString());
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
