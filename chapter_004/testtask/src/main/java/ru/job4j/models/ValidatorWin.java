package ru.job4j.models;

/**
 * The class ValidatorWin.
 * This class describes checks a winning combination.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.03.2017
 */
public class ValidatorWin {

    /**
     * Game field.
     */
    private Field field;

    /**
     * The constructor.
     *
     * @param field game field.
     */
    public ValidatorWin(Field field) {
        this.field = field;
    }

    /**
     * This method checks a winning combination.
     *
     * @return true if the combination is winning.
     */
    public boolean validate() {
        return mainDiagonalValidate() || sideDiagonalValidate() || horizontalValidate() || verticalValidate();
    }

    /**
     * This method checks a winning combination on main diagonal.
     *
     * @return true if the combination is winning.
     */
    private boolean mainDiagonalValidate() {
        boolean result = false;
        int countSymb = 1;
        for (int i = 0; i < this.field.getMatrix().length - 1; i++) {
            if (this.field.getValue(i, i).equals(' ')) {
                continue;
            }
            if (this.field.getValue(i, i).equals(this.field.getValue(i + 1, i + 1))) {
                countSymb++;
            } else {
                countSymb = 1;
            }
            if (countSymb == 3 && this.field.getMatrix().length <= 5) {
                return true;
            }
            if (countSymb == 5 && this.field.getMatrix().length >= 5) {
                return true;
            }
        }
        return result;
    }

    /**
     * This method checks a winning combination on side diagonal.
     *
     * @return true if the combination is winning.
     */
    private boolean sideDiagonalValidate() {
        boolean result = false;
        int countSymb = 1;
        int coordX = 0;
        for (int i = this.field.getMatrix().length - 1; i > 0; i--) {
            if (this.field.getValue(coordX, this.field.getMatrix().length - 1).equals(' ')) {
                continue;
            }
            if (this.field.getValue(coordX, i).equals(this.field.getValue(coordX + 1, i - 1))) {
                countSymb++;
                coordX++;
            } else {
                countSymb = 1;
            }
            if (countSymb == 3 && this.field.getMatrix().length <= 5) {
                return true;
            }
            if (countSymb == 5 && this.field.getMatrix().length >= 5) {
                return true;
            }
        }
        return result;
    }

    /**
     * This method checks a winning combination on horizontal.
     *
     * @return true if the combination is winning.
     */
    private boolean horizontalValidate() {
        int countSymb = 1;
        for (int i = 0; i < this.field.getMatrix().length - 1; i++) {
            for (int j = 0; j < this.field.getMatrix().length - 1; j++) {
                if (this.field.getValue(i, j).equals(' ')) {
                    continue;
                }
                if (this.field.getValue(i, j).equals(this.field.getValue(i, j + 1))) {
                    countSymb++;
                } else {
                    countSymb = 1;
                }
                if (countSymb == 3 && this.field.getMatrix().length <= 5) {
                    return true;
                }
                if (countSymb == 5 && this.field.getMatrix().length >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks a winning combination on vertical.
     *
     * @return true if the combination is winning.
     */
    private boolean verticalValidate() {
        int countSymb = 1;
        int coordY = 0;
        do {
            for (int i = 0; i < this.field.getMatrix().length - 1; i++) {
                if (this.field.getValue(i, coordY).equals(' ')) {
                    countSymb = 1;
                    continue;
                }
                if (this.field.getValue(i, coordY).equals(this.field.getValue(i + 1, coordY))) {
                    countSymb++;
                } else {
                    countSymb = 1;
                }
                if (countSymb == 3 && this.field.getMatrix().length <= 5) {
                    return true;
                }
                if (countSymb == 5 && this.field.getMatrix().length >= 5) {
                    return true;
                }
            }
            coordY++;
        } while (coordY < this.field.getMatrix().length);
        return false;
    }
}
