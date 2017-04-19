package ru.job4j;

import java.util.Calendar;

/**
 * The class UserWithoutOverride without override hashCode and equals.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.04.2017
 */
public class UserWithoutOverride extends User {

    /**
     * The constructor.
     *
     * @param name     name.
     * @param children children.
     * @param birthday birthday.
     */
    public UserWithoutOverride(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }
}
