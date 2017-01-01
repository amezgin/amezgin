package ru.job4j;

import org.junit.Test;
import ru.job4j.ChessExceptions.FigureNotFoundException;
import ru.job4j.ChessExceptions.ImpossibleMoveException;
import ru.job4j.ChessExceptions.OccupiedWayException;
import ru.job4j.models.Bishop;
import ru.job4j.models.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test for class Board.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.01.2017
 */
public class BoardTest {

    /**
     * Test for method move() without exception.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     * @throws FigureNotFoundException - "Figure not found!".
     * @throws OccupiedWayException    - "The way is occupied!".
     */
    @Test
    public void whenMoveThenReturnTrue() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.fillBoard();

        Cell source = new Cell(0, 2);
        Cell dist = new Cell(2, 0);

        Boolean result = board.move(source, dist);

        assertThat(result, is(true));
    }

    /**
     * Test for method move() with OccupiedWayException.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     * @throws FigureNotFoundException - "Figure not found!".
     * @throws OccupiedWayException    - "The way is occupied!".
     */
    @Test(expected = OccupiedWayException.class)
    public void whenIncorrectMoveThenReturnOccupiedWayException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.fillBoard();

        Cell source = new Cell(0, 2);
        Cell dist = new Cell(2, 0);

        board.addFigure(new Bishop(new Cell(1, 1), false));

        board.move(source, dist);
    }

    /**
     * Test for method move() with FigureNotFoundException.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     * @throws FigureNotFoundException - "Figure not found!".
     * @throws OccupiedWayException    - "The way is occupied!".
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenIncorrectMoveThenReturnFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.fillBoard();

        Cell source = new Cell(0, 3);
        Cell dist = new Cell(2, 0);

        board.addFigure(new Bishop(new Cell(1, 1), false));

        board.move(source, dist);
    }

    /**
     * Test for method move() with ImpossibleMoveException.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     * @throws FigureNotFoundException - "Figure not found!".
     * @throws OccupiedWayException    - "The way is occupied!".
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenIncorrectMoveThenReturnImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        board.fillBoard();

        Cell source = new Cell(0, 2);
        Cell dist = new Cell(3, 0);

        board.move(source, dist);
    }

    /**
     * Test for method addFigure().
     */
    @Test
    public void wenAddFigureThenReturnNotNull() {
        Board board = new Board();
        board.fillBoard();

        board.addFigure(new Bishop(new Cell(1, 1), false));

        assertNotNull(board.getFigure(new Cell(1, 1)));
    }

    /**
     * Test for method getFigure().
     */
    @Test
    public void wenGetFigureThenReturnFigure() {
        Board board = new Board();
        board.fillBoard();

        assertNotNull(board.getFigure(new Cell(0, 2)));
    }

    /**
     * Test for method getFigure() when return null.
     */
    @Test
    public void wenGetFigureThenReturnNull() {
        Board board = new Board();
        board.fillBoard();

        assertNull(board.getFigure(new Cell(1, 1)));
    }
}
