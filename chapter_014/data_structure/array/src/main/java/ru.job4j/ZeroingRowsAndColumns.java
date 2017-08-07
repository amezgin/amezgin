package ru.job4j;

/**
 * Class ZeroingRowsAndColumns.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.08.2017
 */
public class ZeroingRowsAndColumns {

    /**
     * Array.
     */
    private int[][] array;

    /**
     * The constructor.
     *
     * @param array array.
     */
    public ZeroingRowsAndColumns(int[][] array) {
        this.array = array;
    }

    /**
     * This method zeroing rows and columns if array contains zero.
     *
     * @return array.
     */
    public int[][] zeroing() {
        boolean[] zeroRow = new boolean[this.array.length];
        boolean[] zeroColumn = new boolean[this.array[0].length];

        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[0].length; j++) {
                if (this.array[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[0].length; j++) {
                if (zeroRow[i] || zeroColumn[j]) {
                    this.array[i][j] = 0;
                }
            }
        }
        return this.array;
    }
}
