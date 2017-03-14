package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleArrayTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.03.2017
 */
public class SimpleArrayTest {

    /**
     * Test for method add() and get().
     */
    @Test
    public void whenAddOneElementThenReturnThisElement() {
        SimpleArray<String> array = new SimpleArray<>(1);
        String checked = "Mama";
        array.add(checked);

        String result = array.get(0);

        assertThat(result, is(checked));
    }

    /**
     * Test for method delete().
     */
    @Test
    public void whenDeleteOneElementThenReturnNull() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("Papa");
        array.add("Mama");
        array.delete(1);

        String result = array.get(1);

        assertNull(result);
    }

    /**
     * Test for method update().
     */
    @Test
    public void whenUpdateOneElementThenReturnUpdateElement() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        array.add(0);
        array.add(1);
        array.add(1);
        array.update(1, 2);

        int result = array.get(1);

        assertThat(result, is(2));
    }
}