package ru.job4j.stopthread;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class StopThreadTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.08.2017
 */
public class StopThreadTest {

    /**
     * Test.
     *
     * @throws InterruptedException InterruptedException.
     */
    @Test
    public void whenTheOperationTimeIsLessThenReturnCountSymbol() throws InterruptedException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baos);
        System.setOut(outputStream);
        String text = "Lorem ipsum dolor sit, consectetur adipiscing elit, sed do eiusmod tempor incididunt"
                + "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis noctrud exercitation ullamco"
                + "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate"
                + "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, "
                + "sunt in culpa qui officia deserunt mollit anim id est laborum.";
        CountChar countChar = new CountChar(text);
        Time time = new Time(2, countChar);
        Thread thread = new Thread(time);
        thread.start();
        thread.join();

        String result = baos.toString();

        assertThat(result, is("4"));
    }

}