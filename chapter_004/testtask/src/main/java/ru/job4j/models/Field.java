package ru.job4j.models;

import ru.job4j.action.CreateFieldAction;
import ru.job4j.action.DrawFieldAction;

/**
 * The class Field.
 * This class describes the field of game.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public class Field implements DrawFieldAction, CreateFieldAction {

    /**
     * This field describes the game field.
     */
    private int sizeField;

    /**
     * This array describes the field of game.
     */
    private char[][] matrix;

    /**
     * It is constructor for default size field = 3.
     */
    public Field() {
        this.sizeField = 3;
        this.matrix = new char[3][3];
    }

    /**
     * The Constructor.
     *
     * @param sizeField the size game field.
     */
    public Field(int sizeField) {
        this.sizeField = sizeField;
        this.matrix = new char[this.sizeField][this.sizeField];
    }

    /**
     * Getter for matrix.
     *
     * @return matrix.
     */
    public char[][] getMatrix() {
        return this.matrix;
    }

    /**
     * This method return a character in a cell field of game.
     * If the coordinates are outside of the matrix, then the method returns null.
     *
     * @param x first coordinate.
     * @param y second coordinate.
     * @return a character in a cell field of game.
     */
    public Character getValue(int x, int y) {
        return this.matrix[x][y];
    }

    /**
     * This method set a symbol in a cell field of game.
     *
     * @param x      first coordinate.
     * @param y      second coordinate.
     * @param symbol game symbol.
     */
    public void setValue(int x, int y, Character symbol) {
        this.matrix[x][y] = symbol;
    }

    /**
     * This method draw the field a game.
     */
    @Override
    public void draw() {
        for (int i = getMatrix().length - 1; i >= 0; i--) {
            System.out.printf("%s ", i);
            for (int j = 0; j < getMatrix().length; j++) {
                System.out.printf("[%s]", getValue(i, j));
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < getMatrix().length; i++) {
            System.out.printf(" %s ", i);
        }
        System.out.println();
    }

    /**
     * This method create the field a game.
     */
    @Override
    public void create() {
        for (int i = 0; i < getMatrix().length; i++) {
            for (int j = 0; j < getMatrix().length; j++) {
                this.matrix[i][j] = ' ';
            }
        }
    }
}
