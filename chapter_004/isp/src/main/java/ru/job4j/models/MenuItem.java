package ru.job4j.models;

import ru.job4j.itemforexample.ItemOne;
import ru.job4j.itemforexample.ItemOneOne;
import ru.job4j.itemforexample.ItemOneTwo;
import ru.job4j.itemforexample.ItemOneTwoThree;
import ru.job4j.itemforexample.ItemTwo;

import java.util.ArrayList;
import java.util.List;

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
     * This field describes the menu list the first level.
     */
    private List<Item> actions = new ArrayList<>();

    /**
     * This field describes the menu list the second level.
     */
    private List<Item> secondLevelMenuFistItem = new ArrayList<>();

    /**
     * This field describes the menu list the third level.
     */
    private List<Item> thirdLevelMenuFirstItem = new ArrayList<>();

    /**
     * This method fill list of action.
     */
    public void fillAction() {
        fillSecondLevelFirstItemAction();
        this.actions.add(new ItemOne("Item one", secondLevelMenuFistItem));
        this.actions.add(new ItemTwo("Item two", null));
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
     * This method fill list of action second level.
     */
    private void fillSecondLevelFirstItemAction() {
        fillThirdLevelFirstItemAction();
        this.secondLevelMenuFistItem.add(new ItemOneOne("Item one one", null));
        this.secondLevelMenuFistItem.add(new ItemOneTwo("Item one two", thirdLevelMenuFirstItem));
    }

    /**
     * This method fill list of action third level.
     */
    private void fillThirdLevelFirstItemAction() {
        this.thirdLevelMenuFirstItem.add(new ItemOneTwoThree("Item one two three", null));
    }

    /**
     * This method fills menu.
     *
     * @param actions     list actions.
     * @param countPrefix the number of prefixes in front of the menu item.
     * @param prefix      show prefix.
     */
    private void showMenu(List<Item> actions, int countPrefix, String prefix) {
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
