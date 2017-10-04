package ru.job4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class MyParser.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class MyParser {

    /**
     * This map contain the order books.
     */
    private Map<String, OrderBook> listBooks = new HashMap<>();

    /**
     * This method parse the file.
     */
    public void parse() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("orders.xml")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parse = line.split("\"");
                if (line.startsWith("<Add")) {
                    addOrder(parse);
                } else if (line.startsWith("<Del")) {
                    deleteOrder(parse);
                }
            }
            calcAllBooks();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * This method adds the order.
     *
     * @param arr array.
     */
    private void addOrder(String[] arr) {
        String book = arr[1];
        Order order = new Order(book,
                arr[3],
                Float.parseFloat(arr[5]),
                Integer.parseInt(arr[7]),
                Integer.parseInt(arr[9]));
        OrderBook orderBook = this.listBooks.get(book);

        if (orderBook == null) {
            orderBook = new OrderBook(book);
            this.listBooks.put(book, orderBook);
        }
        orderBook.addToUnsortedMap(order);
    }

    /**
     * This method delete the order.
     *
     * @param arr array.
     */
    private void deleteOrder(String[] arr) {
        String book = arr[1];
        OrderBook orderBook = this.listBooks.get(book);
        orderBook.getUnsortedMap().remove(Integer.parseInt(arr[3]));
    }

    /**
     * This method starts the calculate of the all books.
     */
    private void calcAllBooks() {
        for (OrderBook book : this.listBooks.values()) {
            book.calculate();
        }
    }
}