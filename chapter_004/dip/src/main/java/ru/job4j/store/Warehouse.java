package ru.job4j.store;

import ru.job4j.food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Warehouse.
 * This class description the warehouse.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class Warehouse implements Store {

    /**
     * This field contains the list of food on warehouse.
     */
    private List<Food> warehouse = new ArrayList<>();

    /**
     * This method add a food in a warehouse.
     *
     * @param food any food.
     */
    @Override
    public void addFood(Food food) {
        double percLife = food.getPercentLife();
        if (percLife >= 0 && percLife <= 25) {
            this.warehouse.add(food);
        }
    }

    /**
     * This method return a list of food from store.
     */
    @Override
    public List<Food> getListFoodFromStore() {
        return this.warehouse;
    }
}
