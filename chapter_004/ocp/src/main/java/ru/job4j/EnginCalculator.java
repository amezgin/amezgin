package ru.job4j;

import ru.job4j.actions.Cos;
import ru.job4j.actions.Sin;
import ru.job4j.io.Input;

/**
 * Class Calculator.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.02.2007
 */
public class EnginCalculator extends Calculator {

    /**
     * It is input interface.
     */
    private Input input;

    /**
     * The Constructor.
     *
     * @param input input.
     */
    public EnginCalculator(Input input) {
        super(input);
        this.input = input;
    }

    /**
     * This method add user actions.
     */
    @Override
    public void fillAction() {
        super.fillAction();
        getUserActionList().add(new Sin("This operation calculate the sinus.", this.input, this));
        getUserActionList().add(new Cos("This operation calculate the cosine.", this.input, this));
    }
}
