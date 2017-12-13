package ru.job4j.start;

import ru.job4j.models.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * The class Tracker.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.12.2016
 */
public class Tracker {

    /**
     * This field contains the name of the properties file.
     */
    private static final String PATH_TO_PROPERTIES = "database.properties";

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
    public void connectToDB() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES)) {
            prs.load(in);
            this.conn = DriverManager.getConnection(prs.getProperty("url"),
                    prs.getProperty("user"), prs.getProperty("password"));
            try (Statement st = this.conn.createStatement()) {
                st.execute("CREATE TABLE IF NOT EXISTS items (item_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, "
                        + "description VARCHAR(200) NOT NULL, create_date TIMESTAMP NOT NULL);");
                st.execute("CREATE TABLE IF NOT EXISTS comments (comment_id SERIAL PRIMARY KEY, comment TEXT NOT NULL,"
                        + "item_id INTEGER REFERENCES items(item_id) NOT NULL);");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method closes the connection with the database.
     */
    public void disconnectDB() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This method add new Item in to list of items.
     *
     * @param item is new Item.
     */
    public void addItem(Item item) {
        try (PreparedStatement pst =
                     this.conn.prepareStatement("INSERT INTO items (name, description, create_date) VALUES(?, ?, ?)")) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDescription());
            pst.setTimestamp(3, new Timestamp(item.getDateCreat().toInstant().getEpochSecond()));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method edit  Item in to list of items.
     *
     * @param item is edited Item.
     */
    public void editItem(Item item) {
        try (PreparedStatement pst =
                     this.conn.prepareStatement("UPDATE items SET name = ?, description = ?, create_date = ? WHERE item_id = ?")) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDescription());
            pst.setTimestamp(3, new Timestamp(item.getDateCreat().toInstant().getEpochSecond()));
            pst.setInt(4, Integer.parseInt(item.getId()));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method remove  Item in to list of items.
     *
     * @param id is deleted Item's id.
     */
    public void removeItem(String id) {
        try (PreparedStatement pst =
                     this.conn.prepareStatement("DELETE FROM items WHERE item_id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method return list of items.
     *
     * @return list of items.
     */
    public List<Item> getAllItem() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst =
                     this.conn.prepareStatement("SELECT * FROM items"); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getString("description"));
                item.setDateCreat(new Date(rs.getTimestamp("create_date").getTime()));
                item.setId(rs.getString("item_id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method returns the Item.
     *
     * @param id of Item.
     * @return Item.
     */
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement pst =
                     this.conn.prepareStatement("SELECT * FROM items WHERE item_id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    item = new Item(rs.getString("name"), rs.getString("description"));
                    item.setDateCreat(new Date(rs.getTimestamp("create_date").getTime()));
                    item.setId(rs.getString("item_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * This method returns the Item.
     *
     * @param name of Item.
     * @return Item.
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst =
                     this.conn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            pst.setString(1, name);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(rs.getString("name"), rs.getString("description"));
                    item.setDateCreat(new Date(rs.getTimestamp("create_date").getTime()));
                    item.setId(rs.getString("item_id"));
                    result.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method returns the list of Item.
     *
     * @param descr of Item.
     * @return list of Item.
     */
    public List<Item> findByDescription(String descr) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst =
                     this.conn.prepareStatement(String.format("SELECT * FROM items WHERE description LIKE \'%%%s%%\'", descr));
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getString("description"));
                item.setDateCreat(new Date(rs.getTimestamp("create_date").getTime()));
                item.setId(rs.getString("item_id"));
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * This method add new comment for the Item.
     *
     * @param comment for Item.
     * @param id      is Item's id.
     */
    public void addComment(String id, String comment) {
        try (PreparedStatement pst =
                     this.conn.prepareStatement("INSERT INTO comments (comment, item_id) VALUES(?,?)")) {
            pst.setString(1, comment);
            pst.setInt(2, Integer.parseInt(id));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}