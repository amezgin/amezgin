package ru.job4j.dao;

import java.util.List;

/**
 * The interface GenericDao.
 *
 * @param <T> the type of objects.
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public interface GenericDao<T> {

    /**
     * This method create the new entity.
     *
     * @param object created object.
     * @return the id of created entity.
     */
    Integer create(T object);

    /**
     * This method update the entity.
     *
     * @param id     param to the find entity.
     * @param object updated entity.
     */
    void update(Integer id, T object);

    /**
     * This method delete the entity.
     *
     * @param objectId deleted id entity.
     */
    void delete(Integer objectId);

    /**
     * This method search the entity.
     *
     * @param id the id searched entity.
     * @return searched entity.
     */
    T getById(Integer id);

    /**
     * This method return the all entity.
     *
     * @return all entity.
     */
    List<T> getAll();
}