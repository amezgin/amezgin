package ru.job4j.io;

import ru.job4j.actions.UserAction;
import ru.job4j.exceptions.MenuOutException;

import java.util.List;
import java.util.Scanner;

/**
 * The class  ConsoleInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2017
 */
public class ConsoleInput implements Input {

    /**
     * Private field type of Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method asks the user and return answer.
     *
     * @param question is question.
     * @return answer.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    /**
     * This method asks question and number of range the user.
     *
     * @param question is question.
     * @param list     is list of action.
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
