package ru.job4j;

/**
 * The class SimpleStackContainer.
 * This class implements the Stack.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 28.03.2017
 */
public class SimpleStackContainer<T> implements SimpleQueue<T> {

    /**
     * Internal container.
     */
    private SimpleListContainer<T> simpleListContainer = new SimpleListContainer<T>();

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     */
    @Override
    public void push(T value) {
        this.simpleListContainer.add(value);
    }

    /**
     * This method returns an object from the container.
     *
     * @return object.
     */
    @Override
    public T pop() {
        T value = this.simpleListContainer.get(this.simpleListContainer.getSize() - 1);
        this.simpleListContainer.remove(this.simpleListContainer.getSize() - 1);
        return value;
    }
}
