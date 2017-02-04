package ru.job4j;

import org.junit.Test;
import ru.job4j.io.Input;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class EnginCalculatorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 04.02.2017
 */
public class EnginCalculatorTest {

    /**
     * Test fillAction().
     */
    @Test
    public void whenGetActionsThenReturnListAction() {
        final String[] answers = {"0"};
        Input input = new StubInput(answers);
        Calculator calc = new EnginCalculator(input);
        calc.fillAction();
        assertThat(calc.getUserActionList().size(), is(6));
    }

    /**
     * Test select() with sin.
     */
    @Test
    public void whenGetSinThenReturnResultZero() {
        final String[] answers = {"n", "0", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new EnginCalculator(input);
        calc.fillAction();
        calc.select(4);
        assertThat(calc.getResult(), is(0.0));
    }

    /**
     * Test select() with cos.
     */
    @Test
    public void whenGetCosThenReturnResultOne() {
        final String[] answers = {"n", "0", "n", "y"};
        Input input = new StubInput(answers);
        Calculator calc = new EnginCalculator(input);
        calc.fillAction();
        calc.select(5);
        assertThat(calc.getResult(), is(1.0));
    }
}