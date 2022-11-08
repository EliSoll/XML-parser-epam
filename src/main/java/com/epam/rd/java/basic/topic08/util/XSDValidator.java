package com.epam.rd.java.basic.topic08.util;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XSDValidator {

    private static final String XSD_FILE_NAME = "input.xsd";
    private static final String XML_FILE_NAME = "input.xml";
    private String xsd;

    public XSDValidator(String xsd) {
        this.xsd = xsd;
    }

    public static void main(String[] args) {
        try {
            new XSDValidator(XSD_FILE_NAME).validate(XML_FILE_NAME);
            System.out.println("The '" + XML_FILE_NAME + "' is valid against the '" + XSD_FILE_NAME + '\'');
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void validate(String xml) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // Compliant
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
        Schema schema = factory.newSchema(new File(xsd));
        Validator validator = schema.newValidator();

        validator.setErrorHandler(new ErrorHandler() {

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.err.println("Warn: " + exception.getMessage());

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.err.println("Not valid: " + exception.getMessage());
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                // NOTHING
            }
        });

        validator.validate(new StreamSource(new File(xml)));
    }
}