package ru.job4j;

import org.junit.Test;
import ru.job4j.exceptions.MenuOutException;
import ru.job4j.io.Input;

/**
 * Test for class InteractCalc.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.01.2017
 */
public class InteractCalcTest {

    /**
     * Test init() with Exception.
     *
     * @throws MenuOutException "Please select correct key from menu!".
     */
    @Test(expected = MenuOutException.class)
    public void whenGetIncorrectNumberActionsThenReturnException() {
        final String[] answers = {"5"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        InteractCalc iCalc = new InteractCalc(input, calc);
        iCalc.init();
    }
}