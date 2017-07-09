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
public class MergeSortTest {

    /**
     * Test method sort() with even elements.
     */
    @Test
    public void whenGetUnsortedArrayThenReturnSortedArray() {
        MergeSort test = new MergeSort();
        int[] startArray = {5, 3, 1, 2, 4, 6};
        int[] resultArray = {1, 2, 3, 4, 5, 6};

        int[] result = test.sort(startArray);

        assertThat(result, is(resultArray));
    }

    /**
     * Test method sort() with odd elements.
     */
    @Test
    public void whenGetUnsortedArrayThenReturnSortedArrayAlso() {
        MergeSort test = new MergeSort();
        int[] startArray = {5, 3, 1, 2, 4};
        int[] resultArray = {1, 2, 3, 4, 5};

        int[] result = test.sort(startArray);

        assertThat(result, is(resultArray));
    }
}