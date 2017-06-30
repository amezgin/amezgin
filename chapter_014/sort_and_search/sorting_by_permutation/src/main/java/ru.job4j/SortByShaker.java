package ru.job4j;

import java.util.Comparator;

/**
 * The class SortByShaker.
 * This class sorts by the method of shaker.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 30.06.2017
 */
public class SortByShaker<E> {

    /**
     * This method sorts array by the method of shaker.
     *
     * @param array    array.
     * @param argument Comparator.
     */
    public void sort(E[] array, Comparator<? super E> argument) {
        int leftBorder = 0;
        int rightBorder = array.length - 1;

        do {
            for (int i = leftBorder; i < rightBorder; i++) {
                if (argument.compare(array[i], array[i + 1]) > 0) {
                    E tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }

            rightBorder--;

            for (int i = rightBorder; i > leftBorder; i--) {
                if (argument.compare(array[i], array[i - 1]) < 0) {
                    E tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }

            leftBorder++;
        } while (leftBorder <= rightBorder);
    }
}
