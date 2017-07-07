package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class HeapSortTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.07.2017
 */
public class HeapSortTest {

    /**
     * Test method sort().
     */
    @Test
    public void whenGetUnsortedArrayThenReturnSortedArray() {
        HeapSort test = new HeapSort();
        int[] startArray = {5, 3, 1, 2, 4};
        test.sort(startArray);

        int[] resultArray = {1, 2, 3, 4, 5};

        assertThat(startArray, is(resultArray));
    }
}