package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * The class EvenNumberTest.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.01.2016
 */
public class EvenNumberTest {

    /**
     * Test for method isNumber() when returned "true".
     */
    @Test
    public void whenInputEvenNumberThenReturnTrue() {
        EvenNumber en = new EvenNumber();

        String number = "2";

        System.setIn(new ByteArrayInputStream(number.getBytes()));

        assertTrue(en.isNumber(System.in));
    }

    /**
     * Test for method isNumber() when returned "false".
     */
    @Test
    public void whenInputEvenNumberThenReturnFalse() {
        EvenNumber en = new EvenNumber();

        String number = "1";

        System.setIn(new ByteArrayInputStream(number.getBytes()));

        assertThat(en.isNumber(System.in), is(false));
    }

    /**
     * Test for method isNumber() when returned "false".
     *
     * @throws NumberFormatException - "In the stream is not a number!".
     */
    @Test(expected = NumberFormatException.class)
    public void whenInputNotNumberThenReturnNumForExc() {
        EvenNumber en = new EvenNumber();

        String number = "Hello!";

        System.setIn(new ByteArrayInputStream(number.getBytes()));

        en.isNumber(System.in);
    }
}
