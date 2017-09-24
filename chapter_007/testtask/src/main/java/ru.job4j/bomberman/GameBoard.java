package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class GameBoard.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.09.2017
 */
public class GameBoard {

    /**
     * The size of board on X.
     */
    private final int xSize;

    /**
     * The size of board on Y.
     */
    private final int ySize;

    /**
     * The board.
     */
    private final ReentrantLock[][] board;

    /**
     * The constructor.
     *
     * @param xSize xSize.
     * @param ySize ySize.
     */
    public GameBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new ReentrantLock[xSize][ySize];
    }

    /**
     * This method return the board.
     *
     * @return board.
     */
    public ReentrantLock[][] getBoard() {
        return this.board;
    }

    /**
     * This method return the size board on X.
     *
     * @return size.
     */
    public int getxSize() {
        return xSize;
    }

    /**
     * This method return the size board on Y.
     *
     * @return size.
     */
    public int getySize() {
        return ySize;
    }

    /**
     * This method initialize the board.
     */
    public void init() {
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.xSize; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }
}