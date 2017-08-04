package ru.job4j.raceconditions;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.hamcrest.core.Is.is;

/**
 * Class ChangeValueTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.08.2017
 */
public class ChangeValueTest {
    /**
     * Test for race conditions.
     *
     * @throws InterruptedException InterruptedException.
     */
    @Test
    public void raceConditionsTest() throws InterruptedException {
        ChangeValue changeValue = new ChangeValue();
        Thread thread1 = new Thread(changeValue);
        Thread thread2 = new Thread(changeValue);
        thread1.start();
        thread2.start();
        Thread.sleep(6000);

        int result = changeValue.getValue();

        assertNotEquals(result, is(200000));
    }

}