package ru.job4j;

import ru.job4j.io.Input;
import ru.job4j.io.ValidateInput;

/**
 * Class InteractCalc.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2007
 */
public class InteractCalc {

    /**
     * Private field Input.
     */
    private Input input;

    /**
     * private field calc.
     */
    private Calculator calc;

    /**
     * The Constructor.
     *
     * @param input input.
     * @param calc  object of base class Calculator.
     */
    public InteractCalc(Input input, Calculator calc) {
        this.input = input;
        this.calc = calc;
    }

    /**
     * This method displays a menu.
     */
    public void init() {
        do {
            this.calc.show();
            this.calc.select(this.input.ask("Select the action: ", calc.getUserActionList()));
            System.out.println(calc.getResult());
        } while (!"Y".equalsIgnoreCase(this.input.ask("Do you really exit? Press 'y' to exit: ")));
    }

    /**
     * Main.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Calculator calc = new EnginCalculator(input);
        calc.fillAction();
        InteractCalc iCalc = new InteractCalc(input, calc);
        iCalc.init();
    }
}
