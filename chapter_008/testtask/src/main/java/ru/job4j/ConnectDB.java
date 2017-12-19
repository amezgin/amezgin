package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * The class ConnectDB.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.12.2017
 */
public class ConnectDB {

    /**
     * This field contains the name of the properties file.
     */
    private static final String PATH_TO_PROPERTIES = "database.properties";

    /**
     * The logger for work with database.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ConnectDB.class);


    /**
     * Connection for the specified database.
     */
    private Connection conn = null;

    /**
     * The properties.
     */
    private Properties prs = new Properties();

    /**
     * This method establishes a connection to the database.
     */
    public Connection connectToDB() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)) {
            prs.load(in);
            this.conn = DriverManager.getConnection(prs.getProperty("url"),
                    prs.getProperty("user"), prs.getProperty("password"));
            LOG.info("The connect to the database is established!");

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return this.conn;
    }

    /**
     * This method closes the connection with the database.
     */
    public void disconnectDB() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info("The connect to the database is cut off!");
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * This method create te table in current database.
     */
    public void createTable() {
        try (Statement st = this.conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS offer (id SERIAL PRIMARY KEY, link TEXT UNIQUE NOT NULL, "
                    + "description TEXT NOT NULL, create_date TIMESTAMP NOT NULL);");
            LOG.info("The table offer is create!");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}