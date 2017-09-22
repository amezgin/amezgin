package ru.job4j.parallelsearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class ParallerSearch.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 07.08.2017
 */
public class ParallerSearch {

    /**
     * This field stores the search results.
     */
    private List<String> result = new CopyOnWriteArrayList<>();

    /**
     * This field stores the list of files with a certain extension.
     */
    private List<String> listFiles = new CopyOnWriteArrayList<>();

    /**
     * This method searches for the specified text in the file system.
     *
     * @param root the path to the folder where it is necessary to search.
     * @param text the specified text;
     * @param exts the extensions.
     * @throws InterruptedException InterruptedException.
     */
    public void parallerSearch(String root, String text, List<String> exts) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start thread1 file search!");
                    searchFiles(root, exts);
                    System.out.println("Stop thread1 file search!");
                } catch (ValidateException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start thread2 file with text search!");
                    boolean stop = false;
                    while (!stop) {
                        searchFileWithText(text);
                        if (!thread1.isAlive() && listFiles.size() == 0) {
                            stop = true;
                        }
                    }
                    System.out.println("Stop thread2 file with text search!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start thread3 file with text search!");
                    boolean stop = false;
                    while (!stop) {
                        searchFileWithText(text);
                        if (!thread1.isAlive() && listFiles.size() == 0) {
                            stop = true;
                        }
                    }
                    System.out.println("Stop thread3 file with text search!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
    }

    /**
     * This method returns the search results.
     *
     * @return result.
     */
    public List<String> getResult() {
        return this.result;
    }

    /**
     * This method searches files with the specified extensions in the file system.
     *
     * @param root the path to the folder where it is necessary to search.
     * @param exts the extensions.
     * @throws ValidateException ValidateException.
     */
    private void searchFiles(String root, List<String> exts) throws ValidateException {
        File rootDir = new File(root);
        if (!rootDir.isDirectory()) {
            throw new ValidateException(String.format("%s is not directory or directory not exists!", root));
        }
        File[] list = rootDir.listFiles();
        if (list == null) {
            return;
        }
        for (File member : list) {
            if (member.isDirectory()) {
                searchFiles(member.getAbsolutePath(), exts);
            } else {
                for (String fileName : exts) {
                    if (member.getName().endsWith(fileName)) {
                        this.listFiles.add(member.getAbsolutePath());
                    }
                }
            }
        }
    }

    /**
     * This method searches files with the specified text.
     *
     * @param text the specified text.
     * @throws IOException IOException.
     */
    private void searchFileWithText(String text) throws IOException {
        String path = this.listFiles.get(0);
        this.listFiles.remove(0);

        if (path != null) {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            String string = new String(bytes);
            if (string.contains(text)) {
                this.result.add(path);
            }
        }
    }
}