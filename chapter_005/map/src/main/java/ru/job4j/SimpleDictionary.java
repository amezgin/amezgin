package ru.job4j;

/**
 * The interface SimpleDictionary.
 *
 * @param <T> generic.
 * @param <V> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 1.05.2017
 */
public interface SimpleDictionary<T, V> extends Iterable<T> {

    /**
     * This method adds a new object to the container.
     *
     * @param key   the new key.
     * @param value the new object.
     * @return if object added then return true.
     */
    boolean insert(T key, V value);

    /**
     * This method returns the object at key.
     *
     * @param key the key.
     * @return the returned object.
     */
    V get(T key);

    /**
     * This method deletes the object from container at key.
     *
     * @param key key.
     * @return if object was deleted then return true.
     */
    boolean delete(T key);

    /**
     * This method returns the size.
     *
     * @return size.
     */
    int getSize();
}
