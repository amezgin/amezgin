package ru.job4j.models;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Test for class StartUI with class StubInput.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public class MenuItemTest {

    /**
     * Test for MenuItem.
     */
    @Test
    public void whenGetMenuItemThenReturnMenu() {
        final MenuItem menuItem = new MenuItem();
        menuItem.fillAction();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        menuItem.show();
        String sep = System.getProperty("line.separator");
        final String result = baos.toString();
        final String original = String.format("1 Item one%s---1.1 Item one one%s---1.2 "
                + "Item one two%s------1.2.3 Item one two three%s2 Item two%s", sep, sep, sep, sep, sep);
        assertEquals(result, original);
    }
}