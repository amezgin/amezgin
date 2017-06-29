package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class TreeTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.06.2017
 */
public class TreeTest {

    /**
     * Test method add() with result true.
     */
    @Test
    public void whenAddFirstElementThenReturnTrue() {
        Tree<Integer> myTree = new Tree<>();

        boolean result = myTree.add(1, 1);

        assertThat(result, is(true));
    }

    /**
     * Test method add() with result false.
     */
    @Test
    public void whenAddElementThenNotHaveParentReturnFalse() {
        Tree<Integer> myTree = new Tree<>();
        myTree.add(2, 2);

        boolean result = myTree.add(1, 1);

        assertThat(result, is(false));
    }

    /**
     * Test Tree hasNext() with result true.
     */
    @Test
    public void whenAddTwoElementThenReturnTrue() {
        Tree<Integer> myTree = new Tree<>();
        myTree.add(1, 2);
        myTree.add(1, 1);
        Iterator iterator = myTree.iterator();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test Tree hasNext() with result false.
     */
    @Test
    public void whenAddTwoElementThenReturnFalse() {
        Tree<Integer> myTree = new Tree<>();
        myTree.add(1, 2);
        myTree.add(1, 1);
        Iterator iterator = myTree.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test Tree next() with result 2.
     */
    @Test
    public void whenAddTwoElementThenReturnTwo() {
        Tree<Integer> myTree = new Tree<>();
        myTree.add(1, 2);
        myTree.add(1, 1);
        Iterator iterator = myTree.iterator();
        iterator.next();

        assertThat(iterator.next(), is(2));
    }
}