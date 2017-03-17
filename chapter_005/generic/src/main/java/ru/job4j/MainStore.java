package ru.job4j;

import java.util.NoSuchElementException;

/**
 * The class MainStore.
 *
 * @param <T> parametrize type.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.03.2017
 */
public abstract class MainStore<T extends Base> implements Store<T> {

    /**
     * Store.
     */
    private SimpleArray<T> simpleArray;

    /**
     * Constructor.
     *
     * @param size size of store.
     */
    public MainStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    /**
     * This method add new value.
     *
     * @param value add value.
     */
    @Override
    public void add(T value) {
        this.simpleArray.add(value);
    }

    /**
     * This method return value by identifier.
     *
     * @param id identifier.
     * @return value.
     */
    @Override
    public T get(String id) {
        return this.simpleArray.get(getByIndex(id));
    }

    /**
     * This method removes the value at the identifier.
     *
     * @param id identifier.
     */
    @Override
    public void delete(String id) {
        this.simpleArray.delete(getByIndex(id));
    }

    /**
     * This method updates the value at the identifier.
     *
     * @param id    identifier.
     * @param value new value.
     */
    @Override
    public void update(String id, T value) {
        this.simpleArray.update(getByIndex(id), value);
    }

    /**
     * This method return index the value in array.
     *
     * @param id identifier.
     * @return index.
     */
    private int getByIndex(String id) {
        int result = -1;
        for (int i = 0; i < this.simpleArray.size(); i++) {
            if (this.simpleArray.get(i) != null && this.simpleArray.get(i).getId().equals(id)) {
                result = i;
                break;
            } else {
                throw new NoSuchElementException(String.format("Element with id = %s not found!", id));
            }
        }
        return result;
    }
}
