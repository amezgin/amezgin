package ru.job4j.food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Abstract class Food.
 * This class description foods.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public abstract class Food {
    /**
     * This field description the name of a food.
     */
    private String name;

    /**
     * This field description the price of a food.
     */
    private double price;

    /**
     * This field description the discount on a food.
     */
    private double discount;

    /**
     * This field description the date of create a food.
     */
    private LocalDate createDate;

    /**
     * This field description the date of expire a food.
     */
    private LocalDate expireDate;

    /**
     * The constructor.
     *
     * @param name       name.
     * @param price      price.
     * @param createDate date of create.
     * @param expireDate date of expire.
     * @param discount   discount.
     */
    public Food(String name, double price, LocalDate createDate, LocalDate expireDate, double discount) {
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.discount = discount;
    }

    /**
     * This method return the food's name.
     *
     * @return food's name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method return the food's price.
     *
     * @return food's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method return the food's discount.
     *
     * @return food's discount.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * This method setup the food's discount.
     *
     * @param discount new discount.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * This method return the creation date of the product.
     *
     * @return the creation date of the product.
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * This method return the expire date of the product.
     *
     * @return the expire date of the product.
     */
    public LocalDate getExpireDate() {
        return expireDate;
    }

    /**
     * This method calculate the shelf life.
     *
     * @return shelf life in percent.
     */
    public double getPercentLife() {
        LocalDate currentDate = LocalDate.now();
        long timeFromCreateToCurrentTime = ChronoUnit.DAYS.between(this.getCreateDate(), currentDate);
        long timeFromCreateToExpireTime = ChronoUnit.DAYS.between(this.getCreateDate(), this.getExpireDate());
        return 1.0 * timeFromCreateToCurrentTime / timeFromCreateToExpireTime * 100;
    }
}
