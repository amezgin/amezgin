package ru.job4j.start;

import ru.job4j.models.Comment;
import ru.job4j.models.Item;

/**
 * The class StartUI.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.12.2016
 */
public class StartUI {
    /**
     * Private fild Input.
     */
    private Input input;

    /**
     * The private fild description the program.
     */
    private String descriptionProgram = "This program allows you to create"
            + " applications and work with them. To perform a certain action, "
            + "select the appropriate option.";

    /**
     * The class constructor.
     *
     * @param input input
     */
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     * This method displays a menu and description of the program.
     */
    private void init() {
        boolean exit = false;
        Tracker tracker = new Tracker();

        do {
            System.out.println(descriptionProgram);
            showMenu();

            String action = input.ask("Choose action: ");

            switch (action) {
                case "1":
                    String name = input.ask("Input the name of the item: ");
                    String description = input.ask("Input the description of the item: ");
                    tracker.addItem(new Item(name, description));
                    break;
                case "2":
                    String id = input.ask("Enter the id of the deleted item: ");
                    tracker.removeItem(tracker.findById(id));
                    break;
                case "3":
                    id = input.ask("Enter the id of the edited item: ");
                    name = input.ask("Input the new name of the item: ");
                    description = input.ask("Input the new description of the item: ");
                    Item item = new Item(name, description);
                    item.setId(id);
                    tracker.editItem(item);
                    break;
                case "4":
                    tracker.getAllItem().forEach(System.out::println);
                    break;
                case "5":
                    id = input.ask("Enter the id of the searched item: ");
                    System.out.println(tracker.findById(id));
                    break;
                case "6":
                    name = input.ask("Enter the name of the searched item: ");
                    System.out.println(tracker.findByName(name));
                    break;
                case "7":
                    description = input.ask("Enter the description of the searched item: ");
                    System.out.println(tracker.findByDescription(description));
                    break;
                case "8":
                    id = input.ask("Enter the id of the item to which to add a comment: ");
                    String comment = input.ask("Enter the comment: ");
                    System.out.println(tracker.addComment(id, new Comment(comment)));
                    break;
                case "9":
                    String exitProgram = input.ask("Do you realy exit? Y/N: ");
                    if (exitProgram.toUpperCase().equals("Y")) {
                        exit = true;
                        System.out.println("See your later!");
                    }
                    break;
                default:
                    System.out.println("Your choose action is incorrect! Choose correct action!");
                    System.out.println();
                    System.out.println();
                    break;
            }
        } while (!exit);
    }

    /**
     * This method organizes the menu of the program.
     */
    private void showMenu() {
        System.out.println("Add new item - 1.");
        System.out.println("Delete item - 2.");
        System.out.println("Edit item - 3.");
        System.out.println("Show all item - 4.");
        System.out.println("Find item by id - 5.");
        System.out.println("Find item by name - 6.");
        System.out.println("Find item by description - 7.");
        System.out.println("Add comment - 8.");
        System.out.println("Exit - 9.");
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
}
