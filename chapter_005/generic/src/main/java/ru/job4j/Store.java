package ru.job4j;

/**
 * The interface Store.
 *
 * @param <T> parametrize type.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.03.2017
 */
public interface Store<T extends Base> {

    /**
     * This method add new value.
     *
     * @param value add value.
     */
    void add(T value);

    /**
     * This method return value by identifier.
     *
     * @param id identifier.
     * @return value.
     */
    T get(String id);

    /**
     * This method removes the value at the identifier.
     *
     * @param id identifier.
     */
    void delete(String id);

    /**
     * This method updates the value at the identifier.
     *
     * @param id    identifier.
     * @param value new value.
     */
    void update(String id, T value);
}
