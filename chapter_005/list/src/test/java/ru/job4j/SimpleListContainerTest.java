package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleListContainerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 */
public class SimpleListContainerTest {

    /**
     * Test method add().
     */
    @Test
    public void whenAddElementShouldReturnSize() {
        SimpleListContainer<Integer> test = new SimpleListContainer<>();
        test.add(56);
        test.add(34);
        test.add(3);

        int result = test.getSize();

        assertThat(result, is(3));
    }

    /**
     * Test method get().
     */
    @Test
    public void whenAddElementShouldReturnThisElement() {
        SimpleListContainer<Integer> test = new SimpleListContainer<>();
        test.add(56);
        test.add(43);
        test.add(56);
        test.add(3);

        int result = test.get(3);

        assertThat(result, is(3));
    }

    /**
     * Test method remove().
     */
    @Test
    public void whenRemoveElementShouldReturnSizeMinusOne() {
        SimpleListContainer<Integer> test = new SimpleListContainer<>();
        test.add(56);
        test.add(43);
        test.add(56);
        test.add(3);
        test.remove(2);

        int result = test.getSize();

        assertThat(result, is(3));
    }

    /**
     * Test SimpleListContainer hasNext().
     */
    @Test
    public void whenAddsTwoStringsShouldReturnFalse() {
        SimpleListContainer<Integer> test = new SimpleListContainer<>();
        test.add(1);
        test.add(2);
        Iterator iterator = test.iterator();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test SimpleListContainer next().
     */
    @Test
    public void whenAddsTwoIntegerShouldReturnNext() {
        SimpleListContainer<Integer> test = new SimpleListContainer<>();
        test.add(1);
        test.add(2);
        Iterator iterator = test.iterator();
        iterator.next();

        Integer result = (Integer) iterator.next();

        assertThat(result, is(2));
    }
}