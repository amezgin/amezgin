package ru.job4j;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The class GetSumFromParsingXML.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class GetSumFromParsingXML {

    /**
     * This method calculates the sum of elements read from the XML file.
     *
     * @return sum.
     */
    public int getSum() {
        int sum = 0;
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(PathToFiles.PATH_TO_2_XML_FILE);
            NodeList doc = dom.getElementsByTagName("entry");
            for (int i = 0; i < doc.getLength(); i++) {
                String number = doc.item(i).getAttributes().getNamedItem("field").getNodeValue();
                sum += Integer.parseInt(number);
            }
            return sum;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return sum;
    }
}