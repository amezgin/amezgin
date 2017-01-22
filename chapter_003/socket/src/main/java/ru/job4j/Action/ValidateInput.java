package ru.job4j.Action;

import ru.job4j.Exception.MenuOutException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * The class ValidateInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * The method asks number from the range.
     *
     * @param question
     * @param range
     * @param dis      DataInputStream
     * @param dos      DataOutputStream
     * @return answer
     */
    @Override
    public int ask(String question, int[] range, DataInputStream dis, DataOutputStream dos) throws IOException {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range, dis, dos);
                invalid = false;
            } catch (MenuOutException e) {
                dos.writeUTF("Please select correct key from menu!");
            } catch (NumberFormatException e) {
                dos.writeUTF("Please enter validate date again!");
            }
        } while (invalid);
        return value;
    }
}
