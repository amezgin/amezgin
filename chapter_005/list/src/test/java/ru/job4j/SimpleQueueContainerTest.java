package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleQueueContainerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 28.03.2017
 */
public class SimpleQueueContainerTest {

    /**
     * Test the class SimpleQueueContainer.
     */
    @Test
    public void whenAddElementsShouldReturnFirstElement() {
        SimpleQueueContainer<Integer> simpleQueueContainer = new SimpleQueueContainer();
        simpleQueueContainer.push(1);
        simpleQueueContainer.push(2);
        simpleQueueContainer.push(3);
        simpleQueueContainer.pop();

        int result = simpleQueueContainer.pop();

        assertThat(result, is(2));

    }
}