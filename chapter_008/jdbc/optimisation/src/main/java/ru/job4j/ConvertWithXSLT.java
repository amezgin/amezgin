package ru.job4j;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * The class ConvertWithXSLT.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 16.12.2017
 */
public class ConvertWithXSLT {

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
}