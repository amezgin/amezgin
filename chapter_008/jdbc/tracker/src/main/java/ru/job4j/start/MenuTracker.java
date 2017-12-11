package ru.job4j.start;

import ru.job4j.models.Comment;
import ru.job4j.models.Item;

/**
 * The class MenuTracker.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 18.12.2016
 */
public class MenuTracker {

    /**
     * private field input.
     */
    private Input input;

    /**
     * private field tracker.
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
     *
     * @param input   input
     * @param tracker tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * This method fill arrays of action.
     */
    public void fillAction() {
        this.userActions[position++] = new AddItem("Add the new item.");
        this.userActions[position++] = new RemoveItem("Delete the item.");
        this.userActions[position++] = new EditItem("Edit the item.");
        this.userActions[position++] = new ShowItem("Show all item.");
        this.userActions[position++] = new FindByIdItem("Find item by id.");
        this.userActions[position++] = new FindByNameItem("Find item by name.");
        this.userActions[position++] = new FindByDescriptionItem("Find item by description.");
        this.userActions[position++] = new AddComment("Add comment in to item.");
    }

    /**
     * This method selected the action.
     *
     * @param key key
     */
    public void select(int key) {
        this.userActions[key].execute(this.input, this.tracker);
    }

    /**
     * This method show the menu of programm.
     */
    public void show() {
        for (UserAction action : userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * This method return a number of ranges users action.
     *
     * @return int[] range
     */
    public int[] getRangeActions() {
        int[] range = new int[arrayslength];

        for (int i = 0; i < arrayslength; i++) {
            range[i] = userActions[i].key();
        }
        return range;
    }

    /**
     * The inner class AddItem.
     */
    private class AddItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        AddItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 0;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Input the name of the item: ");
            String description = input.ask("Input the description of the item: ");
            tracker.addItem(new Item(name, description));
        }
    }

    /**
     * The inner class RemoveItem.
     */
    private class RemoveItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        RemoveItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 1;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the deleted item: ");
            tracker.removeItem(tracker.findById(id));
        }
    }

    /**
     * The inner class EditItem.
     */
    private class EditItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        EditItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 2;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
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
    }

    /**
     * The inner class ShowItem.
     */
    private class ShowItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        ShowItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 3;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.getAllItem().forEach(System.out::println);
        }
    }

    /**
     * The inner class FindByIdItem.
     */
    private class FindByIdItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        FindByIdItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 4;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the searched item: ");
            System.out.println(tracker.findById(id));
        }
    }

    /**
     * The inner class FindByNameItem.
     */
    private class FindByNameItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        FindByNameItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 5;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the name of the searched item: ");
            System.out.println(tracker.findByName(name));
        }
    }

    /**
     * The inner class FindByDescriptionItem.
     */
    private class FindByDescriptionItem extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        FindByDescriptionItem(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 6;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String description = input.ask("Enter the description of the searched item: ");
            System.out.println(tracker.findByDescription(description));
        }
    }

    /**
     * The inner class AddComment.
     */
    private class AddComment extends BaseAction {

        /**
         * The Constructor.
         * @param name applies name
         */
        AddComment(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            final int k = 7;
            return k;
        }

        /**
         * This method performs the main action.
         *
         * @param input   is input interface
         * @param tracker is base class
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the item to which to add a comment: ");
            String comment = input.ask("Enter the comment: ");
            System.out.println(tracker.addComment(id, new Comment(comment)));
        }
    }
}
