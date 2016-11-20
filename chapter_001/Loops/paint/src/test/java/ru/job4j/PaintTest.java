package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Paint.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 20.11.2016
 */
 public class PaintTest {

	/**
     * Test pyramid(int h) with correct heigth.
     */
    @Test
	public void whenAddHeigthEqualsTwoThenReturnPyramid() {
		final Paint paint = new Paint();

		final String checked = "  ^  \n\r ^ ^ \n\r";
		final int h = 2;

		final String result = paint.pyramid(h);

		assertThat(result, is(checked));
	}

	/**
     * Test pyramid(int h) with incorrect heigth.
     */
    @Test
	public void whenAddIncorrectHeigthThenReturnError() {
		final Paint paint = new Paint();

		final String checked = "You can't build a pyramid with that height!";
		final int h = -2;

		final String result = paint.pyramid(h);

		assertThat(result, is(checked));
	}
}