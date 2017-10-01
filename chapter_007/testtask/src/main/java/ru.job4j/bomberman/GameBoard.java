package ru.job4j.bomberman;

import java.util.Random;
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
     * The number playerAndMonsters.
     */
    private final int numberMonsters;

    /**
     * The array of playerAndMonsters.
     */
    private Thread[] playerAndMonsters;

    /**
     * The number locked bloks.
     */
    private final int numberLockedBloks;

    /**
     * The board.
     */
    private final ReentrantLock[][] board;

    /**
     * The constructor.
     *
     * @param xSize             xSize.
     * @param ySize             ySize.
     * @param numberMonsters    number Monsters.
     * @param numberLockedBloks number locked bloks.
     */
    public GameBoard(int xSize, int ySize, int numberMonsters, int numberLockedBloks) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.numberMonsters = numberMonsters;
        this.numberLockedBloks = numberLockedBloks;
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
     * This method return player and monsters.
     *
     * @return player and monsters.
     */
    public Thread[] getPlayerAndMonsters() {
        return this.playerAndMonsters;
    }

    /**
     * This method initialize the board.
     */
    public void startBoard() {
        init();
        setLockedBlocks();
        setPlayerAndMonsters();
    }

    /**
     * This method setup locked blocks.
     */
    private void setLockedBlocks() {
        for (int i = 0; i < this.numberLockedBloks; i++) {
            Random random = new Random();
            boolean value = false;
            while (!value) {
                int coordX = random.nextInt(this.xSize);
                int coordY = random.nextInt(this.ySize);
                if (!this.getBoard()[coordX][coordY].isLocked() && coordX != 0 && coordY != 0) {
                    this.getBoard()[coordX][coordY].lock();
                    value = true;
                }
            }
        }
    }

    /**
     * This method setup the playerAndMonsters.
     */
    private void setPlayerAndMonsters() {
        this.playerAndMonsters = new Thread[this.numberMonsters + 1];
        this.playerAndMonsters[0] = new Thread(new Bomberman("Hero", this));
        for (int i = 1; i < this.playerAndMonsters.length; i++) {
            this.playerAndMonsters[i] = new Thread(new Monster("Monster" + i, this));
        }
        for (int i = 0; i < this.playerAndMonsters.length; i++) {
            this.playerAndMonsters[i].start();
        }
    }

    /**
     * This method first initialize the board.
     */
    private void init() {
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.xSize; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }
}