package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class PermutationTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class PermutationTest {
    /**
     * Test with result true.
     */
    @Test
    public void whenOneStringIsPermutationOtherStringThenReturnTrue() {
        String str1 = "Mama mila ramu!";
        String str2 = "umar  mila!amaM";

        Permutation test = new Permutation();

        boolean result = test.permutation(str1, str2);

        assertThat(result, is(true));
    }

    /**
     * Test with result false.
     */
    @Test
    public void whenGetArrayWithNonUniqueElementThenReturnFalse() {
        String str1 = "Mama mila ramu!";
        String str2 = "umar  mila!amam";

        Permutation test = new Permutation();

        boolean result = test.permutation(str1, str2);

        assertThat(result, is(false));
    }
}