package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class TicTacToeValidatorWinTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 27.06.2017
 */
public class TicTacToeValidatorWinTest {

    /**
     * Test with result false.
     */
    @Test
    public void noWin() {
        TicTacToeValidatorWin ticTacToeValidatorWin = new TicTacToeValidatorWin(new int[][] {
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 0}
        });

        boolean result = ticTacToeValidatorWin.hasWinner();
        assertThat(result, is(false));
    }

    /**
     * Test with result true.
     */
    @Test
    public void hasWin() {
        TicTacToeValidatorWin ticTacToeValidatorWin = new TicTacToeValidatorWin(new int[][] {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0}
        });

        boolean result = ticTacToeValidatorWin.hasWinner();
        assertThat(result, is(true));
    }

    /**
     * Test with result false.
     */
    @Test
    public void noWin1() {
        TicTacToeValidatorWin ticTacToeValidatorWin = new TicTacToeValidatorWin(new int[][] {
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1}
        });

        boolean result = ticTacToeValidatorWin.hasWinner();
        assertThat(result, is(false));
    }

    /**
     * Test with result true.
     */
    @Test
    public void hasWin1() {
        TicTacToeValidatorWin ticTacToeValidatorWin = new TicTacToeValidatorWin(new int[][] {
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1}
        });

        boolean result = ticTacToeValidatorWin.hasWinner();
        assertThat(result, is(true));
    }
}