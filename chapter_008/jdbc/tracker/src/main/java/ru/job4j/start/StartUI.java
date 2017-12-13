package ru.job4j.start;

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
        Tracker tracker = new Tracker();
        tracker.connectToDB();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        do {
            System.out.println(descriptionProgram);
            menu.show();
            menu.select(input.ask("Select the action: ", menu.getRangeActions()));
        } while (!"Y".equals(this.input.ask("Do you realy exit? Press 'y' to eit: ").toUpperCase()));
        tracker.disconnectDB();
    }

    /**
     * main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput()).init();
    }
}
