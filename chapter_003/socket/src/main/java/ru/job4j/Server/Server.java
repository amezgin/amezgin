package ru.job4j.Server;

import ru.job4j.Action.BaseAction;
import ru.job4j.Action.Input;
import ru.job4j.Action.UserAction;
import ru.job4j.Action.ValidateInput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * The class Server.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public class Server {

    /**
     * DataInputStream.
     */
    private DataInputStream dis;

    /**
     * DataOutputStream.
     */
    private DataOutputStream dos;

    /**
     * This file description current directory.
     */
    private File currentDirectory;

    /**
     * Server port.
     */
    private int port;

    /**
     * Server root dir.
     */
    private String rootDir;

    /**
     * Private field description the arrays length for arrays of user action.
     */
    private final int arrayslength = 5;

    /**
     * It is counter for user action.
     */
    private int position = 0;

    /**
     * This field description array when saved user action.
     */
    private UserAction[] userActions = new UserAction[arrayslength];

    /**
     * The sign of the output of the program.
     */
    private boolean exit;

    /**
     * Private field Input description interfaces of input.
     */
    private Input input;

    /**
     * This field description system separator.
     */
    private String separator = System.getProperty("line.separator");

    /**
     * The class constructor.
     *
     * @param input input
     */
    public Server(Input input) {
        this.input = input;
    }

    /**
     * This method initialize the server.
     *
     * @throws IOException exception
     */
    public void init() throws IOException {
        fillAction();
        loadProperties();
        setCurrentDirectory(new File(getRootDir()));
        try (ServerSocket serverSocket = new ServerSocket(getPort())) {
            try (Socket incoming = serverSocket.accept()) {
                try {
                    dis = new DataInputStream(incoming.getInputStream());
                    dos = new DataOutputStream(incoming.getOutputStream());
                    dos.writeUTF(String.format("The connection is established!%s", separator));
                    do {
                        this.show(dos);
                        this.select(input.ask("Select the action: ", this.getRangeActions(), dis, dos));
                    }
                    while (!isExit());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    dis.close();
                    dos.close();
                }
            }
        }
    }

    /**
     * This method fill arrays of action.
     */
    public void fillAction() {
        this.userActions[position++] = new ShowListFilesAndDirectories("Show list files and directories in current directory.");
        this.userActions[position++] = new MoveToDirectory("Go in the selected directory.");
        this.userActions[position++] = new UploadFile("Upload a file to the server.");
        this.userActions[position++] = new DownloadFile("Download a file from server.");
        this.userActions[position++] = new Exit("Exit.");
    }

    /**
     * This method return directory when locate the user.
     *
     * @return directory when locate the user
     */
    public File getCurrentDirectory() {
        return currentDirectory;
    }

    /**
     * This method setup new current directory.
     *
     * @param directory the destination directory
     */
    public void setCurrentDirectory(File directory) {
        this.currentDirectory = directory;
    }

    /**
     * This method return server root dir.
     *
     * @return root dir
     */
    public String getRootDir() {
        return rootDir;
    }

    /**
     * This method setup server root dir.
     *
     * @param rootDir rootDir
     */
    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * This method return server port.
     *
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * This method setup server port.
     *
     * @param port port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * This method return sign exit.
     *
     * @return exit
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * This method setup sign exit.
     *
     * @param exit exit
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * This method selected the action.
     *
     * @param key key
     * @throws IOException IOException
     */
    public void select(int key) throws IOException {
        this.userActions[key].execute(dis, dos);
    }

    /**
     * This method show the menu of program.
     *
     * @param dos dos
     * @throws IOException IOException
     */
    public void show(DataOutputStream dos) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (UserAction action : userActions) {
            if (action != null) {
                sb.append(String.format("%s%s", action.info(), separator));
            }
        }
        dos.writeUTF(String.format("%s%s", sb.toString(), separator));
    }

    /**
     * This method return a number of ranges users action.
     *
     * @return int[] range
     */
    public int[] getRangeActions() {
        int[] range = new int[arrayslength];

        for (int i = 0; i < arrayslength; i++) {
            range[i] = userActions[i].key();
        }
        return range;
    }

    /**
     * This method load settings from file with properties.
     *
     * @throws IOException IOException
     */
    public void loadProperties() throws IOException {
        File settingFile = new File(this.getClass().getResource("/app.properties").getPath());
        Properties properties = new Properties();
        properties.load(new FileReader(settingFile));
        setPort(Integer.valueOf(properties.getProperty("port")));
        setRootDir(properties.getProperty("rootDirServer"));
    }

    /**
     * The inner class to get a list of files and directories in current directory.
     */
    private class ShowListFilesAndDirectories extends BaseAction {

        /**
         * The Constructor.
         *
         * @param name applies name
         */
        ShowListFilesAndDirectories(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * This method performs the main action.
         *
         * @param dis DataInputStream
         * @param dos DataOutputStream
         */
        @Override
        public void execute(DataInputStream dis, DataOutputStream dos) throws IOException {
            StringBuilder sb = new StringBuilder();
            for (String dir : getCurrentDirectory().list()) {
                sb.append(String.format("%s%s", dir, separator));
            }
            dos.writeUTF(String.format("%s%s", sb.toString(), separator));
        }
    }

    /**
     * The inner class to move on directory.
     */
    private class MoveToDirectory extends BaseAction {

        /**
         * The Constructor.
         *
         * @param name applies name
         */
        MoveToDirectory(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * This method performs the main action.
         *
         * @param dis DataInputStream
         * @param dos DataOutputStream
         */
        @Override
        public void execute(DataInputStream dis, DataOutputStream dos) throws IOException {
            dos.writeUTF(String.format("You locate in %s%s", getCurrentDirectory(), separator));
            dos.writeUTF(String.format("To navigate in the selected directory, enter \"cd <directory name>\" "
                    + "or type \"cd ..\" to move to a higher level.%s", separator));
            loadProperties();
            String rootDir = getRootDir();
            File file = getCurrentDirectory();
            String request = new Scanner(dis.readUTF()).nextLine();
            try {
                String cd = request.substring(0, 3).trim();
                String dir = request.substring(2).trim();
                if (!cd.equalsIgnoreCase("cd")) {
                    dos.writeUTF(String.format("%s is not command!%s", cd, separator));
                }
                if (cd.equalsIgnoreCase("cd") && dir.equalsIgnoreCase("..")) {
                    if (!getCurrentDirectory().getPath().equals(rootDir)) {
                        setCurrentDirectory(new File(file.getParent()));
                        dos.writeUTF(String.format("You locate in %s%s", getCurrentDirectory(), separator));
                    } else {
                        dos.writeUTF(String.format("You locate in root dir and don't move UP!%s", separator));
                    }
                } else if (cd.equalsIgnoreCase("cd") && !dir.equalsIgnoreCase("..")) {
                    int count = 0;
                    for (String name : file.list()) {
                        if (name.equalsIgnoreCase(dir) && new File(getCurrentDirectory() + "\\" + dir).isDirectory()) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        setCurrentDirectory(new File(getCurrentDirectory() + "\\" + dir));
                        dos.writeUTF(String.format("You locate in %s%s", getCurrentDirectory(), separator));
                    } else {
                        dos.writeUTF(String.format("\"%s\" is not directory or directory does not exist!%s", dir, separator));
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                dos.writeUTF(String.format("The command is incorrect!%s", separator));
            }
        }
    }

    /**
     * The inner class for upload file to the server.
     */
    private class UploadFile extends BaseAction {

        /**
         * The Constructor.
         *
         * @param name applies name
         */
        UploadFile(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * This method performs the main action.
         *
         * @param dis DataInputStream
         * @param dos DataOutputStream
         */
        @Override
        public void execute(DataInputStream dis, DataOutputStream dos) throws IOException {
            dos.writeUTF(String.format("To upload file go to the desired directory and enter <file_name>.%s", separator));
            String fileName = dis.readUTF();
            File file = new File(getCurrentDirectory() + "\\" + fileName);
            if (fileName.equals("Cancel")) {
                dos.writeUTF(String.format("Try again!%s", separator));
            } else if (fileName.equals("")) {
                dos.writeUTF(String.format("File name mast be 1 or more symbols!%s", separator));
            } else {
                long fileLength = Integer.valueOf(dis.readUTF());
                byte[] buf = new byte[32 * 1024];
                int count;
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    while (fileLength > 0) {
                        count = dis.read(buf);
                        fos.write(buf, 0, count);
                        fileLength -= count;
                    }
                }
                dos.writeUTF(String.format("Upload completed successfully!%s", separator));
            }
        }
    }

    /**
     * The inner class for download file from server.
     */
    private class DownloadFile extends BaseAction {

        /**
         * The Constructor.
         *
         * @param name applies name
         */
        DownloadFile(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * This method performs the main action.
         *
         * @param dis DataInputStream
         * @param dos DataOutputStream
         */
        @Override
        public void execute(DataInputStream dis, DataOutputStream dos) throws IOException {
            dos.writeUTF(String.format("To download file go to the desired directory and enter <file_name>.%s", separator));
            String fileName = dis.readUTF();
            if (fileName.equals("")) {
                dos.writeUTF(String.format("File name mast be 1 or more symbols!%s", separator));
            } else {
                File file = new File(getCurrentDirectory() + "\\" + fileName);
                if (file.exists()) {
                    dos.writeUTF("File exist.");
                    dos.writeUTF(String.valueOf(file.length()));
                    byte[] buf = new byte[32 * 1024];
                    int count;
                    dos.writeUTF(String.format("Started sending a file from the server!%s", separator));
                    try (FileInputStream fis = new FileInputStream(file)) {
                        while ((count = fis.read(buf)) != -1) {
                            dos.write(buf, 0, count);
                        }
                    }
                } else {
                    dos.writeUTF(String.format("The file does not exist!%s", separator));
                }
            }
        }
    }

    /**
     * The inner class for exit from server.
     */
    private class Exit extends BaseAction {

        /**
         * The Constructor.
         *
         * @param name applies name
         */
        Exit(String name) {
            super(name);
        }

        /**
         * This method asks for the key on which the user performs an action.
         *
         * @return key
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * This method performs the main action.
         *
         * @param dis DataInputStream
         * @param dos DataOutputStream
         */
        @Override
        public void execute(DataInputStream dis, DataOutputStream dos) throws IOException {
            dos.writeUTF(String.format("Do you want exit? Press 'y' to exit: %s", separator));
            try (Scanner sc = new Scanner(dis.readUTF())) {
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    setExit(true);
                }
            }
        }
    }

    /**
     * This method start the server.
     *
     * @param args args
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server(new ValidateInput());
        server.init();
    }
}