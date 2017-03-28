package ru.job4j;

/**
 * The interface SimpleQueue.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 28.03.2017
 */
public interface SimpleQueue<T> {

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     */
    void push(T value);

    /**
     * This method returns an object from the container.
     *
     * @return object.
     */
    T pop();
}
