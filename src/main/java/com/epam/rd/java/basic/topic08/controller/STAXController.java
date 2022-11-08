package com.epam.rd.java.basic.topic08.controller;


import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import com.epam.rd.java.basic.topic08.constants.XML;
import com.epam.rd.java.basic.topic08.ua.nure.Flowers;
import com.epam.rd.java.basic.topic08.util.Util;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 * Controller for StAX parser.
 */
public class STAXController extends DefaultHandler {
	private String xmlFileName;

	private String currentElement; // <-- current element name holder

	private Flowers flowers; // <-- main container
	private Flowers.Flower flower;
	private Flowers.Flower.VisualParameters visualParameters;
	private Flowers.Flower.VisualParameters.AveLenFlower aveLenFlower;
	private Flowers.Flower.GrowingTips growingTips;
	private Flowers.Flower.GrowingTips.Tempreture tempreture;
	private Flowers.Flower.GrowingTips.Lighting lighting;
	private Flowers.Flower.GrowingTips.Watering watering;

	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	/**
	 * Parses XML document with StAX API. There is no validation during the
	 * parsing.
	 */
	public void parse() throws ParserConfigurationException, SAXException,
			IOException, XMLStreamException {

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

		XMLEventReader reader = factory.createXMLEventReader(
				new StreamSource(xmlFileName));

		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();

			// skip any empty content
			if (event.isCharacters() && event.asCharacters().isWhiteSpace())
				continue;

			// handler for start tags
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElement = startElement.getName().getLocalPart();

				// WARNING!!!
				// here and below we use '==' operation to compare two INTERNED STRINGS
				if (currentElement == XML.FLOWERS.value()) {
					flowers = new Flowers();
					continue;
				}

				if (currentElement == XML.FLOWER.value()) {
					flower = new Flowers.Flower();
					continue;
				}

				if (currentElement == XML.VISUALPARAMS.value()) {
					visualParameters = new Flowers.Flower.VisualParameters();
					continue;
				}

				if (currentElement == XML.AVELENFLOWER.value()) {
					aveLenFlower = new Flowers.Flower.VisualParameters.AveLenFlower();
					Attribute attr = startElement.getAttributeByName(new QName(XML.MEASURE.value()));
					if (attr != null) {
						aveLenFlower.setMeasure(attr.getValue());
					}
					continue;
				}

				if (currentElement == XML.GROWINGTIPS.value()) {
					growingTips = new Flowers.Flower.GrowingTips();
					continue;
				}

				if (currentElement == XML.TEMPRETURE.value()) {
					tempreture = new Flowers.Flower.GrowingTips.Tempreture();
					Attribute attr = startElement.getAttributeByName(new QName(XML.MEASURE.value()));
					if (attr != null) {
						tempreture.setMeasure(attr.getValue());
					}
					continue;
				}

				if (currentElement == XML.LIGHTING.value()) {
					lighting = new Flowers.Flower.GrowingTips.Lighting();
					Attribute attr = startElement.getAttributeByName(new QName(XML.LIGHTREQUIRING.value()));
					if (attr != null) {
						lighting.setLightRequiring(attr.getValue());
						//lighting.setLightRequiring(attributes.getValue(uri, XML.LIGHTREQUIRING.value()));
					}
					continue;
				}

				if (currentElement == XML.WATERING.value()) {
					watering = new Flowers.Flower.GrowingTips.Watering();
					Attribute attr = startElement.getAttributeByName(new QName(XML.WATERING.value()));
					if (attr != null) {
						watering.setMeasure(attr.getValue());
					}
					continue;
				}
			}

			// handler for contents
			if (event.isCharacters()) {
				Characters characters = event.asCharacters();

				if (currentElement == XML.NAME.value()) {
					flower.setName(characters.getData());
					continue;
				}

				if (currentElement == XML.SOIL.value()) {
					flower.setSoil(characters.getData());
					continue;
				}

				if (currentElement == XML.ORIGIN.value()) {
					flower.setOrigin(characters.getData());
					continue;
				}

				if (currentElement == XML.STEMCOLOR.value()) {
					visualParameters.setStemColour(characters.getData());
					continue;
				}

				if (currentElement == XML.LEAFCOLOR.value()) {
					visualParameters.setLeafColour(characters.getData());
					continue;
				}

				if (currentElement == XML.AVELENFLOWER.value()) {
					aveLenFlower.setValue(Util.valueOfBigInt(characters.getData()));
					continue;
				}

				if (currentElement == XML.TEMPRETURE.value()) {
					tempreture.setValue(Util.valueOfBigInt(characters.getData()));
					continue;
				}

				if (currentElement == XML.WATERING.value()) {
					watering.setValue(Util.valueOfBigInt(characters.getData()));
					continue;
				}

				if (currentElement == XML.MULTIPLYING.value()) {
					flower.setMultiplying(characters.getData());
					continue;
				}

			}

			// handler for end tags
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (localName == XML.FLOWER.value()) {
					flowers.getFlower().add(flower);
					continue;
				}

				if (localName == XML.AVELENFLOWER.value()) {
					visualParameters.setAveLenFlower(aveLenFlower);
					continue;
				}

				if (localName == XML.VISUALPARAMS.value()) {
					flower.setVisualParameters(visualParameters);
					continue;
				}

				if (localName == XML.TEMPRETURE.value()) {
					growingTips.setTempreture(tempreture);
					continue;
				}

				if (localName == XML.LIGHTING.value()) {
					growingTips.setLighting(lighting);
					continue;
				}

				if (localName == XML.WATERING.value()) {
					growingTips.setWatering(watering);
					continue;
				}

				if (localName == XML.GROWINGTIPS.value()) {
					flower.setGrowingTips(growingTips);
					continue;
				}

			}
		}
		reader.close();
	}

	/*
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XMLStreamException {

		// try to parse (valid) XML file (success)
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		staxContr.parse(); // <-- do parse (success)

		Test test = staxContr.getTest(); // <-- obtain container

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + test);
		System.out.println("====================================");
	}
    */
}