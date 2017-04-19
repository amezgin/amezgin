package ru.job4j;

import java.util.Calendar;

/**
 * The abstract class User.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.04.2017
 */
public abstract class User {

    /**
     * The field name.
     */
    private String name;

    /**
     * The field children description the count children.
     */
    private int children;

    /**
     * The field birthday.
     */
    private Calendar birthday;

    /**
     * The constructor.
     *
     * @param name     name.
     * @param children children.
     * @param birthday birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Getter for name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for children.
     *
     * @return children.
     */
    public int getChildren() {
        return children;
    }

    /**
     * Getter for birthday.
     *
     * @return birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
