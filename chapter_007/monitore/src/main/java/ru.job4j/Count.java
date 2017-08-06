package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Count.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
@ThreadSafe
public class Count {

    /**
     * The value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * This method increment the value.
     */
    public void increment() {
        synchronized (this) {
            this.value++;
        }
    }

    /**
     * This method return value.
     *
     * @return value.
     */
    public int getValue() {
        synchronized (this) {
            return this.value;
        }
    }
}
