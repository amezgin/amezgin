package ru.job4j;

import java.util.Iterator;

/**
 * The class PrimeNumbersIterator.
 * This class creat iterator then returned prime numbers.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.02.2017
 */
public class PrimeNumbersIterator implements Iterator {

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
    public PrimeNumbersIterator(int[] values) {
        this.values = values;
    }

    /**
     * This method returned true if the iterator has more elements.
     *
     * @return true if the iterator has more elements.
     */
    @Override
    public boolean hasNext() {
        boolean isPrime = false;
        while (this.index < this.values.length) {
            isPrime = numberIsPrime(this.values[index]);
            if (isPrime) {
                return isPrime;
            }
            this.index++;
        }
        return isPrime;
    }

    /**
     * This method returns the next even element in the iteration.
     *
     * @return the next even element in the iteration.
     */
    @Override
    public Integer next() {
        Integer result = null;
        boolean isPrime;
        while (this.index < this.values.length) {
            isPrime = numberIsPrime(this.values[index]);
            if (isPrime) {
                return this.values[index++];
            }
            this.index++;
        }
        return result;
    }

    /**
     * This method check that a number is prime.
     *
     * @param number checked number.
     * @return if a number is prime then returned true.
     */
    private boolean numberIsPrime(int number) {
        boolean isPrime = true;
        if (number == 1 || number < 0) {
            isPrime = false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
