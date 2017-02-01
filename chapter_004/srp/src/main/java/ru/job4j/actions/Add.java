package ru.job4j.actions;

import ru.job4j.Calculator;
import ru.job4j.io.Input;

/**
 * Class Add.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2007
 */
public class Add extends BaseAction {

    /**
     * Private field input.
     */
    private Input input;

    /**
     * Private field calc.
     */
    private Calculator calc;

    /**
     * The Constructor.
     *
     * @param name  applies name.
     * @param input input.
     * @param calc  object of base class Calculator.
     */
    public Add(String name, Input input, Calculator calc) {
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
        return 0;
    }

    /**
     * This method calculates the sum of the two arguments.
     *
     * @param input is input interface
     */
    @Override
    public double execute(Input input) {
        double termOne;
        double termTwo;
        if (!calc.isUseLastResult()) {
            termOne = Double.parseDouble(this.input.ask("Enter the first term."));
        } else {
            termOne = calc.getResult();
        }
        termTwo = Double.parseDouble(input.ask("Enter the second term."));
        return termOne + termTwo;
    }
}
