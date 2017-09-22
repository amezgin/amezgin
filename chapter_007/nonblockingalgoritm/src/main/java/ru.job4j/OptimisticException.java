package ru.job4j;

/**
 * Class OptimisticException.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.09.2017
 */
public class OptimisticException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param msg the detail message.
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}