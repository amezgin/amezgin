package ru.job4j;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class BinarySearchTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 11.07.2017
 */
public class BinarySearchTest {
    /**
     * Test method findIndex() when return result index.
     */
    @Test
    public void whenGetStringThenReturnIndex() {
        String[] startArray = {"Bob", "Adam", "Asteriks", "Obeliks", "Rick"};
        BinarySearch test = new BinarySearch(startArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int result = test.findIndex("Obeliks");

        assertThat(result, is(3));
    }

    /**
     * Test method findIndex() when return -1.
     */
    @Test
    public void whenGetStringThenReturnMinusOne() {
        String[] startArray = {"Bob", "Adam", "Asteriks", "Obeliks", "Rick"};
        BinarySearch test = new BinarySearch(startArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int result = test.findIndex("Morty");

        assertThat(result, is(-1));
    }
}