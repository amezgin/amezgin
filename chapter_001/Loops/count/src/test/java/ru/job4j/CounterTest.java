package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Counter.
 *
 * @author Alexander Mezgin
 * @version 1
 * @since 20.11.2016
 */
public class CounterTest {
	/**
	* test method add.
	*/
	@Test
	public void whenAddStartAndFinishThenReturnSum() {
		final Counter counter = new Counter();

		final int checked = 30;

		final int start = 0;
		final int finish = 10;

		final int result = counter.add(start, finish);

		assertThat(result, is(checked));
	}
}