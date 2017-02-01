package ru.job4j.actions;

import ru.job4j.io.Input;

/**
 * The interface UserAction.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2017
 */
public interface UserAction {

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key.
     */
    int key();

    /**
     * This method performs the main action.
     *
     * @param input is input interface.
     * @return double valur
     */
    double execute(Input input);

    /**
     * This method returns information about what this method does.
     *
     * @return information.
     */
    String info();
}

