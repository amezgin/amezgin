package ru.job4j.models;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
     * The BasicDataSource.
     */
    private BasicDataSource ds = null;

    /**
     * The constructor.
     */
    UserStore() {
        this.ds = new BasicDataSource();
        loadProperties();
        this.ds.setDriverClassName(this.prs.getProperty("driver_class"));
        this.ds.setUrl(this.prs.getProperty("url"));
        this.ds.setUsername(this.prs.getProperty("user"));
        this.ds.setPassword(this.prs.getProperty("password"));
        this.ds.setMinIdle(5);
        this.ds.setMaxIdle(25);
        this.ds.setMaxOpenPreparedStatements(180);
        try {
            this.conn = this.ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTable();
    }

    /**
     * This method adds the user into the database.
     *
     * @param user user.
     */
    public void addUser(User user) {
        try (PreparedStatement pst = this.conn.prepareStatement("INSERT INTO users (name, login, "
                + "password, role_id, email, country, city, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());
            pst.setInt(4, user.getRole().getRoleId());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getCountry());
            pst.setString(7, user.getCity());
            pst.setTimestamp(8, user.getCreateDate());
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
        try (PreparedStatement pst = this.conn.prepareStatement("UPDATE users SET name = ?, login = ?, password = ?, "
                + "role_id = ?, email = ?, country = ?, city = ?, createDate = ? WHERE login = ?")) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());
            pst.setInt(4, user.getRole().getRoleId());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getCountry());
            pst.setString(7, user.getCity());
            pst.setTimestamp(8, user.getCreateDate());
            pst.setString(9, login);
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
        try (PreparedStatement pst = this.conn.prepareStatement("SELECT u.name, u.login, u.password, r.role_id, "
                + "r.role, u.email, u.country, u.city, u.createDate FROM users AS u INNER JOIN roles AS r ON u.role_id = r.role_id "
                + "WHERE login = ?")) {
            pst.setString(1, login);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("name"), rs.getString("login"),
                            rs.getString("password"),
                            new Role(rs.getInt("role_id"), rs.getString("role")),
                            rs.getString("email"), rs.getString("country"),
                            rs.getString("city"), rs.getTimestamp("createDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * This method gets the all user from the database.
     */
    public List<User> getAllUser() {
        List<User> allUsers = new ArrayList<>();
        User user = null;
        try (PreparedStatement pst = this.conn.prepareStatement("SELECT u.name, u.login, u.password, r.role_id, "
                + "r.role, u.email, u.country, u.city, u.createDate FROM users AS u INNER JOIN roles AS r ON u.role_id = r.role_id"
                + " ORDER BY user_id")) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("name"), rs.getString("login"),
                            rs.getString("password"),
                            new Role(rs.getInt("role_id"), rs.getString("role")),
                            rs.getString("email"), rs.getString("country"),
                            rs.getString("city"), rs.getTimestamp("createDate"));
                    allUsers.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    /**
     * This method returns the Role.
     *
     * @param roleId role_id.
     * @return role.
     */
    public Role getRole(int roleId) {
        Role role = null;
        try (PreparedStatement pst = this.conn.prepareStatement("SELECT * FROM roles WHERE role_id = ?")) {
            pst.setInt(1, roleId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    role = new Role(rs.getInt("role_id"), rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    /**
     * This method checks that user and password is correct.
     *
     * @return true if user and password is correct otherwise false.
     */
    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        for (User user : getAllUser()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
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
     * This method create table in the database if she is not exist.
     */
    private void createTable() {
        try (Statement st = this.conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS roles (role_id INTEGER PRIMARY KEY, role VARCHAR(100) NOT NULL )");
            st.execute("CREATE TABLE IF NOT EXISTS users (user_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, "
                    + "login VARCHAR(100) UNIQUE NOT NULL, password VARCHAR(100) NOT NULL, role_id INTEGER NOT NULL REFERENCES roles (role_id), "
                    + "email VARCHAR(100) NOT NULL, country VARCHAR(100) NOT NULL, city VARCHAR(100) NOT NULL, createDate TIMESTAMP NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}