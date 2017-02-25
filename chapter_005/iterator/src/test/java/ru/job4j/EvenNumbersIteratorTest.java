package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class EvenNumbersIteratorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.02.2017
 */
public class EvenNumbersIteratorTest {

    /**
     * Test method next().
     */
    @Test
    public void whenGetNextCallShouldReturnPointerForward() {
        EvenNumbersIterator ei = new EvenNumbersIterator(new int[]{1, 5, -4, 1, 4});

        ei.next();
        int result = ei.next();

        assertThat(result, is(4));
    }

    /**
     * Test method hasNext() when returned true.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContaintValueTrue() {
        EvenNumbersIterator ei = new EvenNumbersIterator(new int[]{1, 5, -4, 4});

        ei.next();
        boolean result = ei.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test method hasNext() when returned false.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContaintValueFalse() {
        EvenNumbersIterator ei = new EvenNumbersIterator(new int[]{1, 5, -4, 4});

        ei.next();
        ei.next();
        boolean result = ei.hasNext();

        assertThat(result, is(false));
    }
}