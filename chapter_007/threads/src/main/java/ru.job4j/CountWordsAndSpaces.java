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
     * @throws InterruptedException InterruptedException.
     */
    public void count(String text) throws InterruptedException {
        System.out.println("The program start!");

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

        thread1.join(1000);
        if (thread1.isAlive()) {
            thread1.interrupt();
        }
        thread2.join(1000);
        if (thread2.isAlive()) {
            thread2.interrupt();
        }
        System.out.println("The program finish!");
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
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted() && matcher.find()) {
            count++;
        }
        if (currentThread.isInterrupted()) {
            count = -1;
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
        Thread currentThread = Thread.currentThread();
        for (Character character : symbols) {
            if (currentThread.isInterrupted()) {
                count = -1;
                break;
            }
            if (character == ' ') {
                count++;
            }
        }
        return count;
    }
}
