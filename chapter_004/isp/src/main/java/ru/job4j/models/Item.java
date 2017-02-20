package ru.job4j.models;

import ru.job4j.actions.UserAction;

import java.util.List;

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
    private List<Item> children;

    /**
     * The Constructor.
     *
     * @param name     name for item.
     * @param children list of children item.
     */
    public Item(String name, List<Item> children) {
        this.name = name;
        this.children = children;
    }

    /**
     * Returns children of current item.
     *
     * @return List<Item> list of current item.
     */
    public List<Item> getChildren() {
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
