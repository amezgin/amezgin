package ru.job4j.frogsleap;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> path = new ArrayList<>();

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
            creatPath(startSegment, startRing, finishSegment, finishRing);
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
     * @param startSegment  the start segment.
     * @param startRing     the start ring.
     * @param finishSegment the finish segment.
     * @param finishRing    the finish ring.
     */
    private void creatPath(int startSegment, int startRing, int finishSegment, int finishRing) {
        int countJump = this.circle[finishSegment - 1][finishRing - 1];
        String coord = String.format("The finish coordinates is (%d, %d)", finishSegment, finishRing);
        this.path.add(coord);
        finishSegment = finishSegment - 1;
        int currentRing = finishRing - 1;
        while (countJump != 2) {
            int changeSegment = 0;
            int findStep = 0;
            for (int segmentStep = 1; segmentStep <= 3; segmentStep++) {
                for (int ring = 0; ring < 10; ring++) {
                    if (this.circle[finishSegment][currentRing]
                            - this.circle[(finishSegment - segmentStep + 16) % 16][ring] == 1
                            && (segmentStep + Math.abs(currentRing - ring)) == 3) {
                        currentRing = ring;
                        changeSegment = segmentStep;
                        countJump--;
                        findStep++;
                        coord = String.format("(%d, %d)", (finishSegment - segmentStep + 16) % 16 + 1, ring + 1);
                        this.path.add(coord);
                        break;
                    }
                }
                if (findStep != 0) {
                    break;
                }
            }
            finishSegment = (finishSegment - changeSegment + 16) % 16;
        }
        coord = String.format("The start coordinates is(%d, %d)", startSegment, startRing);
        this.path.add(coord);
    }

    /**
     * This method show the frog path.
     */
    private void showPath() {
        for (int i = this.path.size() - 1; i >= 0; i--) {
            System.out.println(this.path.get(i));
        }
    }
}
