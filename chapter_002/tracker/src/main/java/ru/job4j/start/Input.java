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
}
