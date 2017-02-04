package ru.job4j.actions;

import ru.job4j.Calculator;
import ru.job4j.io.Input;

/**
 * Class Multiple.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2007
 */
public class Multiple extends BaseAction {

    /**
     * private field input.
     */
    private Input input;

    /**
     * The Constructor.
     */
    private Calculator calc;

    /**
     * The Constructor.
     *
     * @param name  applies name.
     * @param input input.
     * @param calc  object of base class Calculator.
     */
    public Multiple(String name, Input input, Calculator calc) {
        super(name);
        this.input = input;
        this.calc = calc;
    }

    /**
     * This method asks for the key on which the user performs an action.
     *
     * @return key
     */
    @Override
    public int key() {
        return 3;
    }

    /**
     * This method calculates the multiple of the two arguments.
     *
     * @param input is input interface
     */
    @Override
    public double execute(Input input) {
        double subOne;
        double subTwo;
        if (!calc.isUseLastResult()) {
            subOne = Double.parseDouble(this.input.ask("Enter the first multiplier: "));
        } else {
            subOne = calc.getResult();
        }
        subTwo = Double.parseDouble(this.input.ask("Enter the second multiplier: "));
        return subOne * subTwo;
    }
}
