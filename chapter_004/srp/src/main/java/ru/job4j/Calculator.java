package ru.job4j;

import ru.job4j.actions.Add;
import ru.job4j.actions.Div;
import ru.job4j.actions.Multiple;
import ru.job4j.actions.Substruct;
import ru.job4j.actions.UserAction;
import ru.job4j.io.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Calculator.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 26.01.2007
 */
public class Calculator {

    /**
     * Private field result contains result of calculation.
     */
    private double result = 0;

    /**
     * Private field useLastResult is contains the condition to reuse the result of a calculation.
     */
    private boolean useLastResult;

    /**
     * This field contains list of user action.
     */
    private List<UserAction> userActionList = new ArrayList<>();

    /**
     * It is input interface.
     */
    private Input input;

    /**
     * The Constructor.
     *
     * @param input input.
     */
    public Calculator(Input input) {
        this.input = input;
    }

    /**
     * This method add user actions.
     */
    public void fillAction() {
        userActionList.add(new Add("This operation adds two numbers.", this.input, this));
        userActionList.add(new Substruct("This operation finds the difference between two numbers.", this.input, this));
        userActionList.add(new Div("This operation divides one number by another number.", this.input, this));
        userActionList.add(new Multiple("This operation multiplies two numbers.", this.input, this));
    }

    /**
     * This method selected the action.
     *
     * @param key key.
     */
    public void select(int key) {
        do {
            String answer = this.input.ask("Do you want to use the result from memory of the last calculation? "
                    + "Press 'y' to use or any key if not use: ");
            if (answer.equalsIgnoreCase("y")) {
                setUseLastResult(true);
            } else {
                setUseLastResult(false);
            }
            setResult(this.userActionList.get(key).execute(this.input));
            System.out.println(this.getResult());
        } while ("Y".equalsIgnoreCase(this.input.ask("Do you want to repeat this action? "
                + "Press 'y' to repeat or any key to exit: ")));
    }

    /**
     * This method show the menu of program.
     */
    public void show() {
        userActionList.stream().filter(action -> action != null).forEach(action -> System.out.println(action.info()));
    }

    /**
     * This method return list of user actions.
     *
     * @return list of user actions.
     */
    public List<UserAction> getUserActionList() {
        return userActionList;
    }

    /**
     * This method return result of calculation.
     *
     * @return result of calculation.
     */
    public double getResult() {
        return result;
    }

    /**
     * This nethod return the condition to reuse the result of a calculation.
     *
     * @return condition to reuse the result of a calculation.
     */
    public boolean isUseLastResult() {
        return useLastResult;
    }

    /**
     * This method save result of calculation.
     *
     * @param result result of calculation.
     */
    private void setResult(double result) {
        this.result = result;
    }

    /**
     * This method save the condition to reuse the result of a calculation.
     *
     * @param useLastResult the current condition to reuse the result of a calculation.
     */
    private void setUseLastResult(boolean useLastResult) {
        this.useLastResult = useLastResult;
    }

}
