package ru.job4j;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for sort.
 */
public class SortFileTest {

    /**
     * Test method init().
     *
     * @throws IOException IOException.
     */
    @Test
    public void whenGetUnsortedFileThenReturnSortedFile() throws IOException {
        String sep = System.getProperty("line.separator");
        Sort3G sortFile = new Sort3G();
        File testFile = new File(getClass().getResource("/testFile.txt").getPath());
        File resultFile = new File("result.txt");
        sortFile.sort(testFile, resultFile);
        try (Scanner sc = new Scanner(resultFile)) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(String.format("%s%s", sc.nextLine(), sep));
            }
            String result = sb.toString();
            String checked = String.format("sdfsd%sdfhfgh%ssdfgdf%sdfhfgjgh%sdfhjghklj%ssfgfgjghkj%s",
                    sep, sep, sep, sep, sep, sep);
            assertThat(result, is(checked));
        }
    }


}