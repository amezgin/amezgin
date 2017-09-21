package ru.job4j;

/**
 * The class MySimpleLock.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 20.09.2017.
 */
public class MySimpleLock {

    /**
     * The lock factor.
     */
    private boolean lockFactor = false;

    /**
     * This method locked the object.
     *
     * @throws InterruptedException InterruptedException.
     */
    public synchronized void lock() throws InterruptedException {
        while (this.lockFactor) {
            wait();
        }

        this.lockFactor = true;
    }

    /**
     * This method unlocked the object.
     *
     * @throws InterruptedException InterruptedException.
     */
    public synchronized void unlock() throws InterruptedException {
        this.lockFactor = false;
        notifyAll();
    }
}
