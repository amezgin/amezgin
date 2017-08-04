package ru.job4j.stopthread;

/**
 * Class CountChar.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 03.08.2017
 */
public class CountChar implements Runnable {

    /**
     * The text.
     */
    private String text;

    /**
     * The Constructor.
     *
     * @param text text.
     */
    public CountChar(String text) {
        this.text = text;
    }

    /**
     * The method run().
     */
    @Override
    public void run() {
        System.out.print(countSymbol());
    }

    /**
     * This method return the defined count symbol.
     *
     * @return count symbol.
     */
    private int countSymbol() {
        int count = 0;
        for (int i = 0; i < this.text.length(); i++) {
            if (Thread.currentThread().isInterrupted()) {
                count = -1;
                break;
            }
            if (this.text.charAt(i) == ',') {
                count++;
            }
        }
        return count;
    }
}