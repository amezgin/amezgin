package ru.job4j.chessexceptions;

/**
 * The class OccupiedWayException.
 * This exception is thrown when you try to make a move from the cell of the chessboard, in which there is no figure.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public class OccupiedWayException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
