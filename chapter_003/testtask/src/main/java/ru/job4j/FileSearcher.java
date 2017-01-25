package ru.job4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class FileSearcher.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.01.2017
 */
public class FileSearcher {

    /**
     * This field describes an array of arguments to pass when starting the program.
     */
    private String[] args;

    /**
     * This is construct.
     *
     * @param args array of arguments to pass when starting the program
     */
    public FileSearcher(String[] args) {
        this.args = args;
    }

    /**
     * This method start the file searcher.
     *
     * @throws ValidateException ValidateException
     * @throws IOException       IOException
     */
    public void init() throws ValidateException, IOException {
        showDescrArgum();
        validateArgs(args);
        File startDirectory = new File(args[1]);
        try (FileWriter fileWriter = new FileWriter(new File(args[6]))) {
            if (!startDirectory.isDirectory()) {
                throw new ValidateException(String.format("%s is not directory or directory not exists!", args[1]));
            }
            search(startDirectory, fileWriter);
        }
    }

    /**
     * This method displays the description and the order of the arguments when the program is run.
     */
    private void showDescrArgum() {
        System.out.println("java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        System.out.println("<-d c:/> - the key is to set the initial search directory.");
        System.out.println("<-n *.txt> - name of a file mask or regular expression to search. "
                + "If the file name contains spaces, the file name must be specified using the format <file name>.");
        System.out.println("<-m> or <-f> - or <-r> to search by file name, mask, or regular expression.");
        System.out.println("<-o log.txt> - the result to write to the file.");

    }

    /**
     * This method validates the input arguments.
     *
     * @param args start arguments
     * @throws ValidateException ValidateException
     */
    private void validateArgs(String[] args) throws ValidateException {
        if (args.length != 7) {
            throw new ValidateException("The keys to run the program is invalid.");
        }
        if (!args[0].equalsIgnoreCase("-d")) {
            throw new ValidateException("The first key must be equals \"-d\".");
        }
        if (!args[2].equalsIgnoreCase("-n")) {
            throw new ValidateException("The second key must be equals \"-n\".");
        }
        if (!args[4].equalsIgnoreCase("-m") && !args[4].equalsIgnoreCase("-f") && !args[4].equalsIgnoreCase("-r")) {
            throw new ValidateException("The fourth key must be equals \"-m\", \"-f\" or \"-r\".");
        }
        if (!args[5].equalsIgnoreCase("-o")) {
            throw new ValidateException("The five key must be equals \"-o\".");
        }
    }

    /**
     * This method performs the file search.
     * If the search process encounters a directory, it recursively calls the method itself.
     *
     * @param currentDir current directory
     * @param fw         it is the thread that writes the search results to a file
     * @throws IOException IOException
     */
    private void search(File currentDir, FileWriter fw) throws IOException {
        File[] list = currentDir.listFiles();
        if (list == null) {
            return;
        }
        for (File member : list) {
            if (member.isDirectory()) {
                search(member, fw);
            } else {
                if (accept(member.getName())) {
                    fw.write(String.format("%s%s", member.getAbsolutePath(), System.getProperty("line.separator")));
                }
            }
        }
    }

    /**
     * This method validates the file name and regular expression/mask/file name.
     *
     * @param fileName check the file name
     * @return true if the file name matches otherwise false
     */
    private boolean accept(String fileName) {
        boolean result = false;
        if (args[4].equalsIgnoreCase("-m")) {
            result = new SearchByMask(fileName, args[3]).checkName();
        }
        if (args[4].equalsIgnoreCase("-f")) {
            result = new SearchByName(fileName, args[3]).checkName();

        }
        if (args[4].equalsIgnoreCase("-r")) {
            result = new SearchByRegExp(fileName, args[3]).checkName();
        }
        return result;
    }
}