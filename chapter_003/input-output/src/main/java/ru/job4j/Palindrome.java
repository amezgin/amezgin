package ru.job4j;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * The class Palindrome.
 * This class checks whether a word of five letters the user entered a palindrome.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 08.01.2017
 */
public class Palindrome {
    /**
     * This method checks whether word is a palindrome.
     *
     * @param is InputStream.
     * @return true if word is a palindrome.
     * @throws IOException - IOException.
     */
    public boolean isPalindrome(InputStream is) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            boolean result;
            String string = reader.readLine();
            if (string.length() == 5) {
                StringBuilder reversStr = new StringBuilder(string).reverse();
                if (string.equalsIgnoreCase(reversStr.toString())) {
                    result = true;
                    System.out.println(string + " is the palindrome!");
                } else {
                    result = false;
                    System.out.println(string + " is not the palindrome!");
                }
            } else {
                result = false;
                System.out.println("Checked word is not made up of 5 characters!");
            }
            return result;
        }
    }
}
