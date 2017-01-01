package ru.job4j.models;

import ru.job4j.ChessExceptions.ImpossibleMoveException;

import static java.lang.Math.abs;

/**
 * The class Bishop.
 * This class describes the behavior of the chess pieces bishop.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public class Bishop extends Figure {

    /**
     * Construct a new Cell.
     *
     * @param position a position of the cell on the chess board.
     * @param isWhite  a sign of the white figure.
     */
    public Bishop(Cell position, boolean isWhite) {
        super(position, isWhite);
    }

    /**
     * This method description a move if the figure.
     * If the figure can go to the specified cell, returns an array of traversed cells. If not, thrown an exception.
     *
     * @param dist the cell where figure want to go.
     * @return arrays cell's.
     * @throws ImpossibleMoveException Exception.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int rowShift = dist.getRowPos() - this.getPosition().getRowPos();
        int columnShift = dist.getColumnPos() - this.getPosition().getColumnPos();

        Cell[] result;

        if (abs(rowShift) == abs(columnShift)
                && dist.getRowPos() <= 7 && dist.getRowPos() >= 0
                && dist.getColumnPos() <= 7 && dist.getColumnPos() >= 0) {
            result = new Cell[abs(rowShift)];

            for (int i = 0; i < abs(rowShift); i++) {
                result[i] = new Cell(this.getPosition().getRowPos() + (i + 1) * rowShift / abs(rowShift),
                        this.getPosition().getColumnPos() + (i + 1) * columnShift / abs(columnShift));
            }
        } else {
            throw new ImpossibleMoveException("You cannot move to the desired location!");
        }

        return result;
    }

    /**
     * This method description the cell where to move the piece.
     *
     * @param dist the cell where to move the piece.
     * @return figure Bishop.
     * @throws ImpossibleMoveException Exception.
     */
    @Override
    public Bishop clone(Cell dist) throws ImpossibleMoveException {
        if (dist.getRowPos() <= 7 && dist.getRowPos() >= 0
                && dist.getColumnPos() <= 7 && dist.getColumnPos() >= 0) {
            return new Bishop(dist, this.isWhite());
        } else {
            throw new ImpossibleMoveException("You cannot move to the desired location!");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + "(("
                + this.getPosition().getRowPos()
                + ", "
                + this.getPosition().getColumnPos()
                + "), "
                + (isWhite() ? "white)" : "black)");
    }
}
