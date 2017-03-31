package ru.job4j;

/**
 * The interface SimpleSet.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.03.2017
 */
public interface SimpleSet<T> extends Iterable<T> {

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     * @return if object added then return true.
     */
    boolean add(T value);
}
