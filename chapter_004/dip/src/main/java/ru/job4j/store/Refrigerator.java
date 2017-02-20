package ru.job4j.store;

import ru.job4j.food.Vegetables;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Reproduct.
 * This class description the refrigerator.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class Refrigerator implements VegetablesStore {

    /**
     * This field contains the list of food on shop.
     */
    private List<Vegetables> ref = new ArrayList<>();

    /**
     * This method add a vegetables food in a refrigerator.
     *
     * @param food any food.
     */
    @Override
    public void addFood(Vegetables food) {
        double percLife = food.getPercentLife();
        if (percLife >= 0 && percLife <= 25) {
            this.ref.add(food);
        }
    }

    /**
     * This method return a list of food from store.
     */
    @Override
    public List<Vegetables> getListFoodFromVegetablesStore() {
        return this.ref;
    }
}
