package ru.job4j;

import java.util.Iterator;

/**
 * The class SimpleLinkedSet.
 *
 * @param <T> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.03.2017
 */
public class SimpleLinkedSet<T> implements SimpleSet<T> {

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
     * @return if object added then return true.
     */
    @Override
    public boolean add(T value) {
        boolean result = false;
        Node<T> node = new Node<>(null, value, null);
        if (!checkDuplicate(value)) {
            if (this.size == 0) {
                this.first = node;
                this.last = node;
            } else {
                this.last.next = node;
                node.prev = this.last;
                this.last = node;
            }
            result = true;
            this.size++;
        }
        return result;
    }

    /**
     * This method checked value on duplicate in elementData.
     *
     * @param value any value.
     * @return if value not contains in the elementData then returns false.
     */
    private boolean checkDuplicate(T value) {
        boolean result = false;
        Node<T> tmp = this.first;
        while (tmp != null) {
            if (value.equals(tmp.item)) {
                result = true;
                break;
            }
            tmp = tmp.next;
        }
        return result;
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
