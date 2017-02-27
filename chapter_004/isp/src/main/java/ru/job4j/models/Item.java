package ru.job4j.models;

import ru.job4j.actions.UserAction;

/**
 * The class Item.
 * This interface description a some item.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 19.02.2017
 */
public abstract class Item implements UserAction {

    /**
     * The name of item.
     */
    private String name;

    /**
     * Children items.
     */
    private Item[] children;

    /**
     * The Constructor.
     *
     * @param name     name for item.
     * @param children list of children item.
     */
    public Item(String name, Item ... children) {
        this.name = name;
        this.children = children;
    }

    /**
     * Returns children of current item.
     *
     * @return List<Item> list of current item.
     */
    public Item[] getChildren() {
        return children;
    }

    /**
     * This method returns information about what this method does.
     *
     * @return information.
     */
    @Override
    public String info() {
        return String.format("%s %s", this.key(), this.name);
    }
}
