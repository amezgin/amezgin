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

    /**
     *This method asks question and number of range the user.
     *@param question is question
     *@param range is range
     *@return question
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int value : range){
            if(value == key){
                exist = true;
                break;
            }
        }
        if (exist){
            return key;
        }
        else {
            throw new MenuOutException("Out of menu range!");
        }
    }
}
