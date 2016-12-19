package ru.job4j.start;

/**
 *The interface Input.
 * @author Alexander Mezgin
 * @since 12.12.2016
 * @version 1.0
 */
public interface Input {

    /**
     *This method asks the user.
     *@param question is question
     *@return question
     */
    String ask(String question);

    /**
     *This method asks question and number of range the user.
     *@param question is question
     *@param range is range
     *@return question
     */
    int ask(String question, int[] range);
}
