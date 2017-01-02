package ru.job4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The class EvenNumber.
 * This class implements a method which check the number from the byte stream to the parity.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.01.2017
 */
public class EvenNumber {

    /**
     * This method check the number from the byte stream to the parity.
     *
     * @param in is InputStream.
     * @return "true" if number in the stream is the parity.
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 0) {
                result = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("In the stream is not a number!");
            throw e;
        } catch (IOException e) {
            System.out.println("IOException!");
        }
        return result;
    }
}
