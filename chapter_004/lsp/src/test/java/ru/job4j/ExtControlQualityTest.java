package ru.job4j;

import org.junit.Test;
import ru.job4j.food.Bones;
import ru.job4j.food.Milk;
import ru.job4j.food.Carrot;
import ru.job4j.food.Vegetables;
import ru.job4j.food.ReproductFood;
import ru.job4j.store.ExtWarehouse;
import ru.job4j.food.Food;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class ExtControlQualityTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 09.02.2017
 */
public class ExtControlQualityTest {

    /**
     * Test method executeVegetablesStrategy() with food with percent life < 25%.
     */
    @Test
    public void whenAddVegetablesWithDateThenMoveFootInRefrigerator() {
        Vegetables carrot = new Carrot("name!", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0);
        ExtControlQuality controlQuality = new ExtControlQuality();
        controlQuality.fillStore();
        controlQuality.fillVegetablesStore();
        controlQuality.executeVegetablesStrategy(carrot);
        assertThat(controlQuality.getStoreVeg().size(), is(1));
    }

    /**
     * Test method executeReproductStrategy() with food with percent life < 25%.
     */
    @Test
    public void whenAddReproductFoodWithDateThenMoveFootInReproduct() {
        ReproductFood bones = new Bones("name!", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0, true);
        ExtControlQuality controlQuality = new ExtControlQuality();
        controlQuality.fillStore();
        controlQuality.fillReproductStore();
        controlQuality.executeReproductStrategy(bones);
        assertThat(controlQuality.getStoreRep().size(), is(1));
    }

    /**
     * Test method executeStrategy() with food with percent life < 25%.
     */
    @Test
    public void whenAddFoodWithDateThenMoveFootInWarehouse() {
        Food milk = new Milk("name!", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0);
        ExtControlQuality controlQuality = new ExtControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        assertThat(controlQuality.getStore().get(0).getListFoodFromStore().size(), is(1));
    }

    /**
     * Test method executeStrategy() with food with percent life < 25%.
     */
    @Test
    public void whenAddFoodWithDateThenMoveFootInExtWarehouse() {
        Food milk = new Milk("name!", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0);
        Food milk1 = new Milk("name!!", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0);
        ExtControlQuality controlQuality = new ExtControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        controlQuality.executeStrategy(milk1);
        ExtWarehouse extWarehouse = (ExtWarehouse) controlQuality.getStore().get(0);
        assertThat(extWarehouse.getListFoodFromExtStore().size(), is(1));
    }


}