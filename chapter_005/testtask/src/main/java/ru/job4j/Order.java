package ru.job4j;

/**
 * Class Order.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class Order {
    /**
     * The book.
     */
    private final String book;

    /**
     * The operation.
     */
    private final String operation;


    /**
     * Price of the order.
     */
    private final float price;

    /**
     * Volume of the order.
     */
    private int volume;

    /**
     * Id of thr order.
     */
    private final int orderId;


    /**
     * The constructor.
     *
     * @param book      book.
     * @param operation operation.
     * @param price     price.
     * @param volume    volume.
     * @param orderId   orderId.
     */
    public Order(String book, String operation, float price, int volume, int orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * This method return the book.
     *
     * @return the book.
     */
    public String getBook() {
        return book;
    }

    /**
     * This method return operation of the order.
     *
     * @return the operation of the order.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method return the price of the order.
     *
     * @return the price of the order.
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method setup the new volume of the order.
     *
     * @param newVolume new volume.
     */
    public void setVolume(int newVolume) {
        this.volume += newVolume;
    }

    /**
     * This method return the volume of the order.
     *
     * @return the volume of the order.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * This method return the ID of the order.
     *
     * @return the ID of the order.
     */
    public int getOrderId() {
        return orderId;
    }
}