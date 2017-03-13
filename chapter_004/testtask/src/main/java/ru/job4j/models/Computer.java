package ru.job4j.models;

import ru.job4j.action.UsersAction;

/**
 * The class Computer.
 * This class describes the computer players.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public class Computer implements UsersAction {

    /**
     * This field stores a symbol which the user plays.
     */
    private char symbol;

    /**
     * Game field.
     */
    private Field field;

    /**
     * The constructor.
     *
     * @param symbol game symbol.
     * @param field  game field.
     */
    public Computer(char symbol, Field field) {
        this.symbol = symbol;
        this.field = field;
    }

    /**
     * This method describes the course user.
     */
    @Override
    public void move() {
        int x;
        int y;
        do {
            x = (int) (Math.random() * this.field.getMatrix().length);
            y = (int) (Math.random() * this.field.getMatrix().length);
        } while (!this.field.getValue(x, y).equals(' '));
        this.field.setValue(x, y, this.symbol);
    }
}
