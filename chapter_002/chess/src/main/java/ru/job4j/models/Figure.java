package ru.job4j.models;

import ru.job4j.ChessExceptions.ImpossibleMoveException;

/**
 * The abstract class Figure.
 * This class description the model of chess figure.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public abstract class Figure {

    /**
     * This field describes the cell of the chess board.
     */
    private final Cell position;

    /**
     * It is a sign of the white figure.
     */
    private final boolean isWhite;

    /**
     * Construct a new Cell.
     *
     * @param position a position of the cell on the chess board.
     * @param isWhite  a sign of the white figure.
     */
    public Figure(Cell position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    /**
     * This method description a move if the figure.
     * If the figure can go to the specified cell, returns an array of traversed cells. If not, thrown an exception.
     *
     * @param dist the cell where figure want to go.
     * @return arrays cell's.
     * @throws ImpossibleMoveException Exception.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * This method descriotion the cell where to move the piece.
     *
     * @param dist the cell where to move the piece.
     * @return Figure.
     * @throws ImpossibleMoveException Exception.
     */
    public abstract Figure clone(Cell dist) throws ImpossibleMoveException;

    /**
     * Getter.
     *
     * @return position
     */
    public Cell getPosition() {
        return position;
    }

    /**
     * Getter.
     *
     * @return isWhite
     */
    public boolean isWhite() {
        return isWhite;
    }
}
