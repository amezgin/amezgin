package ru.job4j.start;

import ru.job4j.models.Comment;
import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *The class Tracker.
 * @author Alexander Mezgin
 * @since 08.12.2016
 * @version 1.0
 */
public class Tracker {

    /**
     *Private fild "items" contains all Item.
     */
    private List<Item> items = new ArrayList<>();

    /**
     *Private fild "RN" creates a new object for generating random numbers.
     */
    private final Random rN = new Random();

    /**
     *This method add new Item in to list of items.
     *@param item is new Item
     *@return Item
     */
    public Item addItem(Item item) {
        item.setId(this.generateId());

        this.items.add(item);

        return item;
    }

    /**
     *This method edit  Item in to list of items.
     *@param item is edited Item
     */
    public void editItem(Item item) {
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index).getId().equals(item.getId())) {
                this.items.set(index, item);
                break;
            }
        }
    }

    /**
     *This method remove  Item in to list of items.
     *@param item is deleted Item
     */
    public void removeItem(Item item) {
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index).getId().equals(item.getId())) {
                this.items.remove(index);
                break;
            }
        }
    }

    /**
     *This method return list of items.
     *@return list of items
     */
    public List<Item> getAllItem() {
        return this.items;
    }

    /**
     *This method returns the Item.
     *@param id of Item
     *@return Item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     *This method returns the Item.
     *@param name of Item
     *@return Item
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item: this.items) {
            if (item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     *This method returns the list of Item.
     *@param descr of Item
     *@return list of Item
     */
    public List<Item> findByDescription(String descr) {
        List<Item> result = new ArrayList<>();
        for (Item item: this.items) {
            if (item.getDescription().contains(descr)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     *This method add new comment for the Item.
     *@param comment for Item
     *@param id is Item's id
     *@return item with added comment
     */
    public Item addComment(String id, Comment comment) {
        Item item = this.findById(id);
        item.addComments(comment);
        return item;
    }

    /**
     *This method generates random numbers.
     *@return new id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + rN.nextInt());
    }
}
