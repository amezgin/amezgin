package ru.job4j;

import java.io.IOException;

/**
 * Class Main.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 25.09.2017
 */
public class Main {
    /**
     * Main.
     *
     * @param args args.
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        ParserXML parser = new ParserXML();
        parser.load();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}