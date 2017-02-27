package ru.job4j.models;

import ru.job4j.itemforexample.ItemOne;
import ru.job4j.itemforexample.ItemOneOne;
import ru.job4j.itemforexample.ItemOneTwo;
import ru.job4j.itemforexample.ItemOneTwoThree;
import ru.job4j.itemforexample.ItemTwo;

/**
 * The class MenuItem.
 * This class description a menu.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public class MenuItem {

    /**
     * This field describes the menu array the first level.
     */
    private Item[] actions = new Item[2];

    /**
     * This method fill list of action.
     */
    public void fillAction() {
        this.actions[0] = new ItemOne("Item one", new ItemOneOne("Item one one", null),
                new ItemOneTwo("Item one two", new ItemOneTwoThree("Item one two three", null)));
        this.actions[1] = new ItemTwo("Item two", null);
    }

    /**
     * This method show menu.
     */
    public void show() {
        int countPrefix = 0;
        String prefix = "---";
        showMenu(this.actions, countPrefix, prefix);
    }

    /**
     * This method fills menu.
     *
     * @param actions     array actions.
     * @param countPrefix the number of prefixes in front of the menu item.
     * @param prefix      show prefix.
     */
    private void showMenu(Item[] actions, int countPrefix, String prefix) {
        for (Item item : actions) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < countPrefix; i++) {
                sb.append(prefix);
            }
            System.out.println(String.format("%s%s", sb.toString(), item.info()));

            if (item.getChildren() != null) {
                showMenu(item.getChildren(), countPrefix + 1, prefix);
            }
        }
    }
}
