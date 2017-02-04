package ru.job4j;

import ru.job4j.actions.UserAction;
import ru.job4j.exceptions.MenuOutException;
import ru.job4j.io.Input;

import java.util.List;

/**
 * The class  StubInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.01.2017
 */
public class StubInput implements Input {

    /**
     * Private field the array of answers.
     */
    private final String[] answers;
    /**
     * Private field position.
     */
    private int position = 0;

    /**
     * The class constructor.
     *
     * @param answers the array of answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * This method asks the user and return answer.
     *
     * @param question is question.
     * @return answer.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * This method asks question and number of range the user.
     *
     * @param question is question.
     * @param list    is list.
     * @return question.
     */
    @Override
    public int ask(String question, List<UserAction> list) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (UserAction aList : list) {
            if (aList.key() == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range!");
        }
    }
}
