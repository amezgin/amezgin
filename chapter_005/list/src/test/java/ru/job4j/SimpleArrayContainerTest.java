package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleArrayContainerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 */
public class SimpleArrayContainerTest {

    /**
     * Test initialCapacity < 0.
     *
     * @throws Exception IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenInitialCapacityIsNegativeThenThrowException() {
        new SimpleArrayContainer<>(-5);
    }

    /**
     * Test SimpleArrayContainer.
     */
    @Test
    public void whenAddsIntegerShouldReturnThisValue() {
        SimpleArrayContainer<Integer> test = new SimpleArrayContainer<>(0);
        test.add(55);

        int result = test.get(0);

        assertThat(result, is(55));
    }

    /**
     * Test SimpleArrayContainer iterator().
     */
    @Test
    public void whenAddsTwoStringsShouldReturnFalse() {
        SimpleArrayContainer<String> test = new SimpleArrayContainer<>(2);
        Iterator iterator = test.iterator();
        test.add("1");
        test.add("2");
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test SimpleArrayContainer iterator().
     */
    @Test
    public void whenAddsTwoIntegerShouldReturnNext() {
        SimpleArrayContainer<Integer> test = new SimpleArrayContainer<>(2);
        Iterator iterator = test.iterator();
        test.add(1);
        test.add(2);
        iterator.next();

        Integer result = (Integer) iterator.next();

        assertThat(result, is(2));
    }
}