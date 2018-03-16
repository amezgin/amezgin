package ru.job4j.dao;

import ru.job4j.model.MusicType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class MusicTypeDaoImpl.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class MusicTypeDaoImpl implements GenericDao<MusicType> {

    /**
     * Create.
     */
    private static final String CREATE_MUSIC_TYPE = "INSERT INTO music_type (musictype) VALUES (?)";

    /**
     * Update.
     */
    private static final String UPDATE_MUSIC_TYPE = "UPDATE music_type SET musictype = ? WHERE id = ?";

    /**
     * Delete.
     */
    private static final String DELETE_MUSIC_TYPE = "DELETE FROM music_type WHERE id = ?";

    /**
     * Get by id.
     */
    private static final String GET_MUSIC_TYPE_BY_ID = "SELECT * FROM music_type WHERE id = ?";

    /**
     * Get all.
     */
    private static final String GET_ALL_MUSIC_TYPE = "SELECT * FROM music_type";

    /**
     * The connect.
     */
    private final Connection connect;

    /**
     * The constructor.
     *
     * @param connect connect.
     */
    public MusicTypeDaoImpl(Connection connect) {
        this.connect = connect;
    }

    /**
     * This method create the new entity.
     *
     * @param musicType created object.
     * @return the id of created entity.
     */
    @Override
    public Integer create(MusicType musicType) {
        Integer musicTypeId = -1;
        try (PreparedStatement ps = this.connect.prepareStatement(CREATE_MUSIC_TYPE, new String[]{"id"})) {
            ps.setString(1, musicType.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                musicTypeId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTypeId;
    }

    /**
     * This method update the entity.
     *
     * @param musicTypeId param to the find entity.
     * @param musicType   updated entity.
     */
    @Override
    public void update(Integer musicTypeId, MusicType musicType) {
        try (PreparedStatement ps = this.connect.prepareStatement(UPDATE_MUSIC_TYPE)) {
            ps.setString(1, musicType.getName());
            ps.setInt(2, musicTypeId);
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
        try (PreparedStatement ps = this.connect.prepareStatement(DELETE_MUSIC_TYPE)) {
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
    public MusicType getById(Integer id) {
        MusicType result = null;
        try (PreparedStatement ps = this.connect.prepareStatement(GET_MUSIC_TYPE_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new MusicType(rs.getString("musictype"));
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
    public List<MusicType> getAll() {
        List<MusicType> result = new ArrayList<>();
        try (PreparedStatement ps = this.connect.prepareStatement(GET_ALL_MUSIC_TYPE)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MusicType musicType = new MusicType(rs.getString("musictype"));
                    musicType.setId(rs.getInt("id"));
                    result.add(musicType);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}