package ru.job4j.testtask2;

import org.junit.Test;
import ru.testtask2.CorrectBraces;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for class CorrectBraces.
 */
public class CorrectBracesTest {
    /**
     * testing method isCorrect() returned true.
     */
    @Test
    public void whenAddCorrectBraceThenReturnTrue() {

        final CorrectBraces correctBraces = new CorrectBraces();

        final char[] origin = {'(', ')', '(', '(', ')', '(', '(', '(', ')', ')', ')', ')'};

        final boolean expect = true;

        final boolean result = correctBraces.isCorrect(origin);

        assertThat(result, is(expect));
    }

    /**
     * testing method isCorrect() returned false.
     */
    @Test
    public void whenAddInorrectBraceThenReturnFalse() {

        final CorrectBraces correctBraces = new CorrectBraces();

        final char[] origin = {'(', ')', ')'};

        final boolean expect = false;

        final boolean result = correctBraces.isCorrect(origin);

        assertThat(result, is(expect));
    }

}
