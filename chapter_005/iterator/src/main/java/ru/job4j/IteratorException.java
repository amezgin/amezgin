package ru.job4j;

/**
 * The class IteratorException.
 * This exception called when Iterator<Iterator<Integer>> = null.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.03.2017
 */
public class IteratorException extends Exception {

    /**
     * Constructor for class IteratorException.
     *
     * @param message message.
     */
    public IteratorException(String message) {
        super(message);
    }
}
