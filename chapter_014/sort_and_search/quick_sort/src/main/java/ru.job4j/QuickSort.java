package ru.job4j;

/**
 * The class QuickSort.
 * This class sorts by the method of quick sort.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 11.07.2017
 */
public class QuickSort {
    /**
     * This method sorts the array method of quick sort.
     *
     * @param array unsorted array.
     * @param left  left side.
     * @param right right side.
     */
    public void sort(int[] array, int left, int right) {
        int index = splitArray(array, left, right);

        if (left < index - 1) {
            sort(array, left, index - 1);
        }
        if (index < right) {
            sort(array, index, right);
        }
    }

    /**
     * This method split array on two parts.
     *
     * @param array array.
     * @param left  left side.
     * @param right right side.
     * @return index.
     */
    private int splitArray(int[] array, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
