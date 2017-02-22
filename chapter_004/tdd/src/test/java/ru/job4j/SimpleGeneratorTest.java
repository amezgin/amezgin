package ru.job4j;

import org.junit.Test;
import ru.job4j.exception.KeyNotFoundException;
import ru.job4j.exception.MapContainsExtraKayException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class SimpleGeneratorTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public class SimpleGeneratorTest {

    /**
     * Test when all alright.
     *
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKayException exception when map contains extra keys.
     */
    @Test
    public void whenGetTemplateThenReturnedReplacedString() throws KeyNotFoundException, MapContainsExtraKayException {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String test = "I am a Alex, Who are you?";

        String result = simpleGenerator.generate(template, map);

        assertThat(result, is(test));
    }

    /**
     * Test when all alright with many same keys.
     *
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKayException exception when map contains extra keys.
     */
    @Test
    public void whenGetTemplateWithSomeKeysThenReturnedReplacedString() throws KeyNotFoundException, MapContainsExtraKayException {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("sos", "AAA!");
        String template = " Help, ${sos}, ${sos}, ${sos}";
        String test = " Help, AAA!, AAA!, AAA!";

        String result = simpleGenerator.generate(template, map);

        assertThat(result, is(test));
    }

    /**
     * Test when map not contains keys.
     *
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKayException exception when map contains extra keys.
     */
    @Test(expected = KeyNotFoundException.class)
    public void whenGetTemplateAndMapNotHasKeyThenReturnedException() throws KeyNotFoundException, MapContainsExtraKayException {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Alex");
        map.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";

        simpleGenerator.generate(template, map);
    }

    /**
     * Test when map has extra keys.
     *
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKayException exception when map contains extra keys.
     */
    @Test(expected = MapContainsExtraKayException.class)
    public void whenGetTemplateAndMapHasExtraKeyThenReturnedException() throws KeyNotFoundException, MapContainsExtraKayException {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("subject", "you");
        map.put("location", "Russia");
        String template = "I am a ${name}, Who are ${subject}?";

        simpleGenerator.generate(template, map);
    }
}