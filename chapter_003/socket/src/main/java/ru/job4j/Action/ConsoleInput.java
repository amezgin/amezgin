package ru.job4j.Action;

import ru.job4j.Exception.MenuOutException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The class ConsoleInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public class ConsoleInput implements Input {

    /**
     * This method asks the user and return answer.
     *
     * @param question is question
     * @param dis      DataInputStream
     * @param dos      DataOutputStream
     * @return answer
     */
    @Override
    public String ask(String question, DataInputStream dis, DataOutputStream dos) throws IOException {
        dos.writeUTF(question);
        return new Scanner(dis.readUTF()).nextLine();
    }

    /**
     * This method asks question and number of range the user.
     *
     * @param question is question
     * @param range    is range
     * @param dis      DataInputStream
     * @param dos      DataOutputStream
     * @return question
     */
    @Override
    public int ask(String question, int[] range, DataInputStream dis, DataOutputStream dos) throws IOException {
        int key = Integer.valueOf(this.ask(question, dis, dos));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range!");
        }
    }
}

