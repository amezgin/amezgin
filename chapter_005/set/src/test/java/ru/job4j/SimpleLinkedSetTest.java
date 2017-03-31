package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleLinkedSetTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.03.2017
 */
public class SimpleLinkedSetTest {

    /**
     * Test method add().
     */
    @Test
    public void whenAddDuplicateShouldReturnSetWithoutDuplicate() {
        SimpleLinkedSet<String> test = new SimpleLinkedSet<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("1");

        int result = test.getSize();

        assertThat(result, is(3));
    }

    /**
     * Test SimpleArrayContainer iterator().
     */
    @Test
    public void whenAddsTwoStringsShouldReturnFalse() {
        SimpleLinkedSet<String> test = new SimpleLinkedSet<>();
        test.add("1");
        test.add("2");
        Iterator iterator = test.iterator();
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
        SimpleLinkedSet<Integer> test = new SimpleLinkedSet<>();
        test.add(1);
        test.add(2);
        Iterator iterator = test.iterator();
        iterator.next();

        Integer result = (Integer) iterator.next();

        assertThat(result, is(2));
    }
}