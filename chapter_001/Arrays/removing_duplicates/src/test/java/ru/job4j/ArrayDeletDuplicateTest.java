package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class ArrayDeletDuplicate.
 */
public class ArrayDeletDuplicateTest {

	/**
	 * testing method delDupl().
	 */
	@Test
	public void whenAddArraysWithDuplicateThenReturnArraysWithoutDuplicate() {

		final ArrayDeletDuplicate arrayDeletDuplicate = new ArrayDeletDuplicate();

		final String[] sourceArray = {"aa", "bb", "cc", "bb", "bb", "dd"};

		final String[] expectArray = {"aa", "bb", "cc", "dd"};

		final String[] resultArray = arrayDeletDuplicate.delDupl(sourceArray);

		assertThat(resultArray, is(expectArray));
	}
}