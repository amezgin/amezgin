package ru.job4j.dao;

import ru.job4j.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class RoleDaoImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class RoleDaoImpl implements GenericDao<Role> {

    /**
     * Create.
     */
    private static final String CREATE_ROLE = "INSERT INTO roles (name) VALUES (?)";

    /**
     * Update.
     */
    private static final String UPDATE_ROLE = "UPDATE roles SET name = ? WHERE id = ?";

    /**
     * Delete.
     */
    private static final String DELETE_ROLE = "DELETE FROM roles WHERE id = ?";

    /**
     * Get by id.
     */
    private static final String GET_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";

    /**
     * Get all.
     */
    private static final String GET_ALL_ROLE = "SELECT * FROM roles";

    /**
     * The connect.
     */
    private final Connection connect;

    /**
     * The constructor.
     *
     * @param connect connect.
     */
    public RoleDaoImpl(Connection connect) {
        this.connect = connect;
    }

    /**
     * This method create the new entity.
     *
     * @param role created object.
     * @return the id of created entity.
     */
    @Override
    public Integer create(Role role) {
        Integer roleId = -1;
        try (PreparedStatement ps = this.connect.prepareStatement(CREATE_ROLE, new String[]{"id"})) {
            ps.setInt(1, role.getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                roleId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleId;
    }

    /**
     * This method update the entity.
     *
     * @param id   param to the find entity.
     * @param role updated entity.
     */
    @Override
    public void update(Integer id, Role role) {
        try (PreparedStatement ps = this.connect.prepareStatement(UPDATE_ROLE)) {
            ps.setString(1, role.getName());
            ps.setInt(2, id);
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
        try (PreparedStatement ps = this.connect.prepareStatement(DELETE_ROLE)) {
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
    public Role getById(Integer id) {
        Role result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ROLE_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Role(rs.getString("name"));
                    result.setId(id);
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
    public List<Role> getAll() {
        List<Role> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ALL_ROLE)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Role role = new Role(rs.getString("name"));
                    role.setId(rs.getInt("id"));
                    result.add(role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}