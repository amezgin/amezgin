package ru.job4j.store;

import ru.job4j.food.ReproductFood;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Reproduct.
 * This class description the reproduct store.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class Reproduct implements ReproductStore {

    /**
     * This field contains the list of food on reproduct store.
     */
    private List<ReproductFood> reproduct = new ArrayList<>();

    /**
     * This method add a vegetables food in a reproduct store.
     *
     * @param food any food.
     */
    @Override
    public void addFood(ReproductFood food) {
        double percLife = food.getPercentLife();
        if (percLife >= 100) {
            this.reproduct.add(food);
        }
    }

    /**
     * This method return a list of food from store.
     */
    @Override
    public List<ReproductFood> getListFoodFromReproductStore() {
        return this.reproduct;
    }
}