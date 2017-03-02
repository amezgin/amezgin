package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class EvenNumbersIteratorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.03.2017
 */
public class ConvertIteratorTest {

    /**
     * Test for method convert() whit normal iterator.
     *
     * @throws IteratorException
     * @throws IteratorException exception.
     */
    @Test
    public void whenGetIteratorIteratorShouldReturnIterator() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{0, 9, 8, 7, 5})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4})).iterator());

        ConvertIterator ci = new ConvertIterator();
        Iterator<Integer> it = ci.convert(list.iterator());

        int result = 0;
        while (it.hasNext()) {
            result++;
            it.next();
        }

        assertThat(result, is(21));
    }

    /**
     * Test for method convert() when iterator contains null.
     *
     * @throws IteratorException exception.
     */
    @Test
    public void whenGetIteratorIteratorWithNullShouldReturnIterator() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4})).iterator());

        ConvertIterator ci = new ConvertIterator();
        Iterator<Integer> it = ci.convert(list.iterator());

        int result = 0;
        while (it.hasNext()) {
            result++;
            it.next();
        }

        assertThat(result, is(16));
    }

    /**
     * Test for method convert() when iterator = null.
     *
     * @throws IteratorException exception.
     */
    @Test(expected = IteratorException.class)
    public void whenGetIteratorIteratorNullShouldReturnException() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();

        new ConvertIterator().convert(list.iterator());
    }

    /**
     * Test for method next().
     *
     * @throws IteratorException exception.
     */
    @Test
    public void whenGetNextCallShouldReturnPointerForward() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{4})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{0, 9, 8, 7, 5})).iterator());
        ConvertIterator ci = new ConvertIterator();
        Iterator<Integer> it = ci.convert(list.iterator());

        it.next();
        int result = it.next();

        assertThat(result, is(0));
    }

    /**
     * Test method hasNext() when returned true.
     *
     * @throws IteratorException exception.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContainValueTrue() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{4})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{1})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{0, 9, 8, 7, 5})).iterator());
        ConvertIterator ci = new ConvertIterator();
        Iterator<Integer> it = ci.convert(list.iterator());

        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test method hasNext() when returned false.
     *
     * @throws IteratorException exception.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContainValueFalse() throws IteratorException {
        List<Iterator<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{4})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{1})).iterator());
        list.add(new ArrayList<>(Arrays.asList(new Integer[]{0})).iterator());
        ConvertIterator ci = new ConvertIterator();
        Iterator<Integer> it = ci.convert(list.iterator());

        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }
}