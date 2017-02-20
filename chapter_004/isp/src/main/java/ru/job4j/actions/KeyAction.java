package ru.job4j.actions;

/**
 * The interface KeyAction.
 * This interface description a simple action.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public interface KeyAction {

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key.
     */
    String key();
}
