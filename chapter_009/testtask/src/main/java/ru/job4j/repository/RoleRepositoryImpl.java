package ru.job4j.repository;

import ru.job4j.dao.UserDaoImpl;
import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * The class RoleRepositoryImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class RoleRepositoryImpl implements RoleRepository {

    /**
     * The role.
     */
    private final Role role;

    /**
     * The connection.
     */
    private final Connection connect;

    /**
     * The constructor.
     *
     * @param conn connection.
     * @param role role.
     */
    public RoleRepositoryImpl(Connection conn, Role role) {
        this.connect = conn;
        this.role = role;
    }

    /**
     * Return thr list all users.
     *
     * @return list all users.
     */
    @Override
    public List<User> getAllUserWithRole() {
        List<User> result = new LinkedList<>();
        int id = role.getId();
        List<User> allUser = new UserDaoImpl(this.connect).getAll();
        for (User user : allUser) {
            if (id == user.getRole().getId()) {
                result.add(user);
            }
        }
        return result;
    }
}