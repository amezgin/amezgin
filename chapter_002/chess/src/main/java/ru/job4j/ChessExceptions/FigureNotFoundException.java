package ru.job4j.ChessExceptions;

/**
 * The class FigureNotFoundException.
 * This exception is thrown when you try to move a chess piece in an invalid field of a chessboard.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public class FigureNotFoundException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
