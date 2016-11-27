package ru.testtask2;

/**
 * Class CorrectBraces.
 *
 *@author Alexander Vezgin
 *@version 1.0
 *@since 27.11.2016
 */
public class CorrectBraces {
    /**
     * This method returns true if the count of open braces equals the count of closed braces.
     *@param array is a original array of braces
     *@return true the count of open braces equals the count of closed braces and false if not
     */
    public boolean isCorrect(char[] array) {
        int count = 0;

        for (char brace : array) {
            if (brace == '(') {
                count++;
            } else if (brace == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
