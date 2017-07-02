package ru.job4j;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SortingSampleTes.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.07.2017
 */
public class SortingSampleTest {

    /**
     * Test method sort() for String.
     */
    @Test
    public void whenGetArrayOfStringThenReturnSortedArray() {
        SortingSample<String> test = new SortingSample<>();
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