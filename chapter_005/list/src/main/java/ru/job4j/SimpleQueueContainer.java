package ru.job4j;

/**
 * The class SimpleQueueContainer.
 * This class implements the Queue.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 28.03.2017
 */
public class SimpleQueueContainer<T> implements SimpleQueue<T> {
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
        T value = this.simpleListContainer.get(0);
        this.simpleListContainer.remove(0);
        return value;
    }
}
