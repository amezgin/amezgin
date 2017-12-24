package ru.job4j;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class WorkWithXML.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class WorkWithXML {

    /**
     * The connection.
     */
    private Connection conn;

    /**
     * The constructor.
     *
     * @param conn connection.
     */
    public WorkWithXML(Connection conn) {
        this.conn = conn;
    }

    /**
     * This method creates the XML file from the database.
     */
    public void createXML() {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(PathToFiles.PATH_TO_1_XML_FILE));
            writer = new IndentingXMLStreamWriter(writer);
            writer.writeStartDocument("1.0");
            writer.writeStartElement("entries");
            try (PreparedStatement pst =
                         this.conn.prepareStatement("SELECT value FROM field"); ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    writer.writeStartElement("entry");
                    writer.writeStartElement("field");
                    writer.writeCharacters(rs.getString("value"));
                    writer.writeEndElement();
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndDocument();
                writer.flush();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method convert the XML files on the basis of the XSL file.
     */
    public void convert() {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(PathToFiles.PATH_TO_TEMPLATE_XSL_FILE));
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(xslt);
            Source text = new StreamSource(new File(PathToFiles.PATH_TO_1_XML_FILE));
            transformer.transform(text, new StreamResult(new File(PathToFiles.PATH_TO_2_XML_FILE)));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method calculates the sum of elements read from the XML file.
     *
     * @return sum.
     */
    public int getSum() {
        int sum = 0;
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance()
                    .createXMLStreamReader(PathToFiles.PATH_TO_2_XML_FILE, new FileInputStream(PathToFiles.PATH_TO_2_XML_FILE));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    if (xmlr.getLocalName().equals("entry")) {
                        String number = xmlr.getAttributeValue(0);
                        sum += Integer.parseInt(number);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return sum;
    }
}