package ru.job4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The class Start.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class Start {

    /**
     * Private field type of Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * The private field description the program.
     */
    private String descriptionProgram = "This program inserts into table TEST (SQLite database) N records. "
            + "The application then requests the data from the TEST and generates a valid XML document. "
            + "The document is saved to the file system as \"1.xml\" in the program folder. "
            + "Through XSLT, the application converts the content \"1.xml\" and is stored in the file system "
            + "as \"2.xml\" in the program folder. The application parses \"2.xml\" and outputs the arithmetic sum of "
            + "the values of all attributes field in the console.";

    /**
     * The class constructor.
     */
    private Start() {
    }

    /**
     * This method displays a menu and description of the program.
     */
    private void init() {
        System.out.println(descriptionProgram);
        ConnectToDB connectToDB = new ConnectToDB();
        connectToDB.setUrl(ask("Enter the URL for connect to DB."));
        connectToDB.setLogin(ask("Enter the login for connect to DB."));
        connectToDB.setPassword(ask("Enter the password for connect to DB."));
        long start = System.currentTimeMillis();
        try (Connection connect = connectToDB.getConnectToDB()) {
            connectToDB.createTableInDB();
            WorkWithXML createXML = new WorkWithXML(connect);
            createXML.createXML();
            createXML.convert();
            System.out.println(String.format("The sum of elements in XML file is %d.", createXML.getSum()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();
        System.out.println(String.format("The execution time of the program was the %d seconds.", (finish - start) / 1000));
    }

    /**
     * This method asks the user answer.
     *
     * @param question is question.
     * @return question.
     */
    private String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    /**
     * The main.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        new Start().init();
    }
}