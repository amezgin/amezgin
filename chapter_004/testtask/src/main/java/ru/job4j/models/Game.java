package ru.job4j.models;

import ru.job4j.action.UsersAction;
import ru.job4j.io.ConsoleCoordinateInput;
import ru.job4j.io.SimpleInput;

/**
 * The class Game.
 * This class describes the creation of the game.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.03.2017
 */
public class Game {

    /**
     * Game field.
     */
    private Field field;

    /**
     * Player.
     */
    private UsersAction player;

    /**
     * Computer.
     */
    private UsersAction computer;

    /**
     * Validator win.
     */
    private ValidatorWin validator;

    /**
     * Input coordinate from console.
     */
    private ConsoleCoordinateInput consoleCoordinateInput;

    /**
     * Simple input.
     */
    private SimpleInput simpleConsoleInput;

    /**
     * This field class determines the next move.
     */
    private boolean isFirstMove = false;

    /**
     * This field class determines the end game.
     */
    private boolean endGame = false;

    /**
     * This field class considers the count move.
     */
    private int numberMove;

    /**
     * The constructor.
     *
     * @param field                  game field.
     * @param validator              validator game win.
     * @param consoleCoordinateInput validator of input coordinate.
     * @param simpleConsoleInput     simple console input.
     */
    public Game(Field field, ValidatorWin validator,
                ConsoleCoordinateInput consoleCoordinateInput, SimpleInput simpleConsoleInput) {
        this.field = field;
        this.validator = validator;
        this.consoleCoordinateInput = consoleCoordinateInput;
        this.simpleConsoleInput = simpleConsoleInput;
    }

    /**
     * This method initialize the game.
     */
    public void init() {
        this.field.create();
        firstStart();
        this.field.draw();
        while (!this.endGame) {
            if (this.isFirstMove) {
                this.player.move();
                numberMove++;
                this.field.draw();
                this.isFirstMove = false;
                if (this.validator.validate()) {
                    System.out.println("Game over! Player win!");
                    this.endGame = true;
                }
            } else {
                this.computer.move();
                numberMove++;
                this.field.draw();
                this.isFirstMove = true;
                if (this.validator.validate()) {
                    System.out.println("Game over! Computer win!");
                    this.endGame = true;
                }
            }
            if (this.numberMove == this.field.getMatrix().length * this.field.getMatrix().length
                    && !this.validator.validate()) {
                System.out.println("Game over! Draw!");
                this.endGame = true;
            }
        }
    }

    /**
     * This method determines the first move.
     */
    private void firstStart() {
        int value;
        do {
            value = Integer.valueOf(this.simpleConsoleInput.ask("If the first player, enter 1. "
                    + "If the first goes to the computer, then enter 2."));
        } while (value != 1 && value != 2);
        if (value == 1) {
            isFirstMove = true;
            this.player = new Player('X', this.field, this.consoleCoordinateInput);
            this.computer = new Computer('O', this.field);
        } else {
            this.player = new Player('O', this.field, this.consoleCoordinateInput);
            this.computer = new Computer('X', this.field);
        }
    }
}
