package ru.job4j.bomberman;

/**
 * Abstract class Figure.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.09.2017
 */
public abstract class Figure {

    /**
     * The board of game.
     */
    private GameBoard board;

    /**
     * Name.
     */
    private String name;

    /**
     * The position on X.
     */
    private int xPosition;

    /**
     * The position on Y.
     */
    private int yPosition;

    /**
     * The constructor.
     *
     * @param board board.
     * @param name  name.
     */
    public Figure(GameBoard board, String name) {
        this.board = board;
        this.name = name;
    }

    /**
     * This method description the move.
     *
     * @throws InterruptedException InterruptedException.
     */
    public abstract void movie() throws InterruptedException;

    /**
     * This method return the name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method return coordinates the figure.
     *
     * @return coordinates.
     */
    public int[] getPosition() {
        return new int[]{this.xPosition, this.yPosition};
    }

    /**
     * This method setup new coordinates the figure.
     *
     * @param xPosition xPosition.
     * @param yPosition yPosition.
     */
    public void setPosition(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * This method return the board.
     *
     * @return board.
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * This method checks the valid movie.
     *
     * @param x x.
     * @param y y.
     * @return true if movie valid otherwise false.
     */
    protected boolean checkMovie(int x, int y) {
        boolean result = true;
        if (x >= this.getBoard().getxSize() || x < 0 || y >= this.getBoard().getySize() || y < 0) {
            result = false;
        }
        return result;
    }
}