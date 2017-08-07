package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class ApproximateEqualityTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class ApproximateEqualityTest {

    /**
     * Test when one string is null with result false.
     */
    @Test
    public void whenGetOneStringNullThenReturnFalse() {
        ApproximateEquality test = new ApproximateEquality();
        String str1 = "abyrvalg";
        String str2 = null;

        boolean result = test.equality(str1, str2);

        assertThat(result, is(false));
    }

    /**
     * Test two string with length different more one with result false.
     */
    @Test
    public void whenGetTwoStringWithLengthDifferenceMoreOneThenReturnFalse() {
        ApproximateEquality test = new ApproximateEquality();
        String str1 = "abyrvalg";
        String str2 = "abyrva";

        boolean result = test.equality(str1, str2);

        assertThat(result, is(false));
    }

    /**
     * Test two string of the same length with result false.
     */
    @Test
    public void whenGetTwoStringWithSameLengthThenReturnFalse() {
        ApproximateEquality test = new ApproximateEquality();
        String str1 = "abyrvalg";
        String str2 = "abyvrlag";

        boolean result = test.equality(str1, str2);

        assertThat(result, is(false));
    }

    /**
     * Test two string wit one permutation with result true.
     */
    @Test
    public void whenGetTwoStringWithOnePermutationThenReturnTrue() {
        ApproximateEquality test = new ApproximateEquality();
        String str1 = "abyrvalg";
        String str2 = "abyrvagl";

        boolean result = test.equality(str1, str2);

        assertThat(result, is(true));
    }

    /**
     * Test two string with different length equals one with result true.
     */
    @Test
    public void whenGetTwoStringWithDifferentLengthEqualsOneThenReturnTrue() {
        ApproximateEquality test = new ApproximateEquality();
        String str1 = "abyrvalg";
        String str2 = "abyralg";

        boolean result = test.equality(str1, str2);

        assertThat(result, is(true));
    }
}