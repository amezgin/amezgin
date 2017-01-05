package ru.job4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * The class DropAbuses.
 * This class implements a method which remove all words in array "abuse" from the stream.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 03.01.2017
 */
public class DropAbuses {

    /**
     * This method remove all words in array "abuse" from the stream.
     *
     * @param in    character input stream.
     * @param out   character output stream.
     * @param abuse array of strings.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"))) {
            while (br.ready()) {
                String line = br.readLine();
                for (String word : abuse) {
                    line = line.replaceAll(word, "");
                }
                bw.write(line);
            }
        } catch (IOException e) {
            System.out.println("IOException!");
        } catch (NullPointerException e) {
            throw e;
        }
    }
}
