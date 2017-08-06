package ru.job4j;

/**
 * Class Permutation.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class Permutation {

    /**
     * This method checks whether one string is a permutation of another string.
     *
     * @param str1 first string.
     * @param str2 second string.
     * @return true if one string is a permutation of another string otherwise false.
     */
    public boolean permutation(String str1, String str2) {
        boolean result = true;
        if (str1.length() != str2.length()) {
            result = false;
        } else {
            int[] letters = new int[256];

            char[] fromStr1 = str1.toCharArray();

            for (char ch : fromStr1) {
                letters[ch]++;
            }

            for (int i = 0; i < str2.length(); i++) {
                int ch = (int) str2.charAt(i);
                if (--letters[ch] < 0) {
                    result = false;
                }
            }
        }
        return result;
    }
}
