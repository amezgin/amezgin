package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * The class DictionaryTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 1.05.2017
 */
public class DictionaryTest {

    /**
     * Test method insert().
     */
    @Test
    public void whenAddElementShouldReturnSizeOne() {
        SimpleDictionary<Integer, String> test = new Dictionary<>(5);
        test.insert(1, "A");

        int result = test.getSize();

        assertThat(result, is(1));
    }

    /**
     * Test method get().
     */
    @Test
    public void whenAddElementShouldReturnThisElement() {
        SimpleDictionary<Integer, String> test = new Dictionary<>(5);
        test.insert(1, "A");
        test.insert(1, "B");

        String result = test.get(1);

        assertThat(result, is("B"));
    }

    /**
     * Test method delete().
     */
    @Test
    public void whenDeleteElementShouldReturnTrue() {
        SimpleDictionary<Integer, String> test = new Dictionary<>(5);
        test.insert(1, "A");
        test.insert(2, "B");

        assertTrue(test.delete(2));
    }

    /**
     * Test SimpleListContainer hasNext().
     */
    @Test
    public void whenAddsTwoStringsShouldReturnFalse() {
        SimpleDictionary<Integer, String> test = new Dictionary<>(5);
        test.insert(1, "A");
        test.insert(4, "B");
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
    public void whenGetNextShouldReturnTrue() {
        SimpleDictionary<Integer, String> test = new Dictionary<>(5);
        test.insert(1, "A");
        test.insert(3, "B");
        Iterator iterator = test.iterator();
        iterator.next();

        assertNotNull(iterator.next());
    }
}