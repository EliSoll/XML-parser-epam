package com.epam.rd.java.basic.topic08.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.epam.rd.java.basic.topic08.ua.nure.Flowers;
import org.w3c.dom.Document;

import com.epam.rd.java.basic.topic08.constants.Constants;




/**
 * Util class for document transformation XML.
 *
 *
 */
public class Transformer {

    /**
     * Transforms XML document to JAXB objects (XML file --> JAXB objects).
     *
     * @param xmlFileName
     *            Input XML document.
     * @return JAXB object.
     */
    public static Flowers jaxbTransform(String xmlFileName) throws JAXBException, TransformerException {
        JAXBResult result = new JAXBResult(
                JAXBContext.newInstance(Constants.JAXB__PACKAGE));

        // set up transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer();

        // run transformation
        t.transform(new StreamSource(xmlFileName), result);

        // obtain the unmarshalled content tree
        return (Flowers) result.getResult();
    }

    /**
     * Transforms XML document to HTML document (XML file --> HTML file).
     *
     * @param xmlFileName
     *            Input XML document.
     * @param xslFileName
     *            Input XSL document.
     * @param htmlFileName
     *            Output HTML file.
     *
     */
    public static void saveToHTML(String xmlFileName, String xslFileName,
                                  String htmlFileName) throws JAXBException, TransformerException {
        StreamResult result = new StreamResult(new File(htmlFileName));

        // set up transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer(
                new StreamSource(new File(xslFileName)));
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        // run transformation
        t.transform(new StreamSource(xmlFileName), result);
    }

    /**
     * Save DOM model in XML file (DOM --> XML file).
     *
     * @param document
     *            DOM document to be saved.
     * @param xmlFileName
     *            Output XML file.
     */
    public static void saveToXML(Document document, String xmlFileName)
            throws TransformerException {
        StreamResult result = new StreamResult(new File(xmlFileName));

        // set up transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        // run transformation
        t.transform(new DOMSource(document), result);
    }

    public static void main(String[] args) throws Exception {

        Flowers test = Transformer.jaxbTransform(Constants.VALID_XML_FILE);
        System.out.println(test);

        Transformer.saveToHTML(Constants.VALID_XML_FILE, "Test.xsl", "Test.html");
    }
}
