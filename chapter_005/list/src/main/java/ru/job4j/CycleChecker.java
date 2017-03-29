package ru.job4j;

/**
 * The class CycleChecker.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.03.2017
 */
public class CycleChecker {

    /**
     * This method determines the connectivity list.
     *
     * @param first first element in list.
     * @return if list is connectivity then return true.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;

        if (first == null) {
            return false;
        }

        Node firstElement = first;
        Node secondElement = first.getNext();

        while (true) {
            if (firstElement == secondElement) {
                result = true;
                break;
            }

            if (firstElement == null || secondElement == null || secondElement.getNext() == null) {
                result = false;
                break;
            }

            firstElement = firstElement.getNext();
            secondElement = secondElement.getNext().getNext();
        }
        return result;
    }
}
