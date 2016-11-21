package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class Turn.
 */
public class TurnTest {

	/**
	 * testing method back() accepts an array with even length.
	 */
	@Test
	public void whenAddEvanArraysThenReturnFlippedArray() {

		final Turn turn = new Turn();

		final int[] sourceArray = {1, 2, 3, 4};

		final int[] expectArray = {4, 3, 2, 1};

		final int[] resultArray = turn.back(sourceArray);

		assertThat(resultArray, is(expectArray));
	}

	/**
	 * testing method back() accepts an array with odd length.
	 */
	@Test
	public void whenAddOddArraysThenReturnFlippedArray() {

		final Turn turn = new Turn();

		final int[] sourceArray = {1, 2, 3};

		final int[] expectArray = {3, 2, 1};

		final int[] resultArray = turn.back(sourceArray);

		assertThat(resultArray, is(expectArray));
	}
}