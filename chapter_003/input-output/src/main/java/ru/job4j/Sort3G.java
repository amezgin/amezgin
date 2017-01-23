package ru.job4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * The class Sort3G.
 * This class sorts the file to the string's length.
 *
 * @author Alexander Mezgin.
 * @version 1.0
 * @since 05.01.2017
 */
public class Sort3G {

    /**
     * This method sorts the file.
     *
     * @param source   original file.
     * @param distance sorted file.
     * @throws IOException - IOException.
     */
    public void sort(File source, File distance) throws IOException {
        if (!source.exists()) {
            System.out.println("The file source not found!");
        } else {
            try (RandomAccessFile rafSource = new RandomAccessFile(source, "r");
                 RandomAccessFile rafDist = new RandomAccessFile(distance, "rw")
            ) {
                int countLine = copySourceToDistanceAndReturnCountLine(rafSource, rafDist);
                int counter = 1;
                while (counter < countLine) {
                    rafDist.seek(0);
                    File firstFile = new File("filePartOne.txt");
                    File secondFile = new File("filePartTwo.txt");
                    RandomAccessFile filePartOne = new RandomAccessFile(firstFile, "rw");
                    RandomAccessFile filePartTwo = new RandomAccessFile(secondFile, "rw");

                    splitFileIntoTwoFiles(rafDist, filePartOne, filePartTwo, counter);
                    rafDist.seek(0);
                    filePartOne.seek(0);
                    filePartTwo.seek(0);
                    sortLinesFromTwoFilesIntoOneFiles(filePartOne, filePartTwo, rafDist, counter);

                    filePartOne.close();
                    firstFile.delete();
                    filePartTwo.close();
                    secondFile.delete();
                    counter *= 2;
                }
            }
        }
    }

    /**
     * This method copy file and return count line in file.
     *
     * @param source   original file.
     * @param distance destination file.
     * @return count line.
     * @throws IOException IOException.
     */
    private int copySourceToDistanceAndReturnCountLine(RandomAccessFile source, RandomAccessFile distance) throws IOException {
        int countLine = 0;
        String line;
        while ((line = source.readLine()) != null) {
            if (!"".equals(line)) {
                distance.writeBytes(String.format("%s%s", line, System.getProperty("line.separator")));
                countLine++;
            }
        }
        return countLine;
    }

    /**
     * This method split file in to two files.
     *
     * @param rafDist     raf
     * @param filePartOne file one.
     * @param filePartTwo file two.
     * @param count       count line.
     * @throws IOException IOException.
     */
    private void splitFileIntoTwoFiles(RandomAccessFile rafDist, RandomAccessFile filePartOne,
                                       RandomAccessFile filePartTwo, int count) throws IOException {
        String line = rafDist.readLine();
        while (line != null) {
            for (int i = 0; i < count && line != null; i++) {
                line = getAndWriteString(line, filePartOne, rafDist);
            }

            for (int i = 0; i < count && line != null; i++) {
                line = getAndWriteString(line, filePartTwo, rafDist);
            }
        }
    }

    /**
     * This method sorted 2 files and merge it in one file.
     *
     * @param rafDist     raf.
     * @param filePartOne file one.
     * @param filePartTwo file two.
     * @param count       count line.
     * @throws IOException IOException.
     */
    private void sortLinesFromTwoFilesIntoOneFiles(RandomAccessFile filePartOne, RandomAccessFile filePartTwo,
                                                   RandomAccessFile rafDist, int count) throws IOException {
        String lineFromFilePartOne = filePartOne.readLine();
        String lineFromFilePartTwo = filePartTwo.readLine();
        while (lineFromFilePartOne != null && lineFromFilePartTwo != null) {
            int i = 0;
            int j = 0;

            while (i < count && j < count && lineFromFilePartOne != null && lineFromFilePartTwo != null) {
                if (lineFromFilePartOne.length() < lineFromFilePartTwo.length()) {
                    if (!"".equals(lineFromFilePartOne)) {
                        rafDist.writeBytes(String.format("%s%s", lineFromFilePartOne, System.getProperty("line.separator")));
                        lineFromFilePartOne = filePartOne.readLine();
                        i++;
                    } else {
                        lineFromFilePartOne = filePartOne.readLine();
                    }
                } else {
                    if (!"".equals(lineFromFilePartTwo)) {
                        rafDist.writeBytes(String.format("%s%s", lineFromFilePartTwo, System.getProperty("line.separator")));
                        lineFromFilePartTwo = filePartTwo.readLine();
                        j++;
                    } else {
                        lineFromFilePartTwo = filePartTwo.readLine();
                    }
                }

            }
            while (i < count && lineFromFilePartOne != null) {
                lineFromFilePartOne = getAndWriteString(lineFromFilePartOne, rafDist, filePartOne);
                i++;
            }
            while (j < count && lineFromFilePartTwo != null) {
                lineFromFilePartTwo = getAndWriteString(lineFromFilePartTwo, rafDist, filePartTwo);
                j++;
            }
        }
        while (lineFromFilePartOne != null) {
            lineFromFilePartOne = getAndWriteString(lineFromFilePartOne, rafDist, filePartOne);
        }
        while (lineFromFilePartTwo != null) {
            lineFromFilePartTwo = getAndWriteString(lineFromFilePartTwo, rafDist, filePartTwo);
        }
    }

    /**
     * This method write and return next line ib file.
     *
     * @param str      str.
     * @param rafWrite raf.
     * @param rafRead  raf.
     * @return string.
     * @throws IOException IOException.
     */
    private String getAndWriteString(String str, RandomAccessFile rafWrite,
                                     RandomAccessFile rafRead) throws IOException {
        if (!"".equals(str)) {
            rafWrite.writeBytes(String.format("%s%s", str, System.getProperty("line.separator")));
            str = rafRead.readLine();
        } else {
            str = rafRead.readLine();
        }
        return str;
    }
}