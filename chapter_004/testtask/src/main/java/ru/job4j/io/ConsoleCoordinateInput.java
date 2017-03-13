package ru.job4j.io;

import ru.job4j.exception.OutOfGameFieldException;

import java.util.Scanner;

/**
 * The class ConsoleCoordinateInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public class ConsoleCoordinateInput implements SimpleInput, GameFieldInput {

    /**
     *Private field type of Scanner.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * This method asks the user and return a number.
     *
     * @param question is question.
     * @return number.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return sc.next();
    }

    /**
     * This method asks the user and return a number.
     *
     * @param question is question.
     * @param matrix   game field.
     * @return number.
     */
    @Override
    public int ask(String question, char[][] matrix) {
        int coord = Integer.valueOf(this.ask(question));
        boolean exist = false;
        if (coord >= 0 && coord < matrix.length) {
            exist = true;
        }
        if (exist) {
            return coord;
        } else {
            throw new OutOfGameFieldException(String.format("Coordinate must be >+ 0 and < %s", matrix.length));
        }
    }
}
