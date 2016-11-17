package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 17.11.2016
 */
public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddTwoAndThreeThenReturnFive() {
        final Calculator calc = new Calculator();
		final double checked = 5d;
		final double first = 2d;
		final double second = 3d;

		calc.add(first, second);

		final double result = calc.getResult();

        assertThat(result, is(checked));
    }

	/**
     * Test substruct.
     */
    @Test
    public void whenSubstructFourAndThreeThenReturnFive() {
        final Calculator calc = new Calculator();
		final double checked = 1d;
		final double first = 4d;
		final double second = 3d;

		calc.substruct(first, second);

		final double result = calc.getResult();

        assertThat(result, is(checked));
    }

	/**
     * Test division.
     */
    @Test
    public void whenDivisionFourAndTwoThenReturnTwo() {
        final Calculator calc = new Calculator();
		final double checked = 2d;
		final double first = 4d;
		final double second = 2d;

		calc.div(first, second);

		final double result = calc.getResult();

        assertThat(result, is(checked));
    }

	/**
     * Test multiple.
     */
    @Test
    public void whenMultipleFourAndTwoThenReturnEight() {
        final Calculator calc = new Calculator();
		final double checked = 8d;
		final double first = 4d;
		final double second = 2d;

		calc.multiple(first, second);

		final double result = calc.getResult();

        assertThat(result, is(checked));
    }
}