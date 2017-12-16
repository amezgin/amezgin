package ru.job4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The class CreateDatabase.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class CreateDatabase {

    /**
     * The number of the elements.
     */
    private int n;

    /**
     * The connection.
     */
    private Connection conn;

    /**
     * The init.
     */
    public void init() {
        createTableInDB();
        fillDB();
    }

    /**
     * This method creates the database.
     *
     * @param n    number of the elements.
     * @param conn connection.
     */
    public CreateDatabase(int n, Connection conn) {
        this.n = n;
        this.conn = conn;
    }

    /**
     * This method create the table in the database.
     */
    private void createTableInDB() {
        try (Statement st = this.conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS field (id INTEGER PRIMARY KEY, value INTEGER NOT NULL );");
            st.execute("DELETE FROM field");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method filling the table in the database.
     */
    private void fillDB() {
        try (PreparedStatement pst = this.conn.prepareStatement("INSERT INTO field (value) VALUES (?)");) {
            this.conn.setAutoCommit(false);
            for (int i = 1; i <= this.n; i++) {
                pst.setInt(1, i);
                pst.addBatch();
            }
            pst.executeBatch();
            this.conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}