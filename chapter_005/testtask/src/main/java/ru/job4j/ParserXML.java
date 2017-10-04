package ru.job4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ParserXML.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class ParserXML {

    /**
     * This map contain the order books.
     */
    private Map<String, OrderBook> orders = new HashMap<>();

    /**
     * This method starts the parsing.
     *
     * @throws IOException IOException.
     */
    public void load() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("orders.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("<A")) {
                    final Order order = this.parse(line, true);
                    OrderBook list = orders.get(order.getBook());
                    if (list == null) {
                        list = new OrderBook(order.getBook());
                        orders.put(order.getBook(), list);
                    }
                    list.addToUnsortedMap(order);
                } else if (line.startsWith("<D")) {
                    final Order order = this.parse(line, false);
                    orders.get(order.getBook()).getUnsortedMap().remove((order.getOrderId()));
                }
            }
            calcAllBooks();
        }
    }

    /**
     * This method parse the file.
     *
     * @param text text.
     * @param add  true or false.
     * @return order.
     */
    private Order parse(final String text, boolean add) {
        boolean start = false;
        int pos = -1;
        String[] values = new String[5];
        int current = 0;
        for (int i = 0; i != text.length(); ++i) {
            if (text.charAt(i) == '\"') {
                if (start) {
                    values[current++] = text.substring(pos + 1, i);
                    start = false;
                } else {
                    start = true;
                }
                pos = i;
            }
        }
        if (add) {
            return new Order(
                    values[0],
                    "SELL".equals(values[1]) ? "SELL" : "BUY",
                    Float.valueOf(values[2]),
                    Integer.valueOf(values[3]),
                    Integer.valueOf(values[4])
            );
        } else {
            return new Order(values[0], "BUY", 0, 0, Integer.valueOf(values[1]));
        }
    }

    /**
     * This method starts the calculate of the all books.
     */
    private void calcAllBooks() {
        for (OrderBook book : this.orders.values()) {
            book.calculate();
        }
    }
}