package ru.job4j.food;

import java.time.LocalDate;

/**
 * Abstract class Vegetables.
 * This class description vegetables foods.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public abstract class Vegetables extends Food {

    /**
     * The constructor.
     *
     * @param name       name.
     * @param price      price.
     * @param createDate date of create.
     * @param expireDate date of expire.
     * @param discount   discount.
     */
    public Vegetables(String name, double price, LocalDate createDate, LocalDate expireDate, double discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
