package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test the class Point.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 18.11.2016
 */
 public class PointTest {

	/**
     * Test distanceTo.
     */
	@Test
	public void whenAddTwoPointsThenReturnDistance() {

	Point pointOne = new Point(1d, 0d);
	Point pointTwo = new Point(0d, 0d);

	double checked = 1d;

	double result = pointOne.distanceTo(pointTwo);

	assertThat(result, is(checked));
	}
}