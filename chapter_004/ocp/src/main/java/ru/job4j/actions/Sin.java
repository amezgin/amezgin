package ru.job4j.actions;

import ru.job4j.Calculator;
import ru.job4j.io.Input;

import static java.lang.Math.sin;

/**
 * Class Sin.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.02.2017
 */
public class Sin extends BaseAction {

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
    public Sin(String name, Input input, Calculator calc) {
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
        return 4;
    }

    /**
     * This method calculates the sinus of the argument.
     *
     * @param input is input interface
     */
    @Override
    public double execute(Input input) {
        double arg;
        if (!calc.isUseLastResult()) {
            arg = Double.parseDouble(this.input.ask("Enter the argument."));
        } else {
            arg = calc.getResult();
        }
        return sin(arg);
    }
}
