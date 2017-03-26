package ru.job4j;

/**
 * The interface SimpleContainer.
 * This interface describes methods in the container.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 * @param <T> generic.
 */
public interface SimpleContainer<T> extends Iterable<T> {

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     */
    void add(T value);

    /**
     * This method returns an object from the container by index.
     *
     * @param index index.
     * @return object.
     */
    T get(int index);
}
