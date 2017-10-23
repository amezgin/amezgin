package ru.job4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The class SoftReferenceCache.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 18.10.2017.
 */
public class SoftReferenceCache {

    /**
     * The cache.
     */
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    /**
     * The path to the source folder.
     */
    private final String path;

    /**
     * The Constructor.
     *
     * @param path path to the source folder.
     */
    public SoftReferenceCache(String path) {
        this.path = path;
    }

    /**
     * This method returns the text from file.
     *
     * @param fileName the file name.
     * @return text.
     */
    public String getText(String fileName) {
        String result = new String();
        if (this.cache.containsKey(fileName)) {
            result = this.cache.get(fileName).get();
        } else {
            String pathToFile = String.format("%s/%s", this.path, fileName);
            StringBuilder tmp = new StringBuilder();
            try (Scanner scanner = new Scanner(new File(pathToFile))) {
                while (scanner.hasNextLine()) {
                    tmp.append(String.format("%s%s", scanner.nextLine(), System.getProperty("line.separator")));
                }
                result = tmp.toString();
                this.cache.put(fileName, new SoftReference<>(result));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}