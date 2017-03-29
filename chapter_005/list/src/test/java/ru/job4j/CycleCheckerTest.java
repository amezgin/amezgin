package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class CycleCheckerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 */
public class CycleCheckerTest {

    /**
     * Test with result true.
     */
    @Test
    public void whenGetCycledListThenReturnTrue() {
        CycleChecker cycleChecker = new CycleChecker();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = cycleChecker.hasCycle(first);

        assertThat(result, is(true));
    }

    /**
     * Test with result false.
     */
    @Test
    public void whenGetNonCycledListThenReturnFalse() {
        CycleChecker cycleChecker = new CycleChecker();
        Node first = new Node(1);

        boolean result = cycleChecker.hasCycle(first);

        assertThat(result, is(false));
    }
}