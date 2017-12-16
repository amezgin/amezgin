package ru.job4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class ConnectToDB.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class ConnectToDB {

    /**
     * The URL to connect to the database.
     */
    private String url;

    /**
     * The login to connect to the database.
     */
    private String login;

    /**
     * The password to connect to the database.
     */
    private String password;

    /**
     * The connection.
     */
    private Connection conn;

    /**
     * This method sets the connect to the database.
     *
     * @return connection.
     */
    public Connection connectToDB() {
        try {
            this.conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
    }

    /**
     * This method disconnect the database.
     */
    public void disconnectDB() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * The setter to the URL.
     *
     * @param url url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The setter to the login.
     *
     * @param login login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * The setter to the password.
     *
     * @param password password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}