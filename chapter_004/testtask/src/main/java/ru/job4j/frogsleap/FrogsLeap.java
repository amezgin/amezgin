package ru.job4j.frogsleap;

import java.util.HashMap;
import java.util.Map;

/**
 * The class FrogsLeap.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.07.2017
 */
public class FrogsLeap {

    /**
     * The field where the jumping frog.
     */
    private int[][] circle = new int[16][10];

    /**
     * The way that makes the frog.
     */
    private Map<Integer, String> path = new HashMap<>();

    /**
     * This method considers the minimum number of jumps.
     *
     * @param startSector  the start sector.
     * @param finishSector the finish sector.
     * @param countTree    the number of trees.
     * @param coordTree    the coordinates the trees.
     * @return the minimum number of jumps.
     */
    public String countJump(String startSector, String finishSector, int countTree, String... coordTree) {
        String[] startCoords = startSector.split(",");
        int startSegment = Integer.parseInt(startCoords[0].trim());
        int startRing = Integer.parseInt(startCoords[1].trim());

        for (int i = 0; i < countTree; i++) {
            setTreeInArray(coordTree[i], -1);
        }

        jump(startSegment - 1, startRing - 1, 0, 0);

        String[] finishCoords = finishSector.split(",");
        int finishSegment = Integer.parseInt(finishCoords[0].trim());
        int finishRing = Integer.parseInt(finishCoords[1].trim());

        String result;

        if (this.circle[finishSegment - 1][finishRing - 1] <= 0) {
            result = "The frog cannot jump into this sector!";
        } else {
            createPath(finishSegment - 1, finishRing - 1, this.circle[finishSegment - 1][finishRing - 1]);
            showPath();
            result = String.format("The frog can jump into sector (%s) for %d jumps!", finishSector,
                    this.circle[finishSegment - 1][finishRing - 1] - 1);
        }
        return result;
    }

    /**
     * This method set trees on the field.
     *
     * @param coord coordinates trees.
     * @param sign  the sign of the tree.
     */
    private void setTreeInArray(String coord, int sign) {
        String[] coords = coord.split(",");
        int startSegment = Integer.parseInt(coords[0].trim());
        int startRing = Integer.parseInt(coords[1].trim());
        this.circle[startSegment - 1][startRing - 1] = sign;
    }

    /**
     * This method describes the jump.
     *
     * @param segment         the segment on the field.
     * @param ring            the ring on the field.
     * @param countSectorJump the number of sectors for jump.
     * @param countRingJump   the number of rings for jump.
     */
    private void jump(int segment, int ring, int countSectorJump, int countRingJump) {
        int countJump = this.circle[segment][ring];
        segment = (segment + countSectorJump) % 16;
        ring = ring + countRingJump;

        if (ring > 9 || ring < 0 || this.circle[segment][ring] == -1
                || this.circle[segment][ring] < countJump && this.circle[segment][ring] > 0) {
            return;
        }

        this.circle[segment][ring] = countJump + 1;

        jump(segment, ring, 3, 0);
        jump(segment, ring, 1, 2);
        jump(segment, ring, 1, -2);
        jump(segment, ring, 2, 1);
        jump(segment, ring, 2, -1);
    }

    /**
     * This method save the frog path.
     *
     * @param finishSegment the finish segment.
     * @param finishRing    the finish ring.
     * @param jump          count jump in definite sector.
     */
    private void createPath(int finishSegment, int finishRing, int jump) {
        String coord = String.format("(%d, %d)", (finishSegment + 17) % 16, finishRing + 1);
        if (finishRing > 9 || finishRing < 0 || this.circle[(finishSegment + 16) % 16][finishRing] == -1 || jump == 0) {
            return;
        }
        if (this.circle[(finishSegment + 16) % 16][finishRing] == jump) {
            this.path.put(jump, coord);
        }
        createPath(finishSegment - 3, finishRing, jump - 1);
        createPath(finishSegment - 2, finishRing - 1, jump - 1);
        createPath(finishSegment - 2, finishRing + 1, jump - 1);
        createPath(finishSegment - 1, finishRing - 2, jump - 1);
        createPath(finishSegment - 1, finishRing + 2, jump - 1);
    }

    /**
     * This method show the frog path.
     */
    private void showPath() {
        for (String value : path.values()) {
            System.out.print(value);
        }
    }
}