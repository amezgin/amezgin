package ru.job4j.repository;

import ru.job4j.dao.AddressDaoImpl;
import ru.job4j.dao.MusicTypeDaoImpl;
import ru.job4j.dao.UserDaoImpl;
import ru.job4j.model.Address;
import ru.job4j.model.MusicType;
import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class UserRepositoryImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class UserRepositoryImpl implements UserRepository {

    /**
     * Get user role.
     */
    private static final String GET_USER_ROLE = "SELECT * FROM users WHERE role_id=?";

    /**
     * Get user address.
     */
    private static final String GET_USER_ADDRES = "SELECT * FROM address WHERE user_id=?";

    /**
     * Get user music type.
     */
    private static final String GET_USER_MUSICTYPE = "SELECT m.id, m.musictype FROM music_type AS m "
            + "INNER JOIN user_musictype AS t ON m.id=t.musictype_id WHERE user_id=?";

    /**
     * Get all user dependencies.
     */
    private static final String GET_ALL_USER_WITH_ALL_DEPENDENCES = "SELECT u.id, u.login, u.password, r.id, r.name, "
            + "a.postcode, a.city, a.street, a.home FROM users AS u "
            + "LEFT JOIN roles AS r ON u.role_id=r.id "
            + "LEFT JOIN address AS a ON u.id=a.user_id";

    /**
     * Get user by address.
     */
    private static final String GET_USER_BY_ADDRESS = "SELECT u.id, u.login, u.password FROM users AS u "
            + "INNER JOIN address AS a ON u.id=a.user_id WHERE a.postcode=? AND a.city=? AND a.street=? AND a.home=?";

    /**
     * Get users by role.
     */
    private static final String GET_USER_BY_ROLE = "SELECT u.id, u.login, u.password FROM users AS u "
            + "INNER JOIN roles AS r ON u.role_id=r.id WHERE r.name=?";

    /**
     * Get users by music type.
     */
    private static final String GET_USER_BY_MUSICTYPE = "SELECT u.id, u.login, u.password FROM users AS u "
            + "INNER JOIN user_musictype AS t ON u.id=t.user_id "
            + "INNER JOIN music_type AS m ON t.musictype_id=m.id WHERE m.name=?";

    /**
     * Delete from table address by user id.
     */
    private static final String DELETE_FROM_ADDRESS_BY_USER_ID = "DELETE FROM address WHERE user_id=?";

    /**
     * Delete from table user_musictype by user id.
     */
    private static final String DELETE_FROM_USER_MUSICTYPE = "DELETE FROM user_musictype WHERE user_id=?";

    /**
     * Create.
     */
    private static final String CREATE_USER_MUSICTYPE = "INSERT INTO user_musictype (user_id, musictype_id) VALUES (?, ?)";

    /**
     * The connection.
     */
    private final Connection connect;

    /**
     * The constructor.
     *
     * @param connect connection.
     */
    public UserRepositoryImpl(Connection connect) {
        this.connect = connect;
    }

    /**
     * Add.
     *
     * @param user user.
     */
    @Override
    public void add(User user) {
        if (user.getId() == null || user.getId() == 0) {
            Integer userId = new UserDaoImpl(this.connect).create(user);
            Address address = user.getAddress();
            address.setUserId(userId);
            new AddressDaoImpl(this.connect).create(address);
            createUserMusictype(CREATE_USER_MUSICTYPE, user, userId);
        } else {
            Integer userId = user.getId();
            new UserDaoImpl(this.connect).update(userId, user);
            if (user.getAddress() != null) {
                deleteUserEntity(DELETE_FROM_ADDRESS_BY_USER_ID, userId);
                new AddressDaoImpl(this.connect).create(user.getAddress());
            }
            if (user.getMusicTypeList() != null) {
                deleteUserEntity(DELETE_FROM_USER_MUSICTYPE, userId);
                createUserMusictype(CREATE_USER_MUSICTYPE, user, userId);
            }
        }
    }

    /**
     * Get users with all dependencies.
     *
     * @return list users.
     */
    @Override
    public List<User> getAllUserWithAllDependencies() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ALL_USER_WITH_ALL_DEPENDENCES)) {
            User user = null;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("login"), rs.getString("password"),
                            new Role(rs.getString("name")), new Address(rs.getString("postcode"),
                            rs.getString("city"), rs.getString("street"),
                            rs.getString("home"), rs.getInt("id")), null);
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
     * Get user role.
     *
     * @param user user.
     * @return role.
     */
    @Override
    public Role getUserRole(User user) {
        Role result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_ROLE)) {
            ps.setInt(1, user.getRole().getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Role(rs.getString("name"));
                    result.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get user address.
     *
     * @param user user.
     * @return address.
     */
    @Override
    public Address getUserAddress(User user) {
        Address result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_ADDRES)) {
            ps.setInt(1, user.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Address(rs.getString("postcode"), rs.getString("city"),
                            rs.getString("street"), rs.getString("home"),
                            rs.getInt("user_id"));
                    result.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get user list music.
     *
     * @param user user.
     * @return list music.
     */
    @Override
    public List<MusicType> getUserMusicType(User user) {
        List<MusicType> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_MUSICTYPE)) {
            ps.setInt(1, user.getId());
            MusicType musicType = null;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    musicType = new MusicType(rs.getString("musictype"));
                    musicType.setId(rs.getInt("id"));
                    result.add(musicType);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get user by address.
     *
     * @param address address.
     * @return user.
     */
    @Override
    public User getUserByAddress(Address address) {
        User result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_BY_ADDRESS)) {
            ps.setString(1, address.getPostcode());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setString(4, address.getHome());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new User(rs.getString("login"), rs.getString("password"),
                            null, address, null);
                    result.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get users by role.
     *
     * @param role role.
     * @return list users.
     */
    @Override
    public List<User> getUserByRole(Role role) {
        List<User> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_BY_ROLE)) {
            ps.setString(1, role.getName());
            User user = null;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("login"), rs.getString("password"),
                            role, null, null);
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
     * Get users by music type.
     *
     * @param musicType music type.
     * @return list users.
     */
    @Override
    public List<User> getUserByMusicType(MusicType musicType) {
        List<User> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_USER_BY_MUSICTYPE)) {
            ps.setString(1, musicType.getName());
            User user = null;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("login"), rs.getString("password"),
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
     * This method create the list music.
     *
     * @param sql    query.
     * @param user   user.
     * @param userId user id.
     */
    private void createUserMusictype(String sql, User user, int userId) {
        List<MusicType> list = new MusicTypeDaoImpl(this.connect).getAll();
        for (MusicType type : user.getMusicTypeList()) {
            for (MusicType musicType : list) {
                if (type.getName().equalsIgnoreCase(musicType.getName())) {
                    try (PreparedStatement ps = this.connect.prepareStatement(sql)) {
                        ps.setInt(1, userId);
                        ps.setInt(2, musicType.getId());
                        ps.executeUpdate();
                        break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method delete any entity.
     *
     * @param sql    query.
     * @param userId user id.
     */
    private void deleteUserEntity(String sql, Integer userId) {
        try (PreparedStatement ps = this.connect.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}