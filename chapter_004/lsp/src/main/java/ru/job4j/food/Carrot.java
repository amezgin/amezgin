package ru.job4j.food;

import java.time.LocalDate;

/**
 * The class Carrot
 * This class description a vegetables.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class Carrot extends Vegetables {

    /**
     * The constructor.
     *
     * @param name       name.
     * @param price      price.
     * @param createDate date of create.
     * @param expireDate date of expire.
     * @param discount   discount.
     */
    public Carrot(String name, double price, LocalDate createDate, LocalDate expireDate, double discount) {
        super(name, price, createDate, expireDate, discount);
    }
}
