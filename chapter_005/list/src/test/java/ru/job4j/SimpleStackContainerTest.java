package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleStackContainerTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 28.03.2017
 */
public class SimpleStackContainerTest {

    /**
     * Test the class SimpleStackContainer.
     */
    @Test
    public void whenAddElementsShouldReturnLastElement() {
        SimpleStackContainer<Integer> simpleStackContainer = new SimpleStackContainer();
        simpleStackContainer.push(1);
        simpleStackContainer.push(2);
        simpleStackContainer.push(3);

        int result = simpleStackContainer.pop();

        assertThat(result, is(3));

    }
}