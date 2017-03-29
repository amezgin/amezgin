package ru.job4j;

/**
 * The class Node.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.03.2017
 */
public class Node<T> {
    /**
     * Value.
     */
    private T value;

    /**
     * Pointer.
     */
    private Node<T> next;

    /**
     * The constructor.
     *
     * @param value value.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Getter.
     *
     * @return pointer.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter.
     *
     * @param next pointer to the next element.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
