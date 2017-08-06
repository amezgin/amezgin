package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UniqueCharactersTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class UniqueCharactersTest {
    /**
     * Test with result true.
     */
    @Test
    public void whenGetArrayWithUniqueElementThenReturnTrue() {
        char[] array = new char[]{'a', 'f', 'g', 'r', 'y'};
        UniqueCharacters test = new UniqueCharacters();

        boolean result = test.unique(array);

        assertThat(result, is(true));
    }

    /**
     * Test with result false.
     */
    @Test
    public void whenGetArrayWithNonUniqueElementThenReturnFalse() {
        char[] array = new char[]{'a', 'f', 'g', 'r', 'y', 'f'};
        UniqueCharacters test = new UniqueCharacters();

        boolean result = test.unique(array);

        assertThat(result, is(false));
    }
}