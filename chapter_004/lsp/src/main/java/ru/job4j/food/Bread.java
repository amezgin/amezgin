package ru.job4j.food;

import java.time.LocalDate;

/**
 * Class Bread.
 * This class description bread.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class Bread extends Food {

    /**
     * The constructor.
     *
     * @param name       name.
     * @param price      price.
     * @param createDate date of create.
     * @param expireDate date of expire.
     * @param discount   discount.
     */
    public Bread(String name, double price, LocalDate createDate, LocalDate expireDate, double discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
