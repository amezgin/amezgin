package ru.job4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class CountWordsAndSpaces.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 30.07.2017
 */
public class CountWordsAndSpaces {

    /**
     * This method counts the number of words and spaces in text in 2 threads.
     *
     * @param text text.
     */
    public void count(String text) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("This text contains %d words", countWords(text)));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("This text contains %d spaces", countSpaces(text)));
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * This method counts the number of words in text.
     *
     * @param text text.
     * @return count words.
     */
    private int countWords(String text) {
        int count = 0;
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * This method counts the number of spaces in text.
     *
     * @param text text.
     * @return count spaces.
     */
    private int countSpaces(String text) {
        int count = 0;
        char[] symbols = text.toCharArray();
        for (Character character : symbols) {
            if (character == ' ') {
                count++;
            }
        }
        return count;
    }
}
