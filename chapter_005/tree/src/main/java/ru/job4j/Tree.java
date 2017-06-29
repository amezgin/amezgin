package ru.job4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The class Tree.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 27.06.2017
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

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
     * @param parent parent.
     * @param child  child.
     * @return true if element added otherwise false.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;

        if (this.rootNode == null) {
            this.rootNode = new Node<>(parent);
            this.rootNode.children.add(new Node<>(child));
            result = true;
        } else {
            Node<E> parentRoot = search(this.rootNode, parent);
            if (parentRoot != null) {
                result = parentRoot.children.add(new Node<>(child));
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
        for (Node<E> child : start.children) {
            if (child == null) {
                return;
            } else {
                queue.add(child);
                addElementToQueue(child);
            }
        }
    }

    /**
     * This method search a nod to insert.
     *
     * @param start  start node.
     * @param parent parent.
     * @return if searched node then return it otherwise null.
     */
    private Node<E> search(Node<E> start, E parent) {
        Node<E> result = null;

        if (start.value.compareTo(parent) == 0) {
            result = start;
        } else {
            for (Node<E> child : start.children) {
                result = search(child, parent);
            }
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
         * Set tree children.
         */
        private Set<Node<E>> children;

        /**
         * The value.
         */
        private E value;

        /**
         * The Constructor.
         *
         * @param value value.
         */
        Node(E value) {
            this.children = new LinkedHashSet<>();
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
