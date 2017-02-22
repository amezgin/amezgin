package ru.job4j.exception;

/**
 * The class MapContainsExtraKayException.
 * This exception called when map contains extra keys.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public class MapContainsExtraKayException extends Exception {
    /**
     * Constructor for class MapContainsExtraKayException.
     *
     * @param message message.
     */
    public MapContainsExtraKayException(String message) {
        super(message);
    }
}