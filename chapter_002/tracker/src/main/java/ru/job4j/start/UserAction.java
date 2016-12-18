package ru.job4j.start;

/**
 *The interface UserAction.
 * @author Alexander Mezgin
 * @since 18.12.2016
 * @version 1.0
 */
public interface UserAction {

    /**
     *This method asks for the key on which the user performs an action.
     *@return key
     */
    int key();

    /**
     *This method performs the main action.
     *@param input is input interface
     *@param tracker is base class
     */
    void execute(Input input, Tracker tracker);

    /**
     *This method returns information about what this method does.
     *@return information
     */
    String info();
}
