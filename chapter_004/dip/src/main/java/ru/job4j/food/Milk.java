package ru.job4j.food;

import java.time.LocalDate;

/**
 * Class Milk.
 * This class description milk.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class Milk extends Food {

    /**
     * The constructor.
     *
     * @param name       name.
     * @param price      price.
     * @param createDate date of create.
     * @param expireDate date of expire.
     * @param discount   discount.
     */
    public Milk(String name, double price, LocalDate createDate, LocalDate expireDate, double discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
