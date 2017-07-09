package ru.job4j;

import java.util.Arrays;

/**
 * The class SortingSample.
 * This class sorts by the method of merge.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.07.2017
 */
public class MergeSort {

    /**
     * This method sorts the array method of merge sort.
     *
     * @param array unsorted array.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int halfArray = array.length / 2;
        int[] firstArray = Arrays.copyOf(array, halfArray);
        int[] secondArray = Arrays.copyOfRange(array, halfArray, array.length);

        return mergeSortedArray(sort(firstArray), sort(secondArray));
    }

    /**
     * This method sorts two sorted array.
     *
     * @param arr1 first array.
     * @param arr2 second array.
     * @return result array.
     */
    private int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int firstArrayLength = arr1.length;
        int secondArrayLength = arr2.length;
        int indexFirstArray = 0;
        int indexSecondArray = 0;

        int[] resultArray = new int[firstArrayLength + secondArrayLength];


        for (int i = 0; i < resultArray.length; i++) {
            if (indexFirstArray >= firstArrayLength) {
                resultArray[i] = arr2[indexSecondArray++];
                continue;
            }
            if (indexSecondArray >= secondArrayLength) {
                resultArray[i] = arr1[indexFirstArray++];
                continue;
            }
            if (arr1[indexFirstArray] < arr2[indexSecondArray]) {
                resultArray[i] = arr1[indexFirstArray++];
            } else {
                resultArray[i] = arr2[indexSecondArray++];
            }
        }
        return resultArray;
    }
}
