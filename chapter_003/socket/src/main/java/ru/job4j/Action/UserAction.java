package ru.job4j.Action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The interface UserAction.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public interface UserAction {

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key
     */
    int key();

    /**
     * This method performs the main action.
     *
     * @param dis DataInputStream
     * @param dos DataOutputStream
     * @throws IOException IOException
     */
    void execute(DataInputStream dis, DataOutputStream dos) throws IOException;

    /**
     * This method returns information about what this method does.
     *
     * @return information
     */
    String info();
}
