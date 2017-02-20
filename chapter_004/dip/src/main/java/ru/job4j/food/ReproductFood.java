package ru.job4j.food;

import java.time.LocalDate;

/**
 * The abstract class ReproductFood.
 * This class description a food then can be recycled.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public abstract class ReproductFood extends Food {

    /**
     * This field show that a food can be recycled.
     */
    private boolean canReproduct;

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
    public ReproductFood(String name, double price, LocalDate createDate, LocalDate expireDate,
                         double discount, boolean canReproduct) {
        super(name, price, createDate, expireDate, discount);
        this.canReproduct = canReproduct;
    }

    /**
     * This method returns a value that indicates that the product can be recycled.
     *
     * @return true or false.
     */
    public boolean isCanReproduct() {
        return canReproduct;
    }
}
