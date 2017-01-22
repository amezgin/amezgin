package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The test class for class Palindrome.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 08.01.2017
 */
public class PalindromeTest {

    /**
     * Test for method isPalindrome(), which returns true.
     *
     * @throws IOException - IOException.
     */
    @Test
    public void whenEnterPalindromeThenReturnTrue() throws IOException {
        Palindrome palindrome = new Palindrome();
        final String checked = "РотОр";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(checked.getBytes());

        System.setIn(byteArrayInputStream);
        Boolean result = palindrome.isPalindrome(System.in);

        assertThat(result, is(true));
    }

    /**
     * Test for method isPalindrome(), which returns false.
     *
     * @throws IOException - IOException.
     */
    @Test
    public void whenEnterNotPalindromeThenReturnFalse() throws IOException {
        Palindrome palindrome = new Palindrome();
        final String checked = "Рот0р";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(checked.getBytes());

        System.setIn(byteArrayInputStream);
        Boolean result = palindrome.isPalindrome(System.in);

        assertThat(result, is(false));
    }

    /**
     * Test for method isPalindrome(), which returns false.
     *
     * @throws IOException - IOException.
     */
    @Test
    public void whenEnterWordNotFiveSymbolsThenReturnFalse() throws IOException {
        Palindrome palindrome = new Palindrome();
        final String checked = "goog";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(checked.getBytes());

        System.setIn(byteArrayInputStream);
        Boolean result = palindrome.isPalindrome(System.in);

        assertThat(result, is(false));
    }
}