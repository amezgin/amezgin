package ru.job4j.exception;

/**
 * The class OutOfGameFieldException.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.03.2017
 */
public class OutOfGameFieldException extends RuntimeException {

    /**
     * Constructor fo class OutOfGameFieldException.
     *
     * @param message message.
     */
    public OutOfGameFieldException(String message) {
        super(message);
    }
}
