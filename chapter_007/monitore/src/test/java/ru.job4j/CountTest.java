package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CountTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class CountTest {

    /**
     * Test for thread safe class.
     *
     * @throws InterruptedException InterruptedException
     */
    @Test
    public void whenStartTwoThreadThenReturnRightResult() throws InterruptedException {
        Count count = new Count();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.increment();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.increment();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        int result = count.getValue();

        assertThat(result, is(20000));
    }
}