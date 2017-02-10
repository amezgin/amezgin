package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class AggregateUnitsTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 10.02.2017
 */
public class AggregateUnitsTest {

    /**
     * This test for method findAgregate().
     */
    @Test
    public void whenGetArrayThenReturnAggregateTree() {
        final int[][] arr = {
                {1, 1, 0},
                {0, 0, 0},
                {1, 1, 1}
        };
        final AggregateUnits aggregateUnits = new AggregateUnits(arr);
        final int result = aggregateUnits.findAgregate();
        assertThat(result, is(3));
    }

    /**
     * This test for method findAgregate().
     */
    @Test
    public void whenGetArrayThenReturnAggregateFive() {
        final int[][] arr = {
                {1, 1, 0},
                {0, 0, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        final AggregateUnits aggregateUnits = new AggregateUnits(arr);
        final int result = aggregateUnits.findAgregate();
        assertThat(result, is(5));
    }
}