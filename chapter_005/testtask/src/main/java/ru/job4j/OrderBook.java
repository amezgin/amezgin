package ru.job4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class OrderBook.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class OrderBook {

    /**
     * The line separator.
     */
    private final static String lineSeparator = System.getProperty("line.separator");

    /**
     * The name of order book.
     */
    private String orderBookName;

    /**
     * This map contains the unsorted orders from xml file.
     */
    private Map<Integer, Order> unsortedMap = new HashMap<>();

    /**
     * This map contains the sorted orders on buy.
     */
    private Map<Float, Order> sortedBuy = new TreeMap<>(Collections.reverseOrder());

    /**
     * This map contains the sorted orders on sell.
     */
    private Map<Float, Order> sortedSell = new TreeMap<>();

    /**
     * The constructor.
     *
     * @param orderBookName name of order book.
     */
    public OrderBook(String orderBookName) {
        this.orderBookName = orderBookName;
    }

    /**
     * This method adds order in the unsorted map.
     *
     * @param order the order.
     */
    public void addToUnsortedMap(Order order) {
        this.unsortedMap.put(order.getOrderId(), order);
    }

    /**
     * The method return the unsorted map.
     *
     * @return the unsorted map.
     */
    public Map getUnsortedMap() {
        return this.unsortedMap;
    }

    /**
     * This method distributes the orders from unsorted map to sorted map.
     * Also this method make deals between sell and buy orders and print result to screen.
     */
    public void calculate() {
        for (Order order : this.unsortedMap.values()) {

            if (order.getOperation().equals("SELL")) {
                add(this.sortedSell, order);
            } else {
                add(this.sortedBuy, order);
            }
        }
        this.matching();
        this.show();
    }

    /**
     * This method adds the order in correct map.
     *
     * @param map   the map.
     * @param order the order.
     */
    private void add(Map<Float, Order> map, Order order) {
        Order findWithPrice = map.get(order.getPrice());
        if (findWithPrice != null) {
            findWithPrice.setVolume(order.getVolume());
        } else {
            map.put(order.getPrice(), order);
        }
    }

    /**
     * This method make deals between sell and buy orders.
     */
    private void matching() {
        Iterator<Float> iterSell = this.sortedSell.keySet().iterator();
        Iterator<Float> iterBuy = this.sortedBuy.keySet().iterator();
        if (iterBuy.hasNext() && iterSell.hasNext()) {
            Float nextBuy = iterBuy.next();
            Float nextSell = iterSell.next();
            while (iterBuy.hasNext() && iterSell.hasNext()) {
                if (nextBuy >= nextSell) {
                    int valueSell = this.sortedSell.get(nextSell).getVolume();
                    int valueBuy = this.sortedBuy.get(nextBuy).getVolume();
                    int diff = valueSell - valueBuy;
                    if (diff > 0) {
                        this.sortedSell.get(nextSell).setVolume(-valueBuy);
                        iterBuy.remove();
                        nextBuy = iterBuy.next();
                    } else if (diff < 0) {
                        this.sortedBuy.get(nextBuy).setVolume(-valueSell);
                        iterSell.remove();
                        nextSell = iterSell.next();
                    } else {
                        iterBuy.remove();
                        nextBuy = iterBuy.next();
                        iterSell.remove();
                        nextSell = iterSell.next();
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * This method print the result to screen.
     */
    private void show() {
        StringBuilder builder = new StringBuilder();
        System.out.println(String.format("\tOrder book: $%s", this.orderBookName));
        System.out.println(String.format("\tBID\t\t\t  ASK"));
        System.out.println(String.format("Volume@Price – Volume@Price"));
        Iterator<Float> iterSell = this.sortedSell.keySet().iterator();
        Iterator<Float> iterBuy = this.sortedBuy.keySet().iterator();
        Float nextBuy = 0f;
        Float nextSell = 0f;
        int maxSize = Math.max(this.sortedBuy.size(), this.sortedSell.size());
        for (int i = 0; i < maxSize; i++) {
            if (iterBuy.hasNext() && iterSell.hasNext()) {
                nextBuy = iterBuy.next();
                nextSell = iterSell.next();
                builder.append(String.format("%7d@%6.2f - %7d@%.2f%s", this.sortedBuy.get(nextBuy).getVolume(),
                        this.sortedBuy.get(nextBuy).getPrice(),
                        this.sortedSell.get(nextSell).getVolume(),
                        this.sortedSell.get(nextSell).getPrice(),
                        lineSeparator));
            } else if (iterBuy.hasNext() && !iterSell.hasNext()) {
                nextBuy = iterBuy.next();
                builder.append(String.format("%7d@%6.2f - --------------%s", this.sortedBuy.get(nextBuy).getVolume(),
                        this.sortedBuy.get(nextBuy).getPrice(),
                        lineSeparator));
            } else {
                nextSell = iterSell.next();
                builder.append(String.format("-------------- - %7d@%6.2f%s", this.sortedSell.get(nextSell).getVolume(),
                        this.sortedSell.get(nextSell).getPrice(),
                        lineSeparator));
            }
        }
        System.out.println(builder);
    }
}