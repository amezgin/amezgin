package ru.job4j.io;

import ru.job4j.exception.OutOfGameFieldException;

/**
 * The class ValidateCoordinateInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.03.2017
 */
public class ValidateCoordinateInput extends ConsoleCoordinateInput {

    /**
     * This method asks the user and return a number.
     *
     * @param question is question.
     * @param matrix   game field.
     * @return number.
     */
    @Override
    public int ask(String question, char[][] matrix) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, matrix);
                invalid = false;
            } catch (OutOfGameFieldException e) {
                System.out.println("Please select correct coordinate from game field!");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate date again!");
            }
        } while (invalid);
        return value;
    }
}
