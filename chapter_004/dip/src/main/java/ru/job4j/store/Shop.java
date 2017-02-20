package ru.job4j.store;

import ru.job4j.food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Shop.
 * This class description the shop.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class Shop implements Store {

    /**
     * This field contains the list of food on trash.
     */
    private List<Food> shop = new ArrayList<>();

    /**
     * This method add a food in a shop.
     *
     * @param food any food.
     */
    @Override
    public void addFood(Food food) {
        double percLife = food.getPercentLife();
        if (percLife > 25 && percLife <= 75) {
            this.shop.add(food);
        }
        if (percLife > 75 && percLife < 100) {
            food.setDiscount(15);
            this.shop.add(food);
        }
    }

    /**
     * This method return a list of food from store.
     */
    @Override
    public List<Food> getListFoodFromStore() {
        return this.shop;
    }
}
