package ru.job4j.models;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Test for class Cell.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.01.2017
 */
public class CellTest {

    /**
     * Test for method getRowPos().
     */
    @Test
    public void whenGetRowPosThenReturnNumberRow() {
        Cell cell = new Cell(2, 1);

        int result = cell.getRowPos();

        assertThat(result, is(2));
    }

    /**
     * Test for method getColumnPos().
     */
    @Test
    public void whenGetColumnPosThenReturnNumberColumn() {
        Cell cell = new Cell(2, 1);

        int result = cell.getColumnPos();

        assertThat(result, is(1));
    }

    /**
     * Test for method toString().
     */
    @Test
    public void whenCallToStringThenReturnString() {
        Cell cell = new Cell(0, 2);

        String result = cell.toString();

        String checked = "Cell(0, 2)";

        assertThat(result, is(checked));
    }

    /**
     * Test for method equals() when return equals.
     */
    @Test
    public void whenCallEqualsThenReturnEquals() {
        Cell checkedCell = new Cell(0, 2);

        Cell resultCell = new Cell(0, 2);

        assertEquals(checkedCell, resultCell);
    }

    /**
     * Test for method equals() when return not equals.
     */
    @Test
    public void whenCallEqualsThenReturnNotEquals() {
        Cell checkedCell = new Cell(0, 2);

        Cell resultCell = new Cell(1, 1);

        assertNotEquals(checkedCell, resultCell);
    }
}
