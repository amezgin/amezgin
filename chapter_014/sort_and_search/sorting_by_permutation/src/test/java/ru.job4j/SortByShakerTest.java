package ru.job4j;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SortByShakerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 30.06.2017
 */
public class SortByShakerTest {

    /**
     * Test method sort() for Integer.
     */
    @Test
    public void whenGetArrayOfIntegerThenReturnSortedArray() {
        SortByShaker<Integer> test = new SortByShaker<>();
        Integer[] startArray = {5, 2, 7, 1, 8};
        test.sort(startArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Integer[] resultArray = {1, 2, 5, 7, 8};

        assertThat(startArray, is(resultArray));
    }

    /**
     * Test method sort() for String.
     */
    @Test
    public void whenGetArrayOfStringThenReturnSortedArray() {
        SortByShaker<String> test = new SortByShaker<>();
        String[] startArray = {"Bob", "Adam", "Asteriks", "Obeliks"};
        test.sort(startArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        String[] resultArray = {"Adam", "Asteriks", "Bob", "Obeliks"};

        assertThat(startArray, is(resultArray));
    }
}