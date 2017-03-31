package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;

/**
 * The class SimpleArraySet.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.03.2017
 */
public class SimpleArraySet<T> implements SimpleSet<T> {

    /**
     * Array of objects.
     */
    private Object[] elementData;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException if the specified initial capacity is negative.
     */
    public SimpleArraySet(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        } else {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     * @return if object added then return true.
     */
    @Override
    public boolean add(T value) {
        boolean result = false;
        if (this.elementData.length == this.size) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
        }
        if (!checkDuplicate(value)) {
            this.elementData[this.size] = value;
            result = true;
            this.size++;
        }
        return result;
    }

    /**
     * This method returns the size.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * This method checked value on duplicate in elementData.
     *
     * @param value any value.
     * @return if value not contains in the elementData then returns false.
     */
    private boolean checkDuplicate(T value) {
        boolean result = false;
        for (int i = 0; i <= size; i++) {
            if (value.equals(this.elementData[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * This method returns iterator.
     *
     * @return new iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            /**
             * The index.
             */
            private int index = 0;

            /**
             * This method returned true if the iterator has more elements.
             *
             * @return true if the iterator has more elements.
             */
            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            /**
             * This method returns the next even element in the iteration.
             *
             * @return the next even element in the iteration.
             */
            @Override
            public T next() {
                return (T) elementData[this.index++];
            }
        };
    }
}
