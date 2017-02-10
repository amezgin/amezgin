package ru.job4j.store;

import ru.job4j.food.ReproductFood;

import java.util.List;

/**
 * Interface ReproductStore.
 * This interface description the store for reproduction food.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public interface ReproductStore {

    /**
     * This method add a reproduction food in a store.
     *
     * @param food any food.
     */
    void addFood(ReproductFood food);

    /**
     * This method return a list of food from reproduction store.
     *
     * @return list of food.
     */
    List<ReproductFood> getListFoodFromReproductStore();
}
