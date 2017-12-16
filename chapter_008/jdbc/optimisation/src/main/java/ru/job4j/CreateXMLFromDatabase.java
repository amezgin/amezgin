package ru.job4j;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class CreateXMLFromDatabase.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class CreateXMLFromDatabase {

    /**
     * The connection.
     */
    private Connection conn;

    /**
     * The constructor.
     *
     * @param conn connection.
     */
    public CreateXMLFromDatabase(Connection conn) {
        this.conn = conn;
    }

    /**
     * This method creates the XML file from the database.
     */
    public void createXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = null;
        Element root = null;
        try {
            doc = factory.newDocumentBuilder().newDocument();
            root = doc.createElement("entries");
            doc.appendChild(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element child = null;
        Element elem = null;
        try (PreparedStatement pst =
                     this.conn.prepareStatement("SELECT value FROM field"); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                child = doc.createElement("entry");
                root.appendChild(child);
                elem = doc.createElement("field");
                elem.setTextContent(rs.getString("value"));
                child.appendChild(elem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        File file = null;

        Transformer tr = null;
        try {
            file = new File(PathToFiles.PATH_TO_1_XML_FILE);
            tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.transform(new DOMSource(doc), new StreamResult(file));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}