package ru.job4j;

import java.util.Comparator;

/**
 * The class SortingSample.
 * This class sorts by the method of sample.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.07.2017
 */
public class SortingSample<E>  {

    /**
     * This method sorts array by the method of sample.
     *
     * @param array    array.
     * @param argument Comparator.
     */
    public void sort(E[] array,  Comparator<? super E> argument) {
        for (int i = 0; i < array.length; i++) {
            E minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (argument.compare(array[j], minValue) < 0) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                E tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }
}
