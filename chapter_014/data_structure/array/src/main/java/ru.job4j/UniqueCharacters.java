package ru.job4j;

/**
 * Class UniqueCharacters.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class UniqueCharacters {

    /**
     * This method checks whether the array of unique characters.
     *
     * @param array array.
     * @return true if the array contains unique characters.
     */
    public boolean unique(char[] array) {
        boolean result = true;
        int math = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    result = false;
                    math++;
                    break;
                }
                if (math != 0) {
                    break;
                }
            }
        }
        return result;
    }
}
