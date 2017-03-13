package ru.job4j.io;

import java.util.Scanner;

/**
 * The class ValidatorWin.
 * This class describes checks a winning combination.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.03.2017
 */
public class SimpleConsoleInput implements SimpleInput {

    /**
     * Private field type of Scanner.
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
}
