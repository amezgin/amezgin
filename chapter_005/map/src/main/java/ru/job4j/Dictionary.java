package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class Dictionary.
 *
 * @param <T> generic.
 * @param <V> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 1.05.2017
 */
public class Dictionary<T, V> implements SimpleDictionary<T, V> {

    /**
     * Array of Nodes.
     */
    private Node<T, V>[] elementData;

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
    public Dictionary(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Node[initialCapacity];
        } else if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        } else {
            this.elementData = new Node[DEFAULT_CAPACITY];
        }
    }

    /**
     * This method adds a new object to the container.
     *
     * @param key   the new key.
     * @param value the new object.
     * @return if object added then return true.
     */
    @Override
    public boolean insert(T key, V value) {
        boolean result = false;
        if (this.elementData.length == this.size) {
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
        }
        int index = getIndexByHashKey(key);
        if (index != -1 && this.elementData[index] == null) {
            this.elementData[index] = new Node(key, value);
            result = true;
            this.size++;
        } else if (index != -1 && this.elementData[index] != null) {
            this.elementData[index] = new Node(key, value);
            result = true;
        }
        return result;
    }

    /**
     * This method returns the object at key.
     *
     * @param key the key.
     * @return the returned object.
     */
    @Override
    public V get(T key) {
        int index = getIndexByHashKey(key);
        if (index != -1) {
            return this.elementData[index].value;
        } else {
            throw new NoSuchElementException("Element not found!");
        }
    }

    /**
     * This method deletes the object from container at key.
     *
     * @param key key.
     * @return if object was deleted then return true.
     */
    @Override
    public boolean delete(T key) {
        boolean result = false;
        int index = getIndexByHashKey(key);
        if (index != -1) {
            this.elementData[index] = null;
            result = true;
        }
        return result;
    }

    /**
     * This method returns the size.
     *
     * @return size.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * This method return the index to adds.
     *
     * @param key the key.
     * @return the index to adds.
     */
    private int getIndexByHashKey(T key) {
        return key != null ? key.hashCode() % this.elementData.length : -1;
    }

    /**
     * This method returns iterator.
     *
     * @return new iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = this.index; i < elementData.length; i++) {
                    if (elementData[this.index] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public T next() {
                while (elementData[this.index] == null) {
                    index++;
                }
                return (T) elementData[this.index++];
            }
        };
    }

    /**
     * The construct.
     *
     * @param <T> generic.
     * @param <V> generic.
     */
    private class Node<T, V> {

        /**
         * The key.
         */
        private T key;

        /**
         * The value.
         */
        private V value;

        /**
         * The Constructor.
         *
         * @param key   the key.
         * @param value the value.
         */
        private Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
