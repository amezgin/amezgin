package ru.job4j.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Monster.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 01.10.2017
 */
public class Monster extends Figure implements Runnable {

    /**
     * The moviement.
     */
    private Moviement moviement = new Moviement();

    /**
     * The stop factor.
     */
    private boolean stop = false;

    /**
     * The constructor.
     *
     * @param name  name.
     * @param board board.
     */
    public Monster(String name, GameBoard board) {
        super(board, name);
    }

    /**
     * The run.
     */
    @Override
    public void run() {
        this.setStartPosition();
        while (true) {
            try {
                movie();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method description the move.
     *
     * @throws InterruptedException InterruptedException.
     */
    @Override
    public void movie() throws InterruptedException {
        boolean resultMovie = false;
        int x = 0;
        int y = 0;
        Random random = new Random();
        while (!resultMovie) {
            int randomMovie = random.nextInt(4);
            switch (randomMovie) {
                case 0: {
                    x = this.getPosition()[0];
                    y = this.getPosition()[1] + this.moviement.movieUp()[1];
                    break;
                }
                case 1: {
                    x = this.getPosition()[0];
                    y = this.getPosition()[1] + this.moviement.movieDown()[1];
                    break;
                }
                case 2: {
                    x = this.getPosition()[0] + this.moviement.movieLeft()[0];
                    y = this.getPosition()[1];
                    break;
                }
                case 3: {
                    x = this.getPosition()[0] + this.moviement.movieRight()[0];
                    y = this.getPosition()[1];
                    break;
                }
                default: {
                    break;
                }
            }
            if (checkMovie(x, y)) {
                ReentrantLock cell = this.getBoard().getBoard()[x][y];
                resultMovie = cell.tryLock(500, TimeUnit.MILLISECONDS);
            }
        }
        this.getBoard().getBoard()[this.getPosition()[0]][this.getPosition()[1]].unlock();
        this.setPosition(x, y);
    }

    /**
     * This method setup the start position the monster.
     */
    private void setStartPosition() {
        int coordX = (int) (Math.random() * (this.getBoard().getxSize() - 1) + 0.5);
        int coordY = (int) (Math.random() * (this.getBoard().getySize() - 1) + 0.5);
        boolean value = false;
        while (!value) {
            if (!this.getBoard().getBoard()[coordX][coordY].isLocked() && coordX != 0 && coordY != 0) {
                this.setPosition(coordX, coordY);
                this.getBoard().getBoard()[coordX][coordY].lock();
                value = true;
            }
        }
    }
}