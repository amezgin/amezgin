package ru.job4j;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SearchBinaryTreeTest.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.07.2017
 */
public class SearchBinaryTreeTest {

    /**
     * Test method add() with result true.
     */
    @Test
    public void whenAddTwoElementThenReturnTrue() {
        SearchBinaryTree<Integer> myTree = new SearchBinaryTree<>();
        myTree.add(1);

        boolean result = myTree.add(1);

        assertThat(result, is(true));
    }

    /**
     * Test Tree hasNext() with result true.
     */
    @Test
    public void whenAddTreeElementThenReturnTrue() {
        SearchBinaryTree<Integer> myTree = new SearchBinaryTree<>();
        myTree.add(1);
        myTree.add(1);
        myTree.add(2);
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
        SearchBinaryTree<Integer> myTree = new SearchBinaryTree<>();
        myTree.add(1);
        myTree.add(1);
        Iterator iterator = myTree.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }
}