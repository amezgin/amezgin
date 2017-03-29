package ru.job4j;

import java.util.Iterator;

/**
 * The class SimpleListContainer.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.03.2017
 */
public class SimpleListContainer<T> implements SimpleContainer<T> {

    /**
     * Pointer to first node.
     */
    private Node<T> first;

    /**
     * Pointer to last node.
     */
    private Node<T> last;

    /**
     * The size.
     */
    private int size;

    /**
     * This method returns the size.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * This method adds a new object to the container.
     *
     * @param value new object.
     */
    @Override
    public void add(T value) {
        Node<T> node = new Node<>(null, value, null);
        if (this.size == 0) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        size++;
    }

    /**
     * This method returns an object from the container by index.
     *
     * @param index index.
     * @return object.
     */
    @Override
    public T get(int index) {
        Node<T> node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    /**
     * This method removes an object from the container by index.
     *
     * @param index index.
     */
    public void remove(int index) {
        if (index == 0) {
            this.first = this.first.next;
            this.first.prev = null;
        } else if (index == this.size - 1) {
            this.last = this.last.prev;
            this.last.next = null;
        } else {
            Node<T> node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        this.size--;
    }

    /**
     * This method returns iterator.
     *
     * @return new iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            /**
             * The index.
             */
            private int index = 0;

            private T nextElement = null;

            private Node<T> currentNode = first;

            /**
             * This method returned true if the iterator has more elements.
             *
             * @return true if the iterator has more elements.
             */
            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            /**
             * This method returns the next even element in the iteration.
             *
             * @return the next even element in the iteration.
             */
            @Override
            public T next() {
                this.index++;
                Node<T> resultNode = this.currentNode;
                this.currentNode = this.currentNode.next;
                return resultNode.item;
            }
        };
    }

    /**
     * Class Node.
     *
     * @param <T> generic.
     */
    private static class Node<T> {
        /**
         * Item element.
         */
        private T item;

        /**
         * Pointer to the next element.
         */
        private Node<T> next;

        /**
         * Pointer to the prev element.
         */
        private Node<T> prev;

        /**
         * The construct.
         *
         * @param prev    Pointer to the prev element.
         * @param element item element.
         * @param next    Pointer to the next element.
         */
        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
