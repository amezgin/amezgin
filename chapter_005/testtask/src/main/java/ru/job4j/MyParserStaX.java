package ru.job4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class MyParserStaX.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class MyParserStaX {

    /**
     * This map contain the order books.
     */
    private Map<String, OrderBook> listBooks = new HashMap<>();

    /**
     * This method parse the file.
     *
     * @throws FileNotFoundException FileNotFoundException.
     * @throws XMLStreamException    XMLStreamException.
     */
    public void parse() throws FileNotFoundException, XMLStreamException {
        XMLStreamReader reader = XMLInputFactory.newInstance()
                .createXMLStreamReader("orders.xml", new FileInputStream("orders.xml"));
        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                if (reader.getLocalName().equals("AddOrder")) {
                    addOrder(reader);
                } else if (reader.getLocalName().equals("DeleteOrder")) {
                    deleteOrder(reader);
                }
            }
        }
        calcAllBooks();
    }

    /**
     * This method adds the order.
     *
     * @param reader reader.
     */
    private void addOrder(XMLStreamReader reader) {
        String book = reader.getAttributeValue(0);
        Order order = new Order(book,
                reader.getAttributeValue(1),
                Float.parseFloat(reader.getAttributeValue(2)),
                Integer.parseInt(reader.getAttributeValue(3)),
                Integer.parseInt(reader.getAttributeValue(4)));
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
     * @param reader reader.
     */
    private void deleteOrder(XMLStreamReader reader) {
        String book = reader.getAttributeValue(0);
        OrderBook orderBook = this.listBooks.get(book);
        orderBook.getUnsortedMap().remove((Integer.parseInt(reader.getAttributeValue(1))));
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