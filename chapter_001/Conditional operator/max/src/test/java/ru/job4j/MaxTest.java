package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Max.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 18.11.2016
 */
public class MaxTest {
    /**
     * Test max with two arguments.
     */
    @Test
    public void whenAddTwoValuesThenReturnMax() {
        final Max maxValue = new Max();

		final int checked = 3;
		final int first = 2;
		final int second = 3;

		final int result = maxValue.max(first, second);

        assertThat(result, is(checked));
    }

	/**
     * Test max with three arguments.
     */
    @Test
    public void whenAddTwoValuesThenReturnMax() {
        final Max maxValue = new Max();

		final int checked = 4;
		final int first = 2;
		final int second = 3;
		final int third = 4;

		final int result = maxValue.max(first, second, third);

        assertThat(result, is(checked));
    }

	/**
     * Test max with two arguments, when they are equal.
     */
    @Test
    public void whenAddTwoValuesThenReturnMax() {
        final Max maxValue = new Max();

		final int checked = 3;
		final int first = 3;
		final int second = 3;

		final int result = maxValue.max(first, second);

        assertThat(result, is(checked));
    }
}