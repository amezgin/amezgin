package ru.job4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The class BinarySearch.
 * This class sorts by the method of binary sort.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 11.07.2017
 */
public class BinarySearch<E> {

    /**
     * Array.
     */
    private E[] array;

    /**
     * The result index.
     */
    private int resultIndex;

    /**
     * The comparator.
     */
    private Comparator<? super E> comparator;

    /**
     * The construct.
     *
     * @param array      array.
     * @param comparator comparator;
     */
    public BinarySearch(E[] array, Comparator<? super E> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    /**
     * This method looks for a number in the array.
     *
     * @param value a number.
     * @return index if the value is find.
     */
    public int findIndex(E value) {
        boolean result = false;
        int index = -1;
        if (isSort()) {
            result = binarySearch(value, this.array, 0, array.length - 1);
        } else {
            Arrays.sort(this.array);
            result = binarySearch(value, this.array, 0, array.length - 1);
        }
        if (result) {
            index = this.resultIndex;
        }
        return index;
    }

    /**
     * This method looks for a number in the array.
     *
     * @param value  a number.
     * @param array  an array.
     * @param start  left side.
     * @param finish right side.
     * @return true if the number is in the array otherwise false.
     */
    private boolean binarySearch(E value, E[] array, int start, int finish) {
        boolean result = true;
        int mid = (start + finish) / 2;

        if (start > finish) {
            result = false;
        } else if (value.equals(array[mid])) {
            this.resultIndex = mid;
        } else if (comparator.compare(value, array[mid]) < 0) {
            result = binarySearch(value, array, start, mid - 1);
        } else {
            result = binarySearch(value, array, mid + 1, finish);
        }
        return result;
    }

    /**
     * This method checks that the array is sorted in ascending order.
     *
     * @return true if array is sorted otherwise false.
     */
    private boolean isSort() {
        boolean result = true;
        for (int i = 0; i < this.array.length - 1; i++) {
            if (comparator.compare(this.array[i], this.array[i + 1]) > 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}