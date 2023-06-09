package com.epam.rd.java.basic.topic08.constants;

import java.io.File;

/**
 * Holds application constants.
 *
 *
 */
public final class Constants {
    // files

    public static final String VALID_XML_FILE = "input.xml";
    public static final String INVALID_XML_FILE = "invalidXML.xml";
    public static final String XSD_FILE = "input.xsd";
    public static final String XSD_FILE_URI = new File(new File("").getAbsolutePath(), "input.xsd").getAbsolutePath();

    // this package contains jaxb entities. To get entities use the following
    // command: xjc Test.xsd -p PACKAGE_FOR_ENTITIES -d YOUR_SRC_FOLDER
    public static final String JAXB__PACKAGE = "ua.nure";

    // default encoding
    //public static final String ENCODING_DEFAULT = "UTF-8";

    // your own namespace
    public static final String MY_NS__URI = "http://www.nure.ua";
    public static final String MY_NS__PREFIX = "";

    // for schema location
    public static final String SCHEMA_LOCATION__URI =
            "http://www.nure.ua input.xsd";
    public static final String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
    public static final String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
    public static final String XSI_SPACE__PREFIX = "xsi";

    // validation features
    public static final String FEATURE__TURN_VALIDATION_ON =
            "http://xml.org/sax/features/validation";
    public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON =
            "http://apache.org/xml/features/validation/schema";
    public static final String JAXP_SCHEMA_LANGUAGE =
            "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    public static final String JAXP_SCHEMA_SOURCE =
            "http://java.sun.com/xml/jaxp/properties/schemaSource";

    // full qualified names of classes
    public static final String CLASS__XERCES_SAX_PARSER =
            "org.apache.xerces.parsers.SAXParser";
    public static final String CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
    public static final String CLASS__SAX_PARSER_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl";
    public static final String CLASS__XML_SCHEMA_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.validation.XMLSchemaFactory";
}
