package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The class SearchBinaryTree.
 *
 * @param <E> generic.
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.07.2017
 */
public class SearchBinaryTree<E extends Comparable<E>> implements Iterable<E> {

    /**
     * Root node.
     */
    private Node<E> rootNode;

    /**
     * The List tree elements.
     */
    private List<Node<E>> queue = new ArrayList<>();

    /**
     * This method add the new element into tree.
     *
     * @param value the value.
     * @return true if element added otherwise false.
     */
    public boolean add(E value) {
        boolean result;

        if (this.rootNode == null) {
            this.rootNode = new Node<>(value);
            result = true;
        } else {

            Node<E> currentRoot = search(this.rootNode, value);

            if (currentRoot.value.compareTo(value) > 0) {
                currentRoot.r = new Node(value);
                result = true;
            } else {
                currentRoot.l = new Node(value);
                result = true;
            }
        }
        return result;
    }

    /**
     * This method added elements from the tree into the List.
     *
     * @param start start element.
     */
    private void addElementToQueue(Node<E> start) {
        {
            if (start == null) {
                return;
            } else {
                queue.add(start);
                addElementToQueue(start.l);
                addElementToQueue(start.r);
            }
        }
    }

    /**
     * This method search a nod to insert.
     *
     * @param start start node.
     * @param value value.
     * @return if searched node then return it otherwise null.
     */
    private Node<E> search(Node<E> start, E value) {
        Node<E> result = start;

        if (start.r != null && start.value.compareTo(value) > 0) {
            result = search(start.r, value);
        }
        if (start.l != null && start.value.compareTo(value) <= 0) {
            result = search(start.l, value);
        }
        return result;
    }

    /**
     * This method returns iterator.
     *
     * @return new iterator.
     */
    @Override
    public Iterator<E> iterator() {
        if (this.rootNode != null) {
            this.queue.add(this.rootNode);
            addElementToQueue(this.rootNode);
        }
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = this.index; i < queue.size(); i++) {
                    if (queue.get(this.index) != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public E next() {
                return queue.get(this.index++).value;
            }
        };
    }

    /**
     * The class Node.
     *
     * @param <E> generic.
     */
    class Node<E> {
        /**
         * The value.
         */
        private E value;

        /**
         * Left and right children.
         */
        private Node l, r;

        /**
         * The Constructor.
         *
         * @param value value.
         */
        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            return value != null ? value.equals(node.value) : node.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }
}
