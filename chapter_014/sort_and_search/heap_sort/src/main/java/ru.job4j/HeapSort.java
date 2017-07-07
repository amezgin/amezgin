package ru.job4j;

/**
 * The class SortingSample.
 * This class sorts by the method of sample.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.07.2017
 */
public class HeapSort {

    /**
     * The heap size.
     */
    private int heapSize;

    /**
     * This method sorts the array method of heap sort.
     *
     * @param array unsorted array.
     */
    public void sort(int[] array) {
        this.heapSize = array.length;

        for (int i = array.length / 2; i >= 0; i--) {
            rebuildHeap(array, i);
        }

        while (this.heapSize > 1) {
            swapElement(array, 0, this.heapSize - 1);
            this.heapSize--;
            rebuildHeap(array, 0);
        }
    }

    /**
     * This method rebuold the heap.
     *
     * @param array array.
     * @param rootSubtree the subtree root.
     */
    private void rebuildHeap(int[] array, int rootSubtree) {
        int left = 2 * rootSubtree + 1;
        int right = 2 * rootSubtree + 2;
        int largest = rootSubtree;
        if (left < this.heapSize && array[rootSubtree] < array[left]) {
            largest = left;
        }
        if (right < this.heapSize && array[rootSubtree] < array[right]) {
            largest = right;
        }
        if (largest != rootSubtree) {
            swapElement(array, rootSubtree, largest);
            rebuildHeap(array, largest);
        }
    }

    /**
     * This method swap element in tree.
     *
     * @param array array.
     * @param i first element.
     * @param j second element.
     */
    private void swapElement(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
