package ru.job4j;

import java.util.Arrays;

/**
 * Class ArraysIsSorted.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2016
 */
public class ArraysIsSorted {

    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {

        final int[] arr = {0, 1, 2, 3, 4, 5};

        final int[] arr1 = {0, 1, 2, 3, 5, 4};

        final int[] arr2 = {5, 4, 3, 2, 1, 0};

        System.out.println("Sorted arr by ascending from isSortedByAscending1? " + isSortedByAscending1(arr));
        System.out.println("Sorted arr1 by ascending from isSortedByAscending1? " + isSortedByAscending1(arr1));

        System.out.println("Sorted arr by ascending from isSortedByAscending2? " + isSortedByAscending2(arr));
        System.out.println("Sorted arr1 by ascending from isSortedByAscending2? " + isSortedByAscending2(arr1));

        System.out.println("Sorted arr1 by ascending from isSortedByDescending? " + isSortedByDescending(arr1));
        System.out.println("Sorted arr2 by ascending from isSortedByDescending? " + isSortedByDescending(arr2));
    }


    /**
     * Method isSortedByAscending1.
     * @param array args
     * @return true if array is sorted on ascending otherwise return false
     */
    static boolean isSortedByAscending1(int[] array) {

        int[] newArr = Arrays.copyOf(array, array.length);

        Arrays.sort(newArr);

        return Arrays.equals(array, newArr);
    }

    /**
     * Method isSortedByAscending1.
     * @param array args
     * @return true if array is sorted on ascending otherwise return false
     */
    static boolean isSortedByAscending2(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method isSortedByAscending1.
     * @param array args
     * @return true if array is sorted on descending otherwise return false
     */
    static boolean isSortedByDescending(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }

        return true;
    }

}
