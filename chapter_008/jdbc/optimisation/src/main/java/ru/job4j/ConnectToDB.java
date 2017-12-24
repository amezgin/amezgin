package ru.job4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The class ConnectToDB.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class ConnectToDB {

    /**
     * The number of the elements.
     */
    private final int countElement = 1_000_000;

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
    public Connection getConnectToDB() {
        try {
            this.conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
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

    /**
     * This method create the table in the database.
     */
    public void createTableInDB() {
        try (Statement st = this.conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS field (id INTEGER PRIMARY KEY, value INTEGER NOT NULL );");
            st.execute("DELETE FROM field");
            fillDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method filling the table in the database.
     */
    private void fillDB() {
        try (PreparedStatement pst = this.conn.prepareStatement("INSERT INTO field (value) VALUES (?)");) {
            this.conn.setAutoCommit(false);
            for (int i = 1; i <= this.countElement; i++) {
                pst.setInt(1, i);
                pst.addBatch();
            }
            pst.executeBatch();
        } catch (SQLException e) {
            try {
                this.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                this.conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}