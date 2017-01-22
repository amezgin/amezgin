package ru.job4j.Action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The interface Input.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public interface Input {
    /**
     * This method asks the user.
     *
     * @param question is question
     * @param dis      DataInputStream
     * @param dos      DataOutputStream
     * @return question
     * @throws IOException IOException
     */
    String ask(String question, DataInputStream dis, DataOutputStream dos) throws IOException;

    /**
     * This method asks question and number of range the user.
     *
     * @param question is question
     * @param range    is range
     * @param dis      DataInputStream
     * @param dos      DataOutputStream
     * @return question
     * @throws IOException IOException
     */
    int ask(String question, int[] range, DataInputStream dis, DataOutputStream dos) throws IOException;
}
