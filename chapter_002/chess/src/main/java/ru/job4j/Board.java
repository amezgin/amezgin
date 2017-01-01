package ru.job4j;

import ru.job4j.ChessExceptions.FigureNotFoundException;
import ru.job4j.ChessExceptions.ImpossibleMoveException;
import ru.job4j.ChessExceptions.OccupiedWayException;
import ru.job4j.models.Bishop;
import ru.job4j.models.Cell;
import ru.job4j.models.Figure;

/**
 * The class Board.
 * This class description the model of the chess board.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public class Board {

    /**
     * This field description the size of the board.
     */
    private static final int SIZE_BOARD = 8;

    /**
     * This field description the array of figures.
     */
    private Figure[][] figures = new Figure[SIZE_BOARD][SIZE_BOARD];

    /**
     * This method adds the chess figure.
     */
    public void fillBoard() {
        addFigure(new Bishop(new Cell(0, 2), true));
        addFigure(new Bishop(new Cell(0, 5), true));
        addFigure(new Bishop(new Cell(7, 2), false));
        addFigure(new Bishop(new Cell(7, 5), false));
    }

    /**
     * This method carries out the movement of pieces on the chessboard.
     *
     * @param source source cell.
     * @param dist   dist cell.
     * @return true or false.
     * @throws ImpossibleMoveException Exception.
     * @throws OccupiedWayException    Exception.
     * @throws FigureNotFoundException Exception.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        if (checkFigure(source)) {
            Figure figure = getFigure(source);
            if (checkWay(source, dist)) {
                figure.clone(dist);
                removeFigure(figure);
                result = true;
            }
        }
        return result;
    }

    /**
     * This method returns the chess piece is located in the cell.
     *
     * @param cell cell
     * @return figure
     */
    public Figure getFigure(Cell cell) {
        return figures[cell.getRowPos()][cell.getColumnPos()];
    }

    /**
     * This method added a figure in to array of figures.
     *
     * @param figure figure.
     */
    public void addFigure(Figure figure) {
        figures[figure.getPosition().getRowPos()][figure.getPosition().getColumnPos()] = figure;
    }

    /**
     * This method delete a figure from the array of figures.
     *
     * @param figure figure.
     */
    private void removeFigure(Figure figure) {
        this.figures[figure.getPosition().getRowPos()][figure.getPosition().getColumnPos()] = null;
    }

    /**
     * This method checks for the presence of the figure in the cell.
     * If the figure is, it returns true, otherwise false.
     *
     * @param cell cell.
     * @return true or false.
     * @throws FigureNotFoundException Exception.
     */
    private boolean checkFigure(Cell cell) throws FigureNotFoundException {
        boolean result;
        Figure figure = getFigure(cell);
        if (figure != null) {
            result = true;
        } else {
            throw new FigureNotFoundException("Figure not found!");
        }
        return result;
    }

    /**
     * This method checks the possibility of movement of the figure figure.
     * If the move is possible, it returns true, otherwise false.
     *
     * @param source source cell.
     * @param dist   dist cell.
     * @return true or false.
     * @throws OccupiedWayException    Exception.
     * @throws ImpossibleMoveException Exception.
     */
    private boolean checkWay(Cell source, Cell dist) throws OccupiedWayException, ImpossibleMoveException {
        boolean result = true;
        Figure figure = getFigure(source);
        Cell[] way = figure.way(dist);
        for (Cell cell : way) {
            if (getFigure(cell) != null) {
                throw new OccupiedWayException("The way is occupied!");
            }
        }
        return result;
    }
}

