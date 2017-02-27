package ru.job4j;

import ru.job4j.exception.KeyNotFoundException;
import ru.job4j.exception.MapContainsExtraKeyException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

    final static Pattern REG_EX = Pattern.compile("\\$\\{(\\w+)\\}");

    /**
     * This method replace all templates in a specified string.
     *
     * @param template    is a specified string.
     * @param mapKeyPairs map of keys.
     * @return string with replaced template.
     * @throws KeyNotFoundException         exception when key not found.
     * @throws MapContainsExtraKeyException exception when map contains extra keys.
     */
    @Override
    public String generate(String template, Map<String, String> mapKeyPairs) throws KeyNotFoundException,
            MapContainsExtraKeyException {
        Matcher matcher = REG_EX.matcher(template);
        Set<String> anyKeyFromRegExSet = new HashSet<>();
        while (matcher.find()) {
            String keyFromGroup = matcher.group(1);
            anyKeyFromRegExSet.add(keyFromGroup);
            if (mapKeyPairs.containsKey(keyFromGroup)) {
                template = matcher.replaceFirst(mapKeyPairs.get(keyFromGroup));
            } else {
                throw new KeyNotFoundException("This map does not contain the necessary keys!");
            }
            matcher.reset(template);
        }
        if (anyKeyFromRegExSet.size() < mapKeyPairs.size()) {
            throw new MapContainsExtraKeyException("This map contains extra keys!");
        }
        return template;
    }
}
