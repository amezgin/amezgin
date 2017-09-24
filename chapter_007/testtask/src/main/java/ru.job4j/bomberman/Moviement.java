package ru.job4j.bomberman;

/**
 * Class Moviement.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.09.2017
 */
public class Moviement {

    /**
     * Movie up.
     *
     * @return int[].
     */
    public int[] movieUp() {
        return new int[]{0, 1};
    }

    /**
     * Movie down.
     *
     * @return int[].
     */
    public int[] movieDown() {
        return new int[]{0, -1};
    }

    /**
     * Movie left.
     *
     * @return int[].
     */
    public int[] movieLeft() {
        return new int[]{-1, 0};
    }

    /**
     * Movie right.
     *
     * @return int[].
     */
    public int[] movieRight() {
        return new int[]{1, 0};
    }
}