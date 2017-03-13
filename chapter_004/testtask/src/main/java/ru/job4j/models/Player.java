package ru.job4j.models;

import ru.job4j.action.UsersAction;
import ru.job4j.io.ConsoleCoordinateInput;

/**
 * The class Computer.
 * This class describes the human players.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public class Player implements UsersAction {

    /**
     * This field stores a symbol which the user plays.
     */
    private char symbol;

    /**
     * Game field.
     */
    private Field field;

    /**
     * ConsoleCoordinateInput.
     */
    private ConsoleCoordinateInput input;

    /**
     * The constructor.
     *
     * @param symbol game symbol.
     * @param field  game field.
     * @param input  type input.
     */
    public Player(char symbol, Field field, ConsoleCoordinateInput input) {
        this.symbol = symbol;
        this.field = field;
        this.input = input;
    }

    /**
     * This method describes the course user.
     */
    @Override
    public void move() {
        int x;
        int y;
        do {
            x = input.ask("Enter first coordinate on game field: ", this.field.getMatrix());
            y = input.ask("Enter second coordinate on game field: ", this.field.getMatrix());
        } while (!this.field.getValue(x, y).equals(' '));
        this.field.setValue(x, y, this.symbol);
    }
}
