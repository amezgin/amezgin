package ru.job4j;

/**
 * The interface SimpleTree.
 *
 * @param <E> generic.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 27.06.2017
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add the child to the parent.
     * Parent can have the child list.
     *
     * @param parent parent.
     * @param child  child
     * @return if the item is added it returns true otherwise false.
     */
    boolean add(E parent, E child);
}
