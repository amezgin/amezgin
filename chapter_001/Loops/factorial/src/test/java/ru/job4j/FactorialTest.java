package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Factorial.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 20.11.2016
 */
 public class FactorialTest {

	/**
     * Test fact(int f) with correct argument.
     */
    @Test
	public void whenAddCorrectArgumentThenReturnFactorial() {
		final Factorial factorial = new Factorial();

		final long checked = 6;
		final int f = 3;

		final long result = factorial.fact(f);

		assertThat(result, is(checked));
	}

	/**
     * Test fact(int f) with argument = 0.
     */
    @Test
	public void whenAddZeroThenReturnOne() {
		final Factorial factorial = new Factorial();

		final long checked = 1;
		final int f = 0;

		final long result = factorial.fact(f);


		assertThat(result, is(checked));
	}

	/**
     * @throws IllegalArgumentException - "The argument value must be > 0."
     */
    @Test(expected = IllegalArgumentException.class)
	public void whenAddIllegalArgumentThenReturnExeption() throws IllegalArgumentException {
		final Factorial factorial = new Factorial();

		final int f = -5;

		factorial.fact(f);

	}
}