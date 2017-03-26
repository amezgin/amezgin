package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;

/**
 * The class SimpleArrayContainer.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 * @param <T> generic.
 */
public class SimpleArrayContainer<T> implements SimpleContainer<T> {

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
    public SimpleArrayContainer(int initialCapacity) {
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
     */
    @Override
    public void add(T value) {
        if (this.elementData.length == this.size) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
        }
        this.elementData[size++] = value;
    }

    /**
     * This method returns an object from the container by index.
     *
     * @param index index.
     * @return object.
     */
    @Override
    public T get(int index) {
        return (T) this.elementData[index];
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
