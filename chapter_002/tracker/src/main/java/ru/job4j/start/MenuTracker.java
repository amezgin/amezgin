package ru.job4j.start;

import ru.job4j.models.Comment;
import ru.job4j.models.Item;

/**
 *The class MenuTracker.
 * @author Alexander Mezgin
 * @since 18.12.2016
 * @version 1.0
 */
public class MenuTracker {

    /**
     *private field input.
     */
    private Input input;

    /**
     *private field tracker.
     */
    private Tracker tracker;

    /**
     * private field arrayslength.
     */
    private final int arrayslength = 8;
    /**
     * private field userAction.
     */
    private UserAction[] userActions = new UserAction[arrayslength];

    /**
     * private field position.
     */
    private int position = 0;

    /**
     * Constructor for class MenuTracker.
     * @param input input
     * @param tracker tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     *This method fill arrays of action.
     */
    public void fillAction() {
        this.userActions[position++] = new AddItem();
        this.userActions[position++] = new RemoveItem();
        this.userActions[position++] = new EditItem();
        this.userActions[position++] = new ShowItem();
        this.userActions[position++] = new FindByIdItem();
        this.userActions[position++] = new FindByNameItem();
        this.userActions[position++] = new FindByDescriptionItem();
        this.userActions[position++] = new AddComment();
    }

    /**
     *This method selected the action.
     *@param key key
     */
    public void select(int key) {
        this.userActions[key].execute(this.input, this.tracker);
    }

    /**
     *This method show the menu of programm.
     */
    public void show() {
        for (UserAction action: userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * The inner class AddItem.
     */
    private class AddItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 0;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input the name of the item: ");
            String description = input.ask("Input the description of the item: ");
            tracker.addItem(new Item(name, description));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * The inner class RemoveItem.
     */
    private class RemoveItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 1;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the deleted item: ");
            tracker.removeItem(tracker.findById(id));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item.");
        }
    }

    /**
     * The inner class EditItem.
     */
    private class EditItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 2;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the edited item: ");
            String name = input.ask("Input the new name of the item: ");
            String description = input.ask("Input the new description of the item: ");
            Item item = new Item(name, description);
            item.setId(id);
            tracker.editItem(item);
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit the item.");
        }
    }

    /**
     * The inner class ShowItem.
     */
    private class ShowItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 3;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.getAllItem().forEach(System.out::println);
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all item.");
        }
    }

    /**
     * The inner class FindByIdItem.
     */
    private class FindByIdItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 4;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the searched item: ");
            System.out.println(tracker.findById(id));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }

    /**
     * The inner class FindByNameItem.
     */
    private class FindByNameItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 5;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the name of the searched item: ");
            System.out.println(tracker.findByName(name));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }

    /**
     * The inner class FindByDescriptionItem.
     */
    private class FindByDescriptionItem implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 6;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String description = input.ask("Enter the description of the searched item: ");
            System.out.println(tracker.findByDescription(description));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by description.");
        }
    }

    /**
     * The inner class AddComment.
     */
    private class AddComment implements UserAction {

        /**
         *This method asks for the key on which the user performs an action.
         *@return key
         */
        @Override
        public int key() {
            final int k = 7;
            return k;
        }

        /**
         *This method performs the main action.
         *@param input is input interface
         *@param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the item to which to add a comment: ");
            String comment = input.ask("Enter the comment: ");
            System.out.println(tracker.addComment(id, new Comment(comment)));
        }

        /**
         *This method returns information about what this method does.
         *@return information
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add comment in to item.");
        }
    }
}
