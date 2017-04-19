package ru.job4j;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * The class TestForAllTasks.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.04.2017
 */
public class TestForAllTasks {

    /**
     * Test for task 5.2.
     */
    @Test
    public void testForUserWithoutOverride() {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        User first = new UserWithoutOverride("Alex", 2, calendar);
        User second = new UserWithoutOverride("Alex", 2, calendar);

        map.put(first, new Object());
        map.put(second, new Object());

        System.out.println(map);
    }

    /**
     * Test for task 5.3.
     */
    @Test
    public void testForUserWithHashCodeOverride() {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        User first = new UserWithHashCodeOverride("Alex", 2, calendar);
        User second = new UserWithHashCodeOverride("Alex", 2, calendar);

        map.put(first, new Object());
        map.put(second, new Object());

        System.out.println(map);
    }

    /**
     * Test for task 5.4.
     */
    @Test
    public void testForUserWithEqualsOverride() {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        User first = new UserWithEqualsOverride("Alex", 2, calendar);
        User second = new UserWithEqualsOverride("Alex", 2, calendar);

        map.put(first, new Object());
        map.put(second, new Object());

        System.out.println(map);
    }

    /**
     * Test for task 5.5.
     */
    @Test
    public void testForUserWithEqualsAndHashCodeOverride() {
        Map<User, Object> map = new HashMap<>();
        Calendar calendar = new GregorianCalendar();
        User first = new UserWithEqualsAndHashCodeOverride("Alex", 2, calendar);
        User second = new UserWithEqualsAndHashCodeOverride("Alex", 2, calendar);

        map.put(first, new Object());
        map.put(second, new Object());

        System.out.println(map);
    }
}