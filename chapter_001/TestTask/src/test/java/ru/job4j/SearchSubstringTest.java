package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class SearchSubstring.
 */
public class SearchSubstringTest {

	/**
	 * testing method search() returned true.
	 */
	@Test
	public void whenAddStringThenReturnTrue() {

		final SearchSubstring searchSub = new SearchSubstring();

		final String origin = "Mama mila ramu!";

		final String sub = " ramu!";

		final boolean expect = true;

		final boolean result = searchSub.contains(origin, sub);

		assertThat(result, is(expect));
	}

	/**
	 * testing method search() returned false.
	 */
	@Test
	public void whenAddStringThenReturnFalse() {

		final SearchSubstring searchSub = new SearchSubstring();

		final String origin = "Mama mila ramu!";

		final String sub = " Ramu!";

		final boolean expect = false;

		final boolean result = searchSub.contains(origin, sub);

		assertThat(result, is(expect));
	}
}