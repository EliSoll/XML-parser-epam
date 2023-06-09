package com.epam.rd.java.basic.topic08.controller;


import java.io.IOException;
import java.math.BigInteger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.epam.rd.java.basic.topic08.constants.Constants;
import com.epam.rd.java.basic.topic08.constants.XML;
import com.epam.rd.java.basic.topic08.ua.nure.Flowers;
import com.epam.rd.java.basic.topic08.util.Util;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 * Controller for SAX parser.
 */
public class SAXController extends DefaultHandler {

	private String xmlFileName;

	public SAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document.
	 *
	 * @param validate
	 *            If true validate XML document against its XML schema. With
	 *            this parameter it is possible make parser validating.
	 */
	public void parse(boolean validate) throws ParserConfigurationException,
			SAXException, IOException {

		// get sax parser factory
		// this way you obtain SAX parser factory based on internal implementation
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following invocation:
		// 		SAXParserFactory.newInstance()
		// returns factory based on the external XERCES library
		// (see xercesImpl.jar/META-INF/services/javax.xml.parsers.SAXParserFactory)
		//
		// If there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// 		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParserFactory factory = SAXParserFactory.newInstance(
				Constants.CLASS__SAX_PARSER_FACTORY_INTERNAL,
				this.getClass().getClassLoader());

		factory.setNamespaceAware(true);
		if (validate) {
			factory.setFeature(Constants.FEATURE__TURN_VALIDATION_ON, true);
			factory.setFeature(Constants.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);
		}

		SAXParser parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);
	}

	// ///////////////////////////////////////////////////////////
	// ERROR HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		throw e; // <-- if XML document not valid just throw exception
	};

	// ///////////////////////////////////////////////////////////
	// CONTENT HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	private String currentElement; // <-- current element name holder

	private Flowers flowers; // <-- main container
	private Flowers.Flower flower;
	private Flowers.Flower.VisualParameters visualParameters;
	private Flowers.Flower.VisualParameters.AveLenFlower aveLenFlower;
	private Flowers.Flower.GrowingTips growingTips;
	private Flowers.Flower.GrowingTips.Tempreture tempreture;
	private Flowers.Flower.GrowingTips.Lighting lighting;
	private Flowers.Flower.GrowingTips.Watering watering;

	public Flowers getFlowers() {
		return flowers;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
							 Attributes attributes) throws SAXException {

		currentElement = localName;

		// WARNING!!!
		// here and below we use '==' operation to compare two INTERNED STRINGS
		if (currentElement == XML.FLOWERS.value()) {
			flowers = new Flowers();
			return;
		}

		if (currentElement == XML.FLOWER.value()) {
			flower = new Flowers.Flower();
			return;
		}

		if (currentElement == XML.VISUALPARAMS.value()) {
			visualParameters = new Flowers.Flower.VisualParameters();
			return;
		}

		if (currentElement == XML.AVELENFLOWER.value()) {
			aveLenFlower = new Flowers.Flower.VisualParameters.AveLenFlower();
			if (attributes.getLength() > 0) {
				aveLenFlower.setMeasure(attributes.getValue(uri, XML.MEASURE.value()));
			}
			return;
		}

		if (currentElement == XML.GROWINGTIPS.value()) {
			growingTips = new Flowers.Flower.GrowingTips();
			return;
		}

		if (currentElement == XML.TEMPRETURE.value()) {
			tempreture = new Flowers.Flower.GrowingTips.Tempreture();
			if (attributes.getLength() > 0) {
				tempreture.setMeasure(attributes.getValue(uri, XML.MEASURE.value()));
			}
			return;
		}

		if (currentElement == XML.LIGHTING.value()) {
			lighting = new Flowers.Flower.GrowingTips.Lighting();
			if (attributes.getLength() > 0) {
				lighting.setLightRequiring(attributes.getValue(XML.LIGHTREQUIRING.value()));
				//lighting.setLightRequiring(attributes.getValue(uri, XML.LIGHTREQUIRING.value()));
			}
			return;
		}

		if (currentElement == XML.WATERING.value()) {
			watering = new Flowers.Flower.GrowingTips.Watering();
			if (attributes.getLength() > 0) {
				watering.setMeasure(attributes.getValue(uri, XML.WATERING.value()));
			}
			return;
		}

		/*if (currentElement == XML.NAME.value()) {
			answer = new Answer();
			if (attributes.getLength() > 0) {
				answer.setCorrect(Boolean.parseBoolean(attributes.getValue(uri,
						XML.CORRECT.value())));
			}
		}*/
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		String elementText = new String(ch, start, length).trim();

		if (elementText.isEmpty()) // <-- return if content is empty
			return;

		if (currentElement == XML.NAME.value()) {
			flower.setName(elementText);
			return;
		}

		if (currentElement == XML.SOIL.value()) {
			flower.setSoil(elementText);
			return;
		}

		if (currentElement == XML.ORIGIN.value()) {
			flower.setOrigin(elementText);
			return;
		}

		if (currentElement == XML.STEMCOLOR.value()) {
			visualParameters.setStemColour(elementText);
			return;
		}

		if (currentElement == XML.LEAFCOLOR.value()) {
			visualParameters.setLeafColour(elementText);
			return;
		}

		if (currentElement == XML.AVELENFLOWER.value()) {
			aveLenFlower.setValue(Util.valueOfBigInt(elementText));
			return;
		}

		if (currentElement == XML.TEMPRETURE.value()) {
			tempreture.setValue(Util.valueOfBigInt(elementText));
			return;
		}

		if (currentElement == XML.WATERING.value()) {
			watering.setValue(Util.valueOfBigInt(elementText));
			return;
		}

		if (currentElement == XML.MULTIPLYING.value()) {
			flower.setMultiplying(elementText);
			return;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName == XML.FLOWER.value()) {
			flowers.getFlower().add(flower);
			return;
		}

		if (localName == XML.AVELENFLOWER.value()) {
			visualParameters.setAveLenFlower(aveLenFlower);
			return;
		}

		if (localName == XML.VISUALPARAMS.value()) {
			flower.setVisualParameters(visualParameters);
			return;
		}

		if (localName == XML.TEMPRETURE.value()) {
			growingTips.setTempreture(tempreture);
			return;
		}

		if (localName == XML.LIGHTING.value()) {
			growingTips.setLighting(lighting);
			return;
		}

		if (localName == XML.WATERING.value()) {
			growingTips.setWatering(watering);
			return;
		}

		if (localName == XML.GROWINGTIPS.value()) {
			flower.setGrowingTips(growingTips);
			return;
		}
	}

	/*
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		// try to parse valid XML file (success)
		SAXController saxContr = new SAXController(Constants.VALID_XML_FILE);
		saxContr.parse(true); // <-- do parse with validation on (success)
		Test test = saxContr.getTest(); // <-- obtain container

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + test);
		System.out.println("====================================");

		// now try to parse NOT valid XML (failed)
		saxContr = new SAXController(Constants.INVALID_XML_FILE);
		try {
			saxContr.parse(true); // <-- do parse with validation on (failed)
		} catch (Exception ex) {
			System.err.println("====================================");
			System.err.println("Validation is failed:\n" + ex.getMessage());
			System.err
					.println("Try to print test object:" + saxContr.getTest());
			System.err.println("====================================");
		}

		// and now try to parse NOT valid XML with validation off (success)
		saxContr.parse(false); // <-- do parse with validation off (success)

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + saxContr.getTest());
		System.out.println("====================================");
	}
    */
}