package ru.job4j.io;

import ru.job4j.actions.UserAction;
import ru.job4j.exceptions.MenuOutException;

import java.util.List;

/**
 * The class ValidateInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2017
 */
public class ValidateInput extends ConsoleInput {

    /**
     * The method asks number from the range.
     *
     * @param question is question.
     * @param list     is list of user action.
     * @return question.
     */
    @Override
    public int ask(String question, List<UserAction> list) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, list);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please select correct key from menu!");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate date again!");
            }
        } while (invalid);
        return value;
    }
}