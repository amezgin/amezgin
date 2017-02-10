package ru.job4j.food;

import java.time.LocalDate;

/**
 * The class Bones
 * This class description a food bones.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class Bones extends ReproductFood {

    /**
     * The constructor.
     *
     * @param name         name.
     * @param price        price.
     * @param createDate   date of create.
     * @param expireDate   date of expire.
     * @param discount     discount.
     * @param canReproduct true or false.
     */
    public Bones(String name, double price, LocalDate createDate, LocalDate expireDate, double discount, boolean canReproduct) {
        super(name, price, createDate, expireDate, discount, canReproduct);
    }
}
