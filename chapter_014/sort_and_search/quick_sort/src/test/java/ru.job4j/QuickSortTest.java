package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class QuickSortTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 11.07.2017
 */
public class QuickSortTest {

    /**
     * Test method sort().
     */
    @Test
    public void whenGetUnsortedArrayThenReturnSortedArray() {
        QuickSort test = new QuickSort();
        int[] startArray = {5, 3, 1, 2, 4, 6};
        int[] resultArray = {1, 2, 3, 4, 5, 6};

        test.sort(startArray, 0, startArray.length - 1);

        assertThat(startArray, is(resultArray));
    }
}