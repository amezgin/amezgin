package ru.job4j.exception;

/**
 * The class MapContainsExtraKeyException.
 * This exception called when map contains extra keys.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public class MapContainsExtraKeyException extends Exception {
    /**
     * Constructor for class MapContainsExtraKeyException.
     *
     * @param message message.
     */
    public MapContainsExtraKeyException(String message) {
        super(message);
    }
}