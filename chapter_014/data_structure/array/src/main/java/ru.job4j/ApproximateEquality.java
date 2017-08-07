package ru.job4j;

/**
 * Class ApproximateEquality.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.08.2017
 */
public class ApproximateEquality {

    /**
     * This method checks two string on approximate equality.
     *
     * @param str1 first string.
     * @param str2 second string.
     * @return true if two string is approximate equality otherwise false.
     */
    public boolean equality(String str1, String str2) {
        boolean result = true;

        if (str1 == null || str2 == null) {
            result = false;
        } else if (Math.abs(str1.length() - str2.length()) > 1) {
            result = false;
        } else if (str1.length() == str2.length()) {
            result = compareTwoStringWithEqualLength(str1, str2);
        } else if (Math.abs(str1.length() - str2.length()) == 1) {
            result = compareTwoStringWhenNeedAddOrDeleteOneSymbol(str1, str2);
        }
        return result;
    }

    /**
     * This method checks two string with same length on approximate equality.
     *
     * @param str1 first string.
     * @param str2 second string.
     * @return true if two string is approximate equality otherwise false.
     */
    private boolean compareTwoStringWithEqualLength(String str1, String str2) {
        boolean result = true;
        int countPermutation = 0;

        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }
            if (str1.charAt(i) == str2.charAt(i + 1) && str1.charAt(i + 1) == str2.charAt(i)) {
                countPermutation++;
            } else {
                result = false;
                break;
            }
            if (countPermutation > 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * This method checks two string when need add or delete one symbol on approximate equality.
     *
     * @param str1 first string.
     * @param str2 second string.
     * @return true if two string is approximate equality otherwise false.
     */
    private boolean compareTwoStringWhenNeedAddOrDeleteOneSymbol(String str1, String str2) {
        boolean result = true;
        int countAddedSymbols = 0;

        String strA;
        String strB;
        if (str1.length() < str2.length()) {
            strA = str1;
            strB = str2;
        } else {
            strA = str2;
            strB = str1;
        }
        int positionSymbolInStrB = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == strB.charAt(positionSymbolInStrB)) {
                positionSymbolInStrB++;
                continue;
            } else if (strA.charAt(i) == strB.charAt(positionSymbolInStrB + 1)) {
                countAddedSymbols++;
                positionSymbolInStrB++;
                continue;
            }
            if (countAddedSymbols > 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
