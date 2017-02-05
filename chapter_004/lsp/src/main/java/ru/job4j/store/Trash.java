package ru.job4j.store;

import ru.job4j.food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Trash.
 * This class description the trash.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class Trash implements Store {

    /**
     * This field contains the list of food on trash.
     */
    private List<Food> trash = new ArrayList<>();

    /**
     * This method add a food in a warehouse.
     *
     * @param food any food.
     */
    @Override
    public void addFood(Food food) {
        double percLife = food.getPercentLife();
        if (percLife >= 100) {
            this.trash.add(food);
        }
    }

    /**
     * This method return a list of food from store.
     */
    @Override
    public List<Food> getListFoodFromStore() {
        return this.trash;
    }
}
