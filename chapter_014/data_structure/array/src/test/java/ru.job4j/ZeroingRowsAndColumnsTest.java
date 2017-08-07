package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class ZeroingRowsAndColumnsTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.08.2017
 */
public class ZeroingRowsAndColumnsTest {

    /**
     * Test when result returns original array.
     */
    @Test
    public void whenArrayNotContainZeroThenReturnOriginalArray() {
        int[][] array = new int[][]{{1, 2, 3},
                                    {4, 5, 6},
                                    {7, 8, 9}};
        ZeroingRowsAndColumns test = new ZeroingRowsAndColumns(array);

        int[][] result = test.zeroing();

        assertArrayEquals(result, array);
    }

    /**
     * Test when result returns zeroing array.
     */
    @Test
    public void whenArrayContainZeroThenReturnZeroingArray() {
        int[][] array = new int[][]{{1, 2, 3},
                                    {4, 0, 6},
                                    {7, 8, 0}};
        int[][] resultArray = new int[][]{{1, 0, 0},
                                          {0, 0, 0},
                                          {0, 0, 0}};
        ZeroingRowsAndColumns test = new ZeroingRowsAndColumns(array);


        int[][] result = test.zeroing();

        assertArrayEquals(result, resultArray);
    }
}