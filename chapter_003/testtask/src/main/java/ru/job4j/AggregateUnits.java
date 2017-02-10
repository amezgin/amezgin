package ru.job4j;

/**
 * The class AggregateUnits.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 10.02.2017
 */
public class AggregateUnits {

    /**
     * This field description the size of array.
     */
    private int sizeArray;

    /**
     * This field description the size of inner array.
     */
    private int sizeInnerArray;

    /**
     * This field description the source array.
     */
    private int[][] sourceArray;

    /**
     * This field description the visited cells in to array.
     */
    private boolean[][] visitedArray;

    /**
     * The Constructor.
     *
     * @param sourceArray source array.
     */
    public AggregateUnits(int[][] sourceArray) {
        this.sourceArray = sourceArray;
        this.sizeArray = sourceArray.length;
        this.sizeInnerArray = sourceArray[0].length;
        this.visitedArray = new boolean[this.sizeArray][this.sizeInnerArray];
    }

    /**
     * This method find the maximal count aggregate units.
     *
     * @return maximal count aggregate units.
     */
    public int findAgregate() {
        int countMax = 0;
        int count;
        for (int i = 0; i < this.sizeArray; i++) {
            for (int j = 0; j < this.sizeInnerArray; j++) {
                count = passArray(i, j);
                if (count > countMax) {
                    countMax = count;
                }
            }
        }
        return countMax;
    }

    /**
     * This method check the adjacent cells.
     *
     * @param i the first coordinate of cell.
     * @param j the second coordinate of cell.
     * @return the count aggregate units.
     */
    private int passArray(int i, int j) {
        int count = 0;
        if (i >= 0 && i < this.sizeArray && j >= 0 && j < this.sizeInnerArray) {
            if (!this.visitedArray[i][j]) {
                this.visitedArray[i][j] = true;
                if (this.sourceArray[i][j] == 1) {
                    count++;
                    count += passArray(i, j + 1);
                    count += passArray(i + 1, j);
                    count += passArray(i, j - 1);
                    count += passArray(i - 1, j);
                }
            }
        }
        return count;
    }
}
