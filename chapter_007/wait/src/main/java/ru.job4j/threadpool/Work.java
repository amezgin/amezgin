package ru.job4j.threadpool;

/**
 * The class Work.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 20.09.2017.
 */
public class Work {

    /**
     * The number of work.
     */
    private int index;

    /**
     * The constructor.
     *
     * @param index the number of work.
     */
    public Work(int index) {
        this.index = index;
    }

    /**
     * This method started work.
     */
    public void start() {
        System.out.println(String.format("%s does the work № %s", Thread.currentThread().getName(), this.index));
    }
}