package ru.job4j.models;

/**
 * The class Cell.
 * This class description the model of the cell chess board.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.12.2016
 */
public class Cell {

    /**
     * This field describes the position of the cell horizontally.
     */
    private int rowPos;

    /**
     * This field describes the position of the cell vertically.
     */
    private int columnPos;

    /**
     * Construct a new Cell.
     *
     * @param rowPos    the position of the cell horizontally.
     * @param columnPos the position of the cell vertically.
     */
    public Cell(int rowPos, int columnPos) {
        this.rowPos = rowPos;
        this.columnPos = columnPos;
    }

    /**
     * It's getter for the position of the cell horizontally.
     *
     * @return the position of the cell horizontally.
     */
    public int getRowPos() {
        return rowPos;
    }

    /**
     * It's getter for the position of the cell vertically.
     *
     * @return the position of the cell vertically.
     */
    public int getColumnPos() {
        return columnPos;
    }

    @Override
    public String toString() {
        return "Cell("
                + this.rowPos
                + ", " + this.columnPos
                + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getRowPos();
        result = prime * result + this.getColumnPos();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        if (cell.getColumnPos() == this.getColumnPos() && cell.getRowPos() == this.getRowPos()) {
            return true;
        }
        return false;
    }
}
