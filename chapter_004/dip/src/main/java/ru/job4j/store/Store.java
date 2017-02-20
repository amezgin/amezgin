package ru.job4j.store;

import ru.job4j.food.Food;

import java.util.List;

/**
 * Interface Store.
 * This interface description any stores.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public interface Store {

    /**
     * This method add a food in a store.
     *
     * @param food any food.
     */
    void addFood(Food food);

    /**
     * This method return a list of food from store.
     *
     * @return list of food.
     */
    List<Food> getListFoodFromStore();
}
