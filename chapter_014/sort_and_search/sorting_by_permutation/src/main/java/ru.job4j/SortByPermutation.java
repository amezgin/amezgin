package ru.job4j;

import java.util.Comparator;

/**
 * The class SortByPermutation.
 * This class sorts by the method of permutation.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 30.06.2017
 */
public class SortByPermutation<E> {

    /**
     * This method sorts array by the method of permutation.
     *
     * @param array    array.
     * @param argument Comparator.
     */
    public void sort(E[] array, Comparator<? super E> argument) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (argument.compare(array[j], array[j + 1]) > 0) {
                    E tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
