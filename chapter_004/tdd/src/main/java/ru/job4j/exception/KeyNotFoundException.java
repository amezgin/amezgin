package ru.job4j.exception;

/**
 * The class KeyNotFoundException.
 * This exception called when key in map not found.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public class KeyNotFoundException extends Exception {
    /**
     * Constructor for class KeyNotFoundException.
     *
     * @param message message.
     */
    public KeyNotFoundException(String message) {
        super(message);
    }
}
