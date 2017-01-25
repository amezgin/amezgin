package ru.job4j;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test the class Triangle.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 18.11.2016
 */
 public class TriangleTest {

	/**
	 *error is the delta (+/-) within which matches will be allowed.
	 */
	public static final double ERROR = 0.001;

	/**
     * Test area.
	 * @throws Exception - any
     */
	@Test
	public void whenAddThreePointsThenReturnArea() throws Exception {

		final double two = 2d;
		final double three = 3d;

		Point a = new Point(1d, three);
		Point b = new Point(two, two);
		Point c = new Point(three, two);

		Triangle triangle = new Triangle(a, b, c);

		final double checked = 0.5;

		double result = triangle.area();

		assertThat(result, is(closeTo(checked, ERROR)));
	}

	/**
     * Test area() with exception.
     * @throws Exception - "It is impossible to construct a triangle with these vertices"
     */
    @Test(expected = Exception.class)
    public final void whenWrongAreaThenReturnException() throws Exception {

        Point a = new Point(0d, 0d);
        Point b = new Point(0d, 0d);
        Point c = new Point(0d, 0d);

        Triangle triangle = new Triangle(a, b, c);

        triangle.area();
	}
 }