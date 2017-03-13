package ru.job4j;

import ru.job4j.io.ConsoleCoordinateInput;
import ru.job4j.io.SimpleConsoleInput;
import ru.job4j.io.SimpleInput;
import ru.job4j.io.ValidateCoordinateInput;
import ru.job4j.models.Field;
import ru.job4j.models.Game;
import ru.job4j.models.ValidatorWin;

/**
 * The class Main.
 * This class run the game.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.03.2017
 */
public class Main {
    /**
     * Main method.
     *
     * @param args args.
     */
    public static void main(String[] args) {

        Field field = new Field();
        ValidatorWin validatorWin = new ValidatorWin(field);
        ConsoleCoordinateInput consoleCoordinateInput = new ValidateCoordinateInput();
        SimpleInput simpleInput = new SimpleConsoleInput();
        Game game = new Game(field, validatorWin, consoleCoordinateInput, simpleInput);
        game.init();
    }
}
