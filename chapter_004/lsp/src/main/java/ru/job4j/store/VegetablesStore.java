package ru.job4j.store;

import ru.job4j.food.Vegetables;

import java.util.List;

/**
 * Interface VegetablesStore.
 * This interface description the store for vegetables food.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public interface VegetablesStore {

    /**
     * This method add a vegetables food in a store.
     *
     * @param food any food.
     */
    void addFood(Vegetables food);

    /**
     * This method return a list of food from vegetables store.
     *
     * @return list of food.
     */
    List<Vegetables> getListFoodFromVegetablesStore();
}
