package ru.job4j.dao;

import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class UserDaoImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class UserDaoImpl implements GenericDao<User> {

    /**
     * Create.
     */
    private static final String CREATE_USER = "INSERT INTO users (login, password, role_id) VALUES (?, ?, ?)";

    /**
     * Update.
     */
    private static final String UPDATE_USER = "UPDATE users SET login = ?, password = ?, role_id = ? WHERE id = ?";

    /**
     * Delete.
     */
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";

    /**
     * Get by id.
     */
    private static final String GET_USER_BY_ID = "SELECT u.id, u.login, u.password, u.role_id, r.name FROM users AS u "
            + "INNER JOIN roles AS r ON u.role_id=r.id WHERE u.id=?";

    /**
     * Get by login.
     */
    private static final String GET_USER_BY_LOGIN = "SELECT u.id, u.login, u.password, u.role_id, r.name FROM users AS u "
            + "INNER JOIN roles AS r ON u.role_id=r.id WHERE login = ?";

    /**
     * Get all.
     */
    private static final String GET_ALL_USERS = "SELECT * FROM users";

    /**
     * The connect.
     */
    private Connection connect;

    /**
     * The constructor.
     *
     * @param conn connect.
     */
    public UserDaoImpl(Connection conn) {
        this.connect = conn;
    }

    /**
     * This method create the new entity.
     *
     * @param user created object.
     * @return the id of created entity.
     */
    @Override
    public Integer create(User user) {
        Integer userId = -1;
        try (PreparedStatement ps = this.connect.prepareStatement(CREATE_USER, new String[]{"id"})) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                userId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    /**
     * This method update the entity.
     *
     * @param id   param to the find entity.
     * @param user updated entity.
     */
    @Override
    public void update(Integer id, User user) {
        try (PreparedStatement ps = this.connect.prepareStatement(UPDATE_USER)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().getId());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method delete the entity.
     *
     * @param id deleted id entity.
     */
    @Override
    public void delete(Integer id) {
        try (PreparedStatement ps = this.connect.prepareStatement(DELETE_USER)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method search the entity.
     *
     * @param id the id searched entity.
     * @return searched entity.
     */
    @Override
    public User getById(Integer id) {
        User result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new User(rs.getString("login"), rs.getString("password"),
                            new Role(rs.getString("name")), null, null);
                    result.setId(id);
                    result.getRole().setId(rs.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method search the entity.
     *
     * @param login the login searched entity.
     * @return searched entity.
     */
    public User getByLogin(String login) {
        User result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_BY_LOGIN)) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new User(rs.getString("login"), rs.getString("password"),
                            new Role(rs.getString("name")), null, null);
                    result.setId(rs.getInt("id"));
                    result.getRole().setId(rs.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method return the all entity.
     *
     * @return all entity.
     */
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ALL_USERS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User(rs.getString("login"), rs.getString("password"),
                            null, null, null);
                    user.setId(rs.getInt("id"));
                    result.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method checks that user and password is correct.
     *
     * @return true if user and password is correct otherwise false.
     */
    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        for (User user : this.getAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}