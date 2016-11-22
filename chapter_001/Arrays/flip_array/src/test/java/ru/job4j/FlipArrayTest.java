package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class FlipArray.
 */
public class FlipArrayTest {

	/**
	 * testing method flip() returned an array rotated 90 degrees.
	 */
	@Test
	public void whenAddArraysThenReturnRotatedArray() {

		final FlipArray flipArray = new FlipArray();

		final int[][] sourceArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		final int[][] expectArray = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};

		final int[][] resultArray = flipArray.flip(sourceArray);

		assertThat(resultArray, is(expectArray));
	}
}