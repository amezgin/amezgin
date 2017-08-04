package ru.job4j.stopthread;

/**
 * Class Time.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.08.2017
 */
public class Time implements Runnable {

    /**
     * The time.
     */
    private int time;

    /**
     * An object of type CountChar.
     */
    private CountChar countChar;

    /**
     * The Constructor.
     *
     * @param time      the time.
     * @param countChar an object of type CountChar.
     */
    public Time(int time, CountChar countChar) {
        this.time = time;
        this.countChar = countChar;
    }

    /**
     * The method run().
     */
    @Override
    public void run() {
        Thread thread = new Thread(this.countChar);
        thread.start();
        try {
            thread.join(this.time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (thread.isAlive()) {
            thread.interrupt();
        }
    }
}
