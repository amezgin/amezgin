package ru.job4j;

import ru.job4j.food.ReproductFood;
import ru.job4j.food.Vegetables;
import ru.job4j.store.ExtWarehouse;
import ru.job4j.store.Refrigerator;
import ru.job4j.store.Reproduct;
import ru.job4j.store.ReproductStore;
import ru.job4j.store.Shop;
import ru.job4j.store.Trash;
import ru.job4j.store.VegetablesStore;

import java.util.ArrayList;
import java.util.List;

/**
 * The class ExtControlQuality extends the class ControlQuality.
 * This class distributes food at various stores.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.02.2017
 */
public class ExtControlQuality extends ControlQuality {

    /**
     * This field description the list of Reproduct store.
     */
    private List<ReproductStore> storeRep = new ArrayList<>();

    /**
     * This field description the list of Vegetables store.
     */
    private List<VegetablesStore> storeVeg = new ArrayList<>();

    /**
     * This method distributes food at various stores.
     *
     * @param food any food.
     */
    public void executeVegetablesStrategy(Vegetables food) {
        for (VegetablesStore stor : this.storeVeg) {
            stor.addFood(food);
        }
        super.executeStrategy(food);
    }

    /**
     * This method distributes food at various stores.
     *
     * @param food any food.
     */
    public void executeReproductStrategy(ReproductFood food) {
        for (ReproductStore stor : this.storeRep) {
            stor.addFood(food);
        }
        super.executeStrategy(food);
    }

    /**
     * This method add stores to the list.
     */
    @Override
    public void fillStore() {
        super.getStore().add(new ExtWarehouse());
        super.getStore().add(new Shop());
        super.getStore().add(new Trash());
    }

    /**
     * This method add Reproduct stores to the list.
     */
    public void fillReproductStore() {
        this.storeRep.add(new Reproduct());
    }

    /**
     * This method add Vegetables stores to the list.
     */
    public void fillVegetablesStore() {
        this.storeVeg.add(new Refrigerator());
    }

    /**
     * This method return list of stores.
     *
     * @return list of stores.
     */
    public List<VegetablesStore> getStoreVeg() {
        return storeVeg;
    }

    /**
     * This method return list of stores.
     *
     * @return list of stores.
     */
    public List<ReproductStore> getStoreRep() {
        return storeRep;
    }


}
