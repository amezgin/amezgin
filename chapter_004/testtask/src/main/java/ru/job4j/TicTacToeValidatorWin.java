package ru.job4j;

/**
 * The class TicTacToeValidatorWin.
 * This class checks the winning combination.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 27.06.2017
 */
public class TicTacToeValidatorWin {

    /**
     * This field counts the number of consecutive identical symbols.
     */
    private int count = 1;

    /**
     * The game field.
     */
    private int[][] field;

    /**
     * The Construct.
     *
     * @param field game field.
     */
    public TicTacToeValidatorWin(int[][] field) {
        this.field = field;
    }

    /**
     * This method checks the winning combination.
     *
     * @return true if there is a winner otherwise false.
     */
    public boolean hasWinner() {
        boolean result = false;
        for (int x = 0; x < this.field.length; x++) {
            for (int y = 0; y < this.field[0].length; y++) {
                if (checkWin(this.count, x, y, 0, 1) || checkWin(this.count, x, y, 1, 0)
                        || checkWin(this.count, x, y, 1, 1)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * This method check win in any line.
     * @param count count.
     * @param x start coordinate on horizontal.
     * @param y start coordinate on vertical.
     * @param dX increment.
     * @param dY increment.
     * @return true if in any line is a winner otherwise false.
     */
    private boolean checkWin(int count, int x, int y, int dX, int dY) {
        boolean result = false;
        if (count == 3 && (this.field.length < 5 || this.field[0].length < 5)) {
            result = true;
        } else if (count == 5 && this.field.length >= 5 && this.field[0].length >= 5) {
            result = true;
        } else {
            if (x + dX < this.field.length && y + dY < this.field[0].length
                    && this.field[x][y] == this.field[x + dX][y + dY]) {
                result = checkWin(count + 1, x + dX, y + dY, dX, dY);
            }
        }
        return result;
    }
}
