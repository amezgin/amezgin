package ru.job4j.parallelsearch;

/**
 * The class ValidateException.
 * This exception is thrown when you enter incorrect keys.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.08.2017
 */
public class ValidateException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public ValidateException(String message) {
        super(message);
    }
}
