package ru.job4j.start;

import ru.job4j.models.Comment;
import ru.job4j.models.Item;

/**
 * The class StartUITest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.12.2016
 */
public class StartUITest {

    /**
     * Private fild Input.
     */
    private Input input;

    /**
     * Private fild idItem.
     */
    private int idItem = 0;

    /**
     * The private fild description the program.
     */
    private String descriptionProgram = "This program allows you to create"
            + " applications and work with them. To perform a certain action, "
            + "select the appropriate option.";

    /**
     * Private fild idItem.
     */
    private Tracker tracker = new Tracker();

    /**
     * The class constructor.
     *
     * @param input input
     */
    public StartUITest(Input input) {
        this.input = input;
    }

    /**
     * This method displays a menu and description of the program.
     */
    private void init() {
        boolean exit = false;

        do {
            System.out.println(descriptionProgram);
            showMenu();

            String action = input.ask("Choose action: ");

            switch (action) {
                case "1":
                    String name = input.ask("Input the name of the item: ");
                    String description = input.ask("Input the description of the item: ");
                    Item item = new Item(name, description);
                    tracker.addItem(item);
                    item.setId(String.valueOf(++idItem));
                    System.out.println();
                    System.out.println("Added item!");
                    System.out.println();
                    break;
                case "2":
                    String id = input.ask("Enter the id of the deleted item: ");
                    tracker.removeItem(tracker.findById(id));
                    System.out.println();
                    System.out.println("Deleted item!");
                    System.out.println();
                    break;
                case "3":
                    id = input.ask("Enter the id of the edited item: ");
                    name = input.ask("Input the new name of the item: ");
                    description = input.ask("Input the new description of the item: ");
                    Item item1 = new Item(name, description);
                    item1.setId(id);
                    tracker.editItem(item1);
                    System.out.println();
                    System.out.println("Edited item!");
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    tracker.getAllItem().forEach(System.out::println);
                    System.out.println();
                    break;
                case "5":
                    id = input.ask("Enter the id of the searched item: ");
                    System.out.println();
                    System.out.println("Fined item by id!");
                    System.out.println();
                    System.out.println(tracker.findById(id));
                    System.out.println();
                    break;
                case "6":
                    name = input.ask("Enter the name of the searched item: ");
                    System.out.println();
                    System.out.println("Fined item by name!");
                    System.out.println();
                    System.out.println(tracker.findByName(name));
                    System.out.println();
                    break;
                case "7":
                    description = input.ask("Enter the description of the searched item: ");
                    System.out.println();
                    System.out.println("Fined item by description!");
                    System.out.println();
                    System.out.println(tracker.findByDescription(description));
                    System.out.println();
                    break;
                case "8":
                    id = input.ask("Enter the id of the item to which to add a comment: ");
                    String comment = input.ask("Enter the comment: ");
                    System.out.println();
                    System.out.println("Added comment!");
                    System.out.println();
                    System.out.println(tracker.addComment(id, new Comment(comment)));
                    System.out.println();
                    break;
                case "9":
                    String exitProgram = input.ask("Do you realy exit? Y/N: ");
                    if (exitProgram.toUpperCase().equals("Y")) {
                        exit = true;
                        System.out.println();
                        System.out.println("See your later!");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println();
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
        /**
         * Private fild answers.
         */
        String[] answers = {
                "1", "name1", "description1",
                "1", "name2", "description2",
                "1", "name3", "description3",
                "4",
                "2", "2",
                "4",
                "3", "1", "nameEdit", "descriptionEdit",
                "4",
                "5", "1",
                "6", "name3",
                "7", "descr",
                "8", "1", "comment",
                "4",
                "10",
                "9", "y"
        };
        new StartUITest(new StubInput(answers)).init();
    }
}
