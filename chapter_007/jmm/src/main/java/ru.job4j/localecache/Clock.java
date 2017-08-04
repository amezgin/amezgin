package ru.job4j.localecache;

/**
 * Class Clock.
 * In the run method, the variable isCancel the first time you use is cached for the child thread.
 * Calling cancel from another thread will change the value of the variable isCancel in the normal (slow) memory,
 * but not in the cache of the other threads.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.08.2017
 */
public class Clock implements Runnable {

    /**
     * This field describes the stop parameter.
     */
    private boolean isCancel = false;

    /**
     * This method setup stop parameter in value of true.
     */
    public void cancel() {
        this.isCancel = true;
    }

    /**
     * The run.
     */
    @Override
    public void run() {
        while (!this.isCancel) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tik");
        }
    }
}


