package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The test class for DropAbuses.
 * This class implements a method which remove all words in array "abuse" from the stream.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.01.2017
 */
public class DropAbusesTest {

    /**
     * The test for method DropAbuses().
     */
    @Test
    public void whenGetInputStreamThenReturnOutputStreamWithoutAbuses() {

        DropAbuses dropAbuses = new DropAbuses();
        String checkedStr = "Mama mila ramu, no mame nujna pomosh!";
        String resultStr = "Ma mila , no me nujna pomosh!";
        String[] abuse = {"ramu", "ma", "mame"};

        System.setIn(new ByteArrayInputStream(checkedStr.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        dropAbuses.dropAbuses(System.in, System.out, abuse);

        assertThat(resultStr, is(outputStream.toString()));
    }

    /**
     * The test for method DropAbuses() with NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void whenGetInputStreamThenReturnNullPointerException() {

        DropAbuses dropAbuses = new DropAbuses();
        String checkedStr = "Mama mila ramu, no mame nujna pomosh!";

        String[] abuse = null;

        System.setIn(new ByteArrayInputStream(checkedStr.getBytes()));

        dropAbuses.dropAbuses(System.in, System.out, abuse);
    }
}