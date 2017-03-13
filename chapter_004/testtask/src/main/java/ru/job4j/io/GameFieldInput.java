package ru.job4j.io;

/**
 * The interface GameFieldInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public interface GameFieldInput {

    /**
     * This method asks the user and return a number.
     *
     * @param question is question.
     * @param matrix   game field.
     * @return number.
     */
    int ask(String question, char[][] matrix);
}
