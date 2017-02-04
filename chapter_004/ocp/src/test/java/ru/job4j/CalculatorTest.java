package ru.job4j;

import org.junit.Test;
import ru.job4j.io.Input;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class CalculatorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 31.01.2017
 */
public class CalculatorTest {

    /**
     * Test fillAction().
     */
    @Test
    public void whenGetActionsThenReturnListAction() {
        final String[] answers = {"0"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        assertThat(calc.getUserActionList().size(), is(4));
    }

    /**
     * Test select() with add.
     */
    @Test
    public void whenGetAddThenReturnResultFour() {
        final String[] answers = {"n", "2", "2", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        calc.select(0);
        assertThat(calc.getResult(), is(4.0));
    }

    /**
     * Test select() with sub.
     */
    @Test
    public void whenGetSubThenReturnResultMinusOne() {
        final String[] answers = {"n", "2", "3", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        calc.select(1);
        assertThat(calc.getResult(), is(-1.0));
    }

    /**
     * Test select() with div.
     */
    @Test
    public void whenGetDivThenReturnResultOne() {
        final String[] answers = {"n", "1", "1", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        calc.select(2);
        assertThat(calc.getResult(), is(1.0));
    }

    /**
     * Test select() with mul.
     */
    @Test
    public void whenGetMulThenReturnResultFive() {
        final String[] answers = {"n", "5", "1", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new Calculator(input);
        calc.fillAction();
        calc.select(3);
        assertThat(calc.getResult(), is(5.0));
    }
}