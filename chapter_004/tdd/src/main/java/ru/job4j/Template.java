package ru.job4j;

import ru.job4j.exception.KeyNotFoundException;
import ru.job4j.exception.MapContainsExtraKeyException;

import java.util.Map;

/**
 * The interface Template.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public interface Template {

    /**
     * This method replace all templates in a specified string.
     *
     * @param template    is a specified string.
     * @param mapKeyPairs map of keys.
     * @return string with replaced template.
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKeyException exception when map contains extra keys.
     */
    String generate(String template, Map<String, String> mapKeyPairs) throws KeyNotFoundException, MapContainsExtraKeyException;
}
