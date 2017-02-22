package ru.job4j;

import ru.job4j.exception.KeyNotFoundException;
import ru.job4j.exception.MapContainsExtraKayException;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class SimpleGenerator.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.02.2017
 */
public class SimpleGenerator implements Template {

    /**
     * This method replace all templates in a specified string.
     *
     * @param template    is a specified string.
     * @param mapKeyPairs map of keys.
     * @return string with replaced template.
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKayException exception when map contains extra keys.
     */
    @Override
    public String generate(String template, Map<String, String> mapKeyPairs) throws KeyNotFoundException,
            MapContainsExtraKayException {
        int countExtraKeyInTemplate = 0;
        for (Map.Entry map : mapKeyPairs.entrySet()) {
            String regEx = String.format("\\$\\{%s\\}", map.getKey());
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(template);
            if (matcher.find()) {
                template = template.replaceAll(regEx, map.getValue().toString());
            } else {
                countExtraKeyInTemplate++;
            }
        }
        String regExAnyKey = "\\$\\{.*\\}";
        Pattern pattern = Pattern.compile(regExAnyKey);
        Matcher matcher = pattern.matcher(template);
        if (matcher.find()) {
            throw new KeyNotFoundException("This map does not contain the necessary keys!");
        } else if (countExtraKeyInTemplate != 0) {
            throw new MapContainsExtraKayException("This map contains extra keys!");
        }
        return template;
    }
}
