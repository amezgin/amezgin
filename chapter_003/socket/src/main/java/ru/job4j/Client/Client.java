package ru.job4j.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * The class Client.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public class Client {

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
     * The sign of the output of the program.
     */
    private boolean exit;

    /**
     * Host.
     */
    private String host;

    /**
     * Port.
     */
    private int port;

    /**
     * This method initialize the client.
     *
     * @throws IOException exception
     */
    public void init() throws IOException {
        loadProperties();
        try (Socket socket = new Socket(getHost(), getPort())) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                try (Scanner sc = new Scanner(System.in)) {
                    System.out.println(dis.readUTF());
                    String str;
                    while (!isExit()) {
                        System.out.println(dis.readUTF());
                        System.out.println(dis.readUTF());
                        str = sc.nextLine();
                        switch (str) {
                            case "0": {
                                showListDirAndFiles(str);
                                break;
                            }
                            case "1": {
                                goInDir(str, sc);
                                break;
                            }
                            case "2": {
                                uploadFile(str, sc);
                                break;
                            }
                            case "3": {
                                downloadFile(str, sc);
                                break;
                            }
                            case "4": {
                                exit(str, sc);
                                break;
                            }
                            case "": {
                                dos.writeUTF("Empty line");
                                break;
                            }
                            default: {
                                dos.writeUTF(str);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                dis.close();
                dos.close();
            }
        }
    }

    /**
     * This method return server host.
     *
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * This method setup server host.
     *
     * @param host host
     */
    public void setHost(String host) {
        this.host = host;
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
     * This method load settings from file with properties.
     *
     * @throws IOException IOException
     */
    public void loadProperties() throws IOException {
        File settingFile = new File(this.getClass().getResource("/app.properties").getPath());
        Properties properties = new Properties();
        properties.load(new FileReader(settingFile));
        setPort(Integer.valueOf(properties.getProperty("port")));
        setHost(properties.getProperty("ip_address"));
        setCurrentDirectory(new File(properties.getProperty("rootDirClient")));
    }

    /**
     * This method resolve to get a list of files and directories in current directory.
     *
     * @param str input stream from server
     * @throws IOException IOException
     */
    private void showListDirAndFiles(String str) throws IOException {
        dos.writeUTF(str);
        System.out.println(dis.readUTF());
    }

    /**
     * With then method user can go on any directory.
     *
     * @param str     input stream from server
     * @param scanner input from keyboard
     * @throws IOException IOException
     */
    private void goInDir(String str, Scanner scanner) throws IOException {
        dos.writeUTF(str);
        System.out.println(dis.readUTF());
        System.out.println(dis.readUTF());
        dos.writeUTF(scanner.nextLine());
        System.out.println(dis.readUTF());
    }

    /**
     * With then method user can upload file on server.
     *
     * @param str     input stream from server
     * @param scanner input from keyboard
     * @throws IOException IOException
     */
    private void uploadFile(String str, Scanner scanner) throws IOException {
        dos.writeUTF(str);
        System.out.println(dis.readUTF());
        String fileName = scanner.nextLine();
        if (fileName.equals("")) {
            dos.writeUTF("");
            System.out.println(dis.readUTF());
        } else {
            File file = new File(getCurrentDirectory(), fileName);
            if (file.exists()) {
                dos.writeUTF(file.getName());
                dos.writeUTF(String.valueOf(file.length()));
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buf = new byte[32 * 1024];
                    int count;
                    System.out.println("Started sending a file to the server!%s");
                    while ((count = fis.read(buf)) != -1) {
                        dos.write(buf, 0, count);
                    }
                    System.out.println(dis.readUTF());
                }
            } else {
                System.out.println(String.format("The file \"%s\" does not exist!", fileName));
                dos.writeUTF("Cancel");
                System.out.println(dis.readUTF());
            }
        }
    }

    /**
     * With then method user can download file from server.
     *
     * @param str     input stream from server
     * @param scanner input from keyboard
     * @throws IOException IOException
     */
    private void downloadFile(String str, Scanner scanner) throws IOException {
        dos.writeUTF(str);
        System.out.println(dis.readUTF());
        String fileName = scanner.nextLine();
        if (fileName.equals("")) {
            dos.writeUTF("");
            System.out.println(dis.readUTF());
        } else {
            dos.writeUTF(fileName);
            String serverAnswer = dis.readUTF();
            if (serverAnswer.equals("File exist.")) {
                File file = new File(getCurrentDirectory(), fileName);
                long fileLength = Integer.valueOf(dis.readUTF());
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    byte[] buf = new byte[32 * 1024];
                    int count;
                    System.out.println(dis.readUTF());
                    while (fileLength > 0) {
                        count = dis.read(buf);
                        fos.write(buf, 0, count);
                        fileLength -= count;
                    }
                    System.out.println("Download completed successfully!");
                }
            } else {
                System.out.println(serverAnswer);
            }
        }
    }

    /**
     * With then method user can exit from server.
     *
     * @param str     input stream from server
     * @param scanner input from keyboard
     * @throws IOException IOException
     */
    private void exit(String str, Scanner scanner) throws IOException {
        dos.writeUTF(str);
        System.out.println(dis.readUTF());
        String exit = scanner.nextLine();
        if (exit.equalsIgnoreCase("y")) {
            setExit(true);
        }
        dos.writeUTF(exit);
    }

    /**
     * This method start the client.
     *
     * @param args args
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.init();
    }
}