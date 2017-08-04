package ru.job4j.localecache;

/**
 * Class Main.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.08.2017
 */
public class Main {
    /**
     * The main method.
     *
     * @param args arguments.
     * @throws InterruptedException InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread thread = new Thread(clock);
        thread.start();
        Thread.sleep(10000);
        clock.cancel();
    }
}
