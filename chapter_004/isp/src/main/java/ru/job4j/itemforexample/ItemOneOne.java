package ru.job4j.itemforexample;

import ru.job4j.models.Item;

import java.util.List;

/**
 * The class ItemOneOne.
 * This class description a example item.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public class ItemOneOne extends Item {

    /**
     * The Constructor.
     *
     * @param name     name item.
     * @param children children list item.
     */
    public ItemOneOne(String name, List<Item> children) {
        super(name, children);
    }

    /**
     * This method execute an action.
     */
    @Override
    public void execute() {
        System.out.println("Selected menu item 1.1.");
    }

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key.
     */
    @Override
    public String key() {
        return "1.1";
    }
}
