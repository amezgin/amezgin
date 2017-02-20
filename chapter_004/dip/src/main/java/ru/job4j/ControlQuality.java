package ru.job4j;

import ru.job4j.food.Food;
import ru.job4j.store.Shop;
import ru.job4j.store.Store;
import ru.job4j.store.Trash;
import ru.job4j.store.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * The class ControlQuality.
 * This class distributes food at various stores.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class ControlQuality implements ResortFood {

    /**
     * This field description the list of store.
     */
    private List<Store> store = new ArrayList<>();

    /**
     * This method distributes food at various stores.
     *
     * @param food any food.
     */
    public void executeStrategy(Food food) {
        for (Store stor : this.store) {
            stor.addFood(food);
        }
    }

    /**
     * This method add stores to the list.
     */
    public void fillStore() {
        this.store.add(new Warehouse());
        this.store.add(new Shop());
        this.store.add(new Trash());
    }

    /**
     * This method resort a food at various stores.
     */
    @Override
    public void resort() {
        List<Food> tempStore = new ArrayList<>();
        for (Store stor : this.store) {
            if (stor == null) {
                continue;
            }
            for (Food food : stor.getListFoodFromStore()) {
                tempStore.add(food);
            }
            stor.getListFoodFromStore().clear();
        }
        for (Food food : tempStore) {
            executeStrategy(food);
        }
        tempStore.clear();
    }

    /**
     * This method return list of stores.
     *
     * @return list of stores.
     */
    public List<Store> getStore() {
        return this.store;
    }
}
