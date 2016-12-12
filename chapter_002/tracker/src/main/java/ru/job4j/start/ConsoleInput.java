package ru.job4j.start;

import java.util.Scanner;

/**
 *The class  ConsoleInput.
 * @author Alexander Mezgin
 * @since 12.12.2016
 * @version 1.0
 */
public class ConsoleInput implements Input {

    /**
     *Private fild type of Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *This method asks the user and return answer.
     *@param question is question
     *@return answer
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }
}
