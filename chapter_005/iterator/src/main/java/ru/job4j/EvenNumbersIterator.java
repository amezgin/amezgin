package ru.job4j;

import java.util.Iterator;

/**
 * The class EvenNumbersIterator.
 * This class creat iterator then returned even numbers.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.02.2017
 */
public class EvenNumbersIterator implements Iterator {

    /**
     * Array of integer numbers.
     */
    private final int[] values;

    /**
     * The index.
     */
    private int index = 0;

    /**
     * The Constructor.
     *
     * @param values array of integer numbers.
     */
    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    /**
     * This method returned true if the iterator has more elements.
     *
     * @return true if the iterator has more elements.
     */
    @Override
    public boolean hasNext() {
        while (this.index < this.values.length) {
            if (this.values[this.index] % 2 == 0) {
                return true;
            }
            this.index++;
        }
        return false;
    }

    /**
     * This method returns the next even element in the iteration.
     *
     * @return the next even element in the iteration.
     */
    @Override
    public Integer next() {
        Integer result = null;
        while (this.index < this.values.length) {
            if (this.values[index] % 2 == 0) {
                result = this.values[this.index];
                this.index++;
                return result;
            }
            this.index++;
        }
        return result;
    }
}
