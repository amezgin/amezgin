package ru.job4j.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The interface DaoFactory.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public interface DaoFactory {

    /**
     * This method returns the connection to database.
     *
     * @return connection.
     */
    Connection getConnection() throws SQLException;

    /**
     * This method close pool connection.
     */
    void closeConnectionsPool();
}