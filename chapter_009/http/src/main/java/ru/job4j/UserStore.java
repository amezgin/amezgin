package ru.job4j;

import ru.job4j.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * The class UsersStore.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 20.12.2017
 */
public enum UserStore {

    /**
     * The instance.
     */
    INSTANCE;

    /**
     * This field contains the name of the properties file.
     */
    private static final String PATH_TO_PROPERTIES = "database.properties";

    /**
     * The connection for the database.
     */
    private Connection conn = null;

    /**
     * The properties.
     */
    private Properties prs = new Properties();

    /**
     * The constructor.
     */
    UserStore() {
        loadProperties();
        connectToDB();
        createTable();
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
     * This method adds the user into the database.
     *
     * @param user user.
     */
    public void addUser(User user) {
        try (PreparedStatement pst = this.conn.prepareStatement("INSERT INTO users (name, login, email, createDate)"
                + "VALUES (?, ?, ?, ?)")) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getEmail());
            pst.setTimestamp(4, user.getCreateDate());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method edit the user in the database.
     *
     * @param login login.
     * @param user  user.
     */
    public void editUser(String login, User user) {
        try (PreparedStatement pst = this.conn.prepareStatement("UPDATE users SET name = ?, login = ?, "
                + "email = ?, createDate = ? WHERE login = ?")) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getEmail());
            pst.setTimestamp(4, user.getCreateDate());
            pst.setString(5, login);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method deletes the user from the database.
     *
     * @param login login.
     */
    public void removeUser(String login) {
        try (PreparedStatement pst = this.conn.prepareStatement("DELETE FROM users WHERE login = ?")) {
            pst.setString(1, login);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gets the user from the database.
     *
     * @param login login.
     */
    public User getUser(String login) {
        User user = null;
        try (PreparedStatement pst = this.conn.prepareStatement("SELECT * FROM users WHERE login = ?")) {
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString("name"), rs.getString("login"),
                        rs.getString("email"), rs.getTimestamp("createDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * This method load the properties.
     */
    private void loadProperties() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)) {
            this.prs.load(in);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * This method establishes a connection to the database.
     */
    private void connectToDB() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(prs.getProperty("url"),
                    prs.getProperty("user"), prs.getProperty("password"));
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method create table in the database if she is not exist.
     */
    private void createTable() {
        try (Statement st = this.conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS users (user_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, "
                    + "login VARCHAR(100) UNIQUE NOT NULL, email VARCHAR(100) NOT NULL, createDate TIMESTAMP NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}