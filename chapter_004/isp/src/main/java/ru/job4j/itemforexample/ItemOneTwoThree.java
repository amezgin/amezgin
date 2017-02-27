package ru.job4j.itemforexample;

import ru.job4j.models.Item;

/**
 * The class ItemOneTwoThree.
 * This class description a example item.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public class ItemOneTwoThree extends Item {

    /**
     * The Constructor.
     *
     * @param name     name item.
     * @param children children list item.
     */
    public ItemOneTwoThree(String name, Item ... children) {
        super(name, children);
    }

    /**
     * This method execute an action.
     */
    @Override
    public void execute() {
        System.out.println("Selected menu item 1.2.3.");
    }

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key.
     */
    @Override
    public String key() {
        return "1.2.3";
    }
}
