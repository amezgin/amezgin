package ru.job4j;

import java.util.Iterator;

/**
 * The class ConvertIterator.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.03.2017
 */
public class ConvertIterator implements Convert {

    /**
     * This method transforms Iterator<Iterator<Integer>> into Iterator<Integer>.
     *
     * @param it Iterator<Iterator<Integer>>.
     * @return Iterator<Integer>>.
     * @throws IteratorException exception.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) throws IteratorException {
        return new Iterator<Integer>() {

            private Iterator<Integer> currentIterator;

            {
                if (it != null && it.hasNext()) {
                    this.currentIterator = it.next();
                } else {
                    throw new IteratorException("Iterator<Iterator<Integer>> must be not null!");
                }
            }

            /**
             * This method returned true if the iterator has more elements.
             *
             * @return true if the iterator has more elements.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (checkCurrentIterator(this.currentIterator) && this.currentIterator.hasNext()) {
                    return true;
                } else if (it.hasNext()) {
                    this.currentIterator = getIterator(it);
                    return this.hasNext();
                }
                return result;

            }

            /**
             * This method returns the next even element in the iteration.
             *
             * @return the next even element in the iteration.
             */
            @Override
            public Integer next() {
                Integer result = null;
                if (checkCurrentIterator(this.currentIterator) && this.currentIterator.hasNext()) {
                    while (this.currentIterator.hasNext()) {
                        return this.currentIterator.next();
                    }
                } else if (it.hasNext()) {
                    this.currentIterator = getIterator(it);
                    return this.next();
                }
                return result;
            }

            /**
             * This method return the next Iterator.
             *
             * @return the next Iterator.
             */
            private Iterator<Integer> getIterator(Iterator<Iterator<Integer>> iter) {
                Iterator<Integer> iterator = null;
                while (iter.hasNext()) {
                    iterator = iter.next();
                    break;
                }
                return iterator;
            }

            /**
             * This method checked Iterator<Integer> iter.
             *
             * @param iter Iterator<Integer> iter.
             * @return true if Iterator<Integer> iter not null.
             */
            private boolean checkCurrentIterator(Iterator<Integer> iter) {
                return iter != null;
            }
        };
    }
}
