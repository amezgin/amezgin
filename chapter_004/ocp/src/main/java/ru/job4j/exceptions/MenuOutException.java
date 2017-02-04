package ru.job4j.exceptions;

/**
 * The class MenuOutException.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor fo class MenuOutException.
     *
     * @param message message.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
