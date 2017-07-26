package ru.job4j;

import org.junit.Test;
import ru.job4j.frogsleap.FrogsLeap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class FrogsLeapTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.07.2017
 */
public class FrogsLeapTest {
    /**
     * The test № 1.
     */
    @Test
    public void whenStartProgramThenReturnThree() {
        FrogsLeap test = new FrogsLeap();
        String count = test.countJump("1, 7", "5, 5", 1, "2, 7");

        String result = "The frog can jump into sector (5, 5) for 2 jumps!";

        assertThat(result, is(count));
    }

    /**
     * The test № 2.
     */
    @Test
    public void whenStartProgramThenReturnEight() {
        FrogsLeap test = new FrogsLeap();
        String count = test.countJump("11, 7", "12, 7", 2, "2, 7", "5, 5");

        String result = "The frog can jump into sector (12, 7) for 7 jumps!";

        assertThat(result, is(count));
    }

    /**
     * The test № 3.
     */
    @Test
    public void whenStartProgramThenReturnNotJump() {
        FrogsLeap test = new FrogsLeap();
        String count = test.countJump("11, 7", "12, 7", 2, "12, 7", "5, 5");

        String result = "The frog cannot jump into this sector!";

        assertThat(result, is(count));
    }
}