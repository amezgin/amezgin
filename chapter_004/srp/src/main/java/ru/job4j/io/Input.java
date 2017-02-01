package ru.job4j.io;

import ru.job4j.actions.UserAction;

import java.util.List;

/**
 * The interface Input.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2017
 */
public interface Input {

    /**
     * This method asks the user.
     *
     * @param question is question.
     * @return question.
     */
    String ask(String question);

    /**
     * This method asks question and number of range the user.
     *
     * @param question is question.
     * @param list     is list of user action.
     * @return question.
     */
    int ask(String question, List<UserAction> list);
}
