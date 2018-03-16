package ru.job4j.dao;

import ru.job4j.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class AddressDaoImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class AddressDaoImpl implements GenericDao<Address> {

    /**
     * The create address.
     */
    private static final String CREATE_ADDRESS = "INSERT INTO address (postcode, city, street, home, user_id) VALUES (?, ?, ?, ?, ?)";

    /**
     * The update address.
     */
    private static final String UPDATE_ADDRESS = "UPDATE address SET postcode = ?, city = ?, street = ?, home = ? WHERE id = ?";

    /**
     * The delete address.
     */
    private static final String DELETE_ADDRESS = "DELETE FROM address WHERE id = ?";

    /**
     * The get address by user id.
     */
    private static final String GET_ADDRESS_BY_USER_ID = "SELECT * FROM address WHERE user_id = ?";

    /**
     * The get all address.
     */
    private static final String GET_ALL_ADDRESS = "SELECT * FROM address";

    /**
     * The connection.
     */
    private final Connection connect;

    /**
     * The constructor.
     *
     * @param connect connect.
     */
    public AddressDaoImpl(Connection connect) {
        this.connect = connect;
    }

    /**
     * This method create the new address.
     *
     * @param address created address.
     * @return the id of created address.
     */
    @Override
    public Integer create(Address address) {
        Integer addressId = -1;
        try (PreparedStatement ps = this.connect.prepareStatement(CREATE_ADDRESS, new String[]{"id"})) {
            ps.setInt(1, Integer.parseInt(address.getPostcode()));
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setString(4, address.getHome());
            ps.setInt(5, address.getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                addressId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressId;
    }

    /**
     * This method update the address.
     *
     * @param id      param to the find address.
     * @param address updated address.
     */
    @Override
    public void update(Integer id, Address address) {
        try (PreparedStatement ps = this.connect.prepareStatement(UPDATE_ADDRESS)) {
            ps.setString(1, address.getPostcode());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setString(4, address.getHome());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method delete the address.
     *
     * @param id deleted id address.
     */
    @Override
    public void delete(Integer id) {
        try (PreparedStatement ps = this.connect.prepareStatement(DELETE_ADDRESS)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method search the address.
     *
     * @param id the id searched address.
     * @return searched address.
     */
    @Override
    public Address getById(Integer id) {
        Address result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ADDRESS_BY_USER_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Address(rs.getString("postcode"), rs.getString("city"),
                            rs.getString("street"), rs.getString("home"), rs.getInt("user_id"));
                    result.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method return the all address.
     *
     * @return all address.
     */
    @Override
    public List<Address> getAll() {
        List<Address> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ALL_ADDRESS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Address address = new Address(rs.getString("postcode"), rs.getString("city"),
                            rs.getString("street"), rs.getString("home"), rs.getInt("user_id"));
                    address.setId(rs.getInt("id"));
                    result.add(address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}