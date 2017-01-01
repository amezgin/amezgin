package ru.job4j.models;

import org.junit.Test;
import ru.job4j.ChessExceptions.ImpossibleMoveException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Test for class Bishop.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.12.2016
 */
public class BishopTest {

    /**
     * Test for method way() with ImpossibleMoveException.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenGetWayThemReturnException() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 2), true);

        Cell dist = new Cell(3, 0);

        bishop.way(dist);
    }

    /**
     * Test for method way() without exception.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     */
    @Test
    public void whenGetWayThemReturnArrayCell() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 2), true);

        Cell dist = new Cell(2, 0);

        Cell[] checked = bishop.way(dist);

        Cell[] result = {new Cell(1, 1), new Cell(2, 0)};

        assertArrayEquals(result, checked);
    }

    /**
     * Test for method clone().
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     */
    @Test
    public void whenCallCloneThenReturnNewPosition() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 2), true);

        Cell dist = new Cell(2, 0);

        Figure[] figures = new Figure[1];
        figures[0] = bishop.clone(dist);

        assertNotNull(figures[0]);
    }

    /**
     * Test for method clone() with ImpossibleMoveException.
     *
     * @throws ImpossibleMoveException - "You cannot move to the desired location!".
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenCallCloneThenReturnException() throws ImpossibleMoveException {
        Bishop bishop = new Bishop(new Cell(0, 2), true);

        Cell dist = new Cell(8, 0);

        bishop.clone(dist);
    }

    /**
     * Test for method toString().
     */
    @Test
    public void whenCallToStringThenReturnString() {
        Bishop bishop = new Bishop(new Cell(0, 2), true);

        String result = bishop.toString();

        String checked = "Bishop((0, 2), white)";

        assertThat(result, is(checked));
    }
}

