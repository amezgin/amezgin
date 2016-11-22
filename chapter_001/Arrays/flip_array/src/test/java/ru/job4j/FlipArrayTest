package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class ArraySort.
 */
public class ArraySortTest {

	/**
	 * testing method bubbleSort() sorts the array by the method of bubbles.
	 */
	@Test
	public void whenAddUnsortedArraysThenReturnSortedArray() {

		final ArraySort arraySort = new ArraySort();

		final int[] sourceArray = {5, 2, 1, 4};

		final int[] expectArray = {1, 2, 4, 5};

		final int[] resultArray = arraySort.bubbleSort(sourceArray);

		assertThat(resultArray, is(expectArray));
	}
}