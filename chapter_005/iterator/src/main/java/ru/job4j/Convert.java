package ru.job4j;

import java.util.Iterator;

/**
 * The interface Convert.
 * This interface describes a method that transforms Iterator<Iterator<Integer>> into Iterator<Integer>.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.03.2017
 */
public interface Convert {

    /**
     * This method transforms Iterator<Iterator<Integer>> into Iterator<Integer>.
     *
     * @param it Iterator<Iterator<Integer>>.
     * @return Iterator<Integer>.
     * @throws IteratorException exception.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) throws IteratorException;
}
