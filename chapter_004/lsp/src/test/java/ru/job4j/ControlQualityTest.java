package ru.job4j;

import org.junit.Test;
import ru.job4j.food.Food;
import ru.job4j.food.Milk;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class ControlQualityTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 05.02.2017
 */
public class ControlQualityTest {

    /**
     * Test method executeStrategy() with food with expire date.
     */
    @Test
    public void whenAddFoodWithExpireDateThenMoveFootInTrash() {
        Food milk = new Milk("name", 36, LocalDate.now().minusDays(8), LocalDate.now().minusDays(1), 0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        assertThat(controlQuality.getStore().get(2).getListFoodFromStore().size(), is(1));
    }

    /**
     * Test method executeStrategy() with food with percent life > 75%.
     */
    @Test
    public void whenAddFoodWithDateThenMoveWithDiscount() {
        Food milk = new Milk("name", 36, LocalDate.now().minusDays(20), LocalDate.now().plusDays(2), 0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        assertThat(controlQuality.getStore().get(1).getListFoodFromStore().get(0).getDiscount(), is(15.0));
    }

    /**
     * Test method executeStrategy() with food with percent life > 25% and < 75.
     */
    @Test
    public void whenAddFoodWithDateThenMoveToShop() {
        Food milk = new Milk("name", 36, LocalDate.now().minusDays(10), LocalDate.now().plusDays(2), 0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        assertThat(controlQuality.getStore().get(1).getListFoodFromStore().get(0).getName(), is("name"));
    }

    /**
     * Test method executeStrategy() with food with percent life < 25%.
     */
    @Test
    public void whenAddFoodWithDateThenMoveFootInWarehouse() {
        Food milk = new Milk("name", 36, LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), 0);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.fillStore();
        controlQuality.executeStrategy(milk);
        assertThat(controlQuality.getStore().get(0).getListFoodFromStore().size(), is(1));
    }
}