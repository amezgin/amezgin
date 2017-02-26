package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class PrimeNumbersIteratorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.02.2017
 */
public class PrimeNumbersIteratorTest {

    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldReturnPointerForward() {
        PrimeNumbersIterator pni = new PrimeNumbersIterator(new int[]{1, 5, -4, 3, 4});

        pni.next();
        int result = pni.next();

        assertThat(result, is(3));
    }

    /**
     * Test method hasNext() when returned true.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContainValueTrue() {
        PrimeNumbersIterator pni = new PrimeNumbersIterator(new int[]{1, 5, 5, 4});

        pni.next();
        boolean result = pni.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test method hasNext() when returned false.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContainValueFalse() {
        PrimeNumbersIterator pni = new PrimeNumbersIterator(new int[]{1, 5, -5, 4});

        pni.next();
        pni.next();
        boolean result = pni.hasNext();

        assertThat(result, is(false));
    }
}