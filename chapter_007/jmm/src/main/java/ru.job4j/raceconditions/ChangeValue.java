package ru.job4j.raceconditions;

/**
 * Class ChangeValue.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.08.2017
 */
public class ChangeValue implements Runnable {

    /**
     * The value.
     */
    private int value = 0;

    /**
     * This method increment the value.
     */
    private void incrementValue() {
        this.value++;
    }

    /**
     * This method return the value.
     *
     * @return value.
     */
    public int getValue() {
        return value;
    }

    /**
     * The run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            incrementValue();
        }
    }
}
