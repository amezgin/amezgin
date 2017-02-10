package ru.job4j.store;

import ru.job4j.food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * The class ExtWarehouse.
 * This class description the extends warehouse.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class ExtWarehouse extends Warehouse {

    /**
     * This field contains the list of food on extends warehouse.
     */
    private List<Food> warehouseExt = new ArrayList<>();

    /**
     * This method add a food in a extends warehouse if super warehause is full (this size = 1).
     * Otherwise the food is added to the original warehouse.
     *
     * @param food any food.
     */
    @Override
    public void addFood(Food food) {
        double percLife = food.getPercentLife();
        if (percLife >= 0 && percLife <= 25 && super.getListFoodFromStore().size() >= 1) {
            this.warehouseExt.add(food);
        } else if (percLife >= 0 && percLife <= 25 && super.getListFoodFromStore().size() < 1) {
            super.getListFoodFromStore().add(food);
        }
    }

    /**
     * This method return a list of food from store.
     *
     * @return list of food.
     */
    public List<Food> getListFoodFromExtStore() {
        return this.warehouseExt;
    }
}
