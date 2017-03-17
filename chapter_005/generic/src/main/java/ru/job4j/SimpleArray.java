package ru.job4j;

/**
 * The class SimpleArray.
 *
 * @param <T> parameter.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.03.2017
 */
public class SimpleArray<T> {

    /**
     * Array of Object.
     */
    private Object[] object;

    /**
     * Index.
     */
    private int index;

    /**
     * The constructor.
     *
     * @param size size of array.
     */
    public SimpleArray(int size) {
        this.object = new Object[size];
    }

    /**
     * This method adds an element to the array.
     *
     * @param value value then adds in array.
     */
    public void add(T value) {
        this.object[index++] = value;
    }

    /**
     * This method gets an element from the array.
     *
     * @param index it is position from which to taken the value from the array.
     * @return T object.
     */
    public T get(int index) {
        return (T) this.object[index];
    }

    /**
     * This method delete an element from the array.
     *
     * @param index it is position from which to remove the value from the array.
     */
    public void delete(int index) {
        this.object[index] = null;
    }

    /**
     * This method update an element from the array.
     *
     * @param index it is position from which to update the value from the array.
     * @param value it is new value.
     */
    public void update(int index, T value) {
        this.object[index] = value;
    }

    /**
     * This method return the size of array.
     *
     * @return size of array.
     */
    public int size() {
        return this.object.length;
    }
}
