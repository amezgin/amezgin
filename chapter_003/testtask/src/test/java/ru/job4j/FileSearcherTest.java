package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class FileSearcherTest.
 */
public class FileSearcherTest {

    /**
     * Arguments.
     */
    private String startDir;

    /**
     * Log file.
     */
    private File log;

    /**
     * This method is executed to invoke tests.
     *
     * @throws IOException IOException
     */
    @Before
    public void init() throws IOException {
        startDir = "d:/test";
        log = new File("log.txt");
    }

    /**
     * Test for method init() with ValidateException.
     *
     * @throws IOException       IOException
     * @throws ValidateException "The keys to run the program is invalid."
     */
    @Test(expected = ValidateException.class)
    public void whenGetIncorrectCountArgsThenReturnException() throws IOException, ValidateException {
        String[] args = {"-d"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
    }

    /**
     * Test for method init() with ValidateException.
     *
     * @throws IOException       IOException
     * @throws ValidateException "The first key must be equals "-d"."
     */
    @Test(expected = ValidateException.class)
    public void whenGetIncorrectKeyDirThenReturnException() throws IOException, ValidateException {
        String[] args = {"-k", startDir, "-n", "*.txt", "-m", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
    }

    /**
     * Test for method init() with ValidateException.
     *
     * @throws IOException       IOException
     * @throws ValidateException "The second key must be equals "-n"."
     */
    @Test(expected = ValidateException.class)
    public void whenGetIncorrectKeyFileThenReturnException() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-b", "*.txt", "-m", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
    }

    /**
     * Test for method init() with ValidateException.
     *
     * @throws IOException       IOException
     * @throws ValidateException "The fourth key must be equals "-m", "-f" or "-r"."
     */
    @Test(expected = ValidateException.class)
    public void whenGetIncorrectKeyMaskThenReturnException() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-n", "*.txt", "-l", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
    }

    /**
     * Test for method init() with ValidateException.
     *
     * @throws IOException       IOException
     * @throws ValidateException "The five key must be equals "-o"."
     */
    @Test(expected = ValidateException.class)
    public void whenGetIncorrectKeyLogThenReturnException() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-n", "*.txt", "-m", "-r", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
    }

    /**
     * Test for method init() with mask.
     *
     * @throws IOException       IOException
     * @throws ValidateException ValidateException
     */
    @Test
    public void whenGetCorrectKeyFindMaskThenReturnListFiles() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-n", "7??.txt", "-m", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(log)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            String result = sb.toString();
            System.out.println(result);
            assertThat(result, is("d:\\test\\7 7.txt"));
        }
    }

    /**
     * Test for method init() with correct file name.
     *
     * @throws IOException       IOException
     * @throws ValidateException ValidateException
     */
    @Test
    public void whenGetCorrectFileNameThenReturnListFiles() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-n", "7.txt", "-f", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(log)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            String result = sb.toString();
            System.out.println(result);
            assertThat(result, is("d:\\test\\7.txt"));
        }
    }

    /**
     * Test for method init() with regExp.
     *
     * @throws IOException       IOException
     * @throws ValidateException ValidateException
     */
    @Test
    public void whenGetRegExpThenReturnListFiles() throws IOException, ValidateException {
        String[] args = {"-d", startDir, "-n", ".+\\.txt", "-r", "-o", "log.txt"};
        FileSearcher fileSearcher = new FileSearcher(args);
        fileSearcher.init();
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(log)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            String result = sb.toString();
            System.out.println(result);
            assertThat(result, is("d:\\test\\7 7.txtd:\\test\\7.txtd:\\test\\New folder\\asd.txt"));
        }
    }
}