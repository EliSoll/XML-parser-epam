package com.epam.rd.java.basic.topic08.controller;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.epam.rd.java.basic.topic08.constants.Constants;
import com.epam.rd.java.basic.topic08.constants.XML;
import com.epam.rd.java.basic.topic08.ua.nure.Flowers;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.rd.java.basic.topic08.constants.Constants;
import com.epam.rd.java.basic.topic08.constants.XML;
import com.epam.rd.java.basic.topic08.util.Transformer;
import com.epam.rd.java.basic.topic08.util.Util;
import com.epam.rd.java.basic.topic08.util.XSDValidator;



/**
 * Controller for DOM parser.
 */
public class DOMController {
	java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
	private String xmlFileName;
	private String xsdFileName;

	private Flowers flowers; // <-- container

	public DOMController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
		this.xsdFileName = "input.xsd";
		//logger.setLevel(Level.OFF);
	}


	public Flowers getFlowers() {
		return flowers;
	}

	/**
	 * Parses XML document.
	 *
	 * @param validate
	 *            If true validate XML document against its XML schema.
	 */
	public void parse(boolean validate) throws ParserConfigurationException,
			SAXException, IOException {

		// obtain DOM parser

		// get document builder factory
		// this way you obtain DOM analyzer based on internal implementation
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following invocation:
		// 		DocumentBuilderFactory.newInstance()
		// returns factory based on the external XERCES library.
		// (see xercesImpl.jar/META-INF/services/javax.xml.parsers.DocumentBuilderFactory)
		//
		// if there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// 		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(
				Constants.CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL,
				this.getClass().getClassLoader());
		// let sonar be happy
		dbf.setAttribute(javax.xml.XMLConstants.ACCESS_EXTERNAL_DTD, "");
		dbf.setAttribute(javax.xml.XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

		// set properties for Factory
		dbf.setNamespaceAware(true); // <-- XML document has namespace
		if (validate) { // <-- make parser validating
//			dbf.setFeature(Constants.FEATURE__TURN_VALIDATION_ON, true);
//			dbf.setFeature(Constants.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

			XSDValidator validator = new XSDValidator(xsdFileName);
			validator.validate(xmlFileName);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(SAXParseException e) throws SAXException {
				throw e; // <-- throw exception if XML document is NOT valid
			}
		});

		Document document = db.parse(xmlFileName); // <-- parse XML document
		Element root = document.getDocumentElement(); // <-- get root element

		// create container
		flowers = new Flowers();

		NodeList flowerNodes = root
				.getElementsByTagName(XML.FLOWER.value());

		for (int j = 0; j < flowerNodes.getLength(); j++) {
			Flowers.Flower flower = getFlower(flowerNodes.item(j));
			flowers.getFlower().add(flower); // <-- add flower to container
		}
	}

	/**
	 * Extracts flower object from the flower XML node.
	 *
	 * @param qNode
	 *            flower node.
	 * @return Flower object.
	 */
	private Flowers.Flower getFlower(Node qNode) {
		Flowers.Flower flower = new Flowers.Flower();
		Element qElement = (Element) qNode;

//		NodeList childNodes = qNode.getChildNodes();
//		for (int i = 0; i < childNodes.getLength(); i++) {
//			Node n = childNodes.item(i);
//			if (n.getLocalName().equals(XML.QUESTION_TEXT.value())) {
//				question.setQuestionText(n.getTextContent());
//			}
//			if (n.getLocalName().equals(XML.ANSWER.value())) {
//				question.getAnswers().add(getAnswer(n));
//			}
//		}

		Node qtNode = qElement.getElementsByTagName(XML.NAME.value())
				.item(0);
		flower.setName(qtNode.getTextContent());

		qtNode = qElement.getElementsByTagName(XML.SOIL.value())
				.item(0);
		flower.setSoil(qtNode.getTextContent());

		qtNode = qElement.getElementsByTagName(XML.ORIGIN.value())
				.item(0);
		flower.setOrigin(qtNode.getTextContent());


		qtNode = qElement.getElementsByTagName(XML.VISUALPARAMS.value())
				.item(0);
		flower.setVisualParameters(getVisualParameters(qtNode));

		qtNode = qElement.getElementsByTagName(XML.GROWINGTIPS.value())
				.item(0);
		flower.setGrowingTips(getGrowingTips(qtNode));

		qtNode = qElement.getElementsByTagName(XML.MULTIPLYING.value())
				.item(0);
		flower.setMultiplying(qtNode.getTextContent());


		return flower;
	}

	/**
	 * Extracts visualParameters object from the visualParameters XML node.
	 *
	 * @param aNode
	 *            visualParameters node.
	 * @return VisualParameters object.
	 */
	private Flowers.Flower.VisualParameters getVisualParameters(Node aNode) {
		Flowers.Flower.VisualParameters params = new Flowers.Flower.VisualParameters();
		Element aElement = (Element) aNode;

		Node qtNode = aElement.getElementsByTagName(XML.STEMCOLOR.value())
				.item(0);
		params.setStemColour(qtNode.getTextContent());

		qtNode = aElement.getElementsByTagName(XML.LEAFCOLOR.value())
				.item(0);
		params.setLeafColour(qtNode.getTextContent());


		Flowers.Flower.VisualParameters.AveLenFlower aveflower = new Flowers.Flower.VisualParameters.AveLenFlower();
		Node aveNode = aElement.getElementsByTagName(XML.AVELENFLOWER.value())
				.item(0);
		Element aveElement = (Element) aveNode;
		aveflower.setMeasure(aveElement.getAttribute(XML.MEASURE.value()));
		aveflower.setValue(Util.valueOfBigInt(aveElement.getTextContent()));
		params.setAveLenFlower(aveflower);

		return params;
	}

	/**
	 * Extracts GrowingTips object from the growingTips XML node.
	 *
	 * @param aNode
	 *            growingTips node.
	 * @return GrowingTips object.
	 */
	private Flowers.Flower.GrowingTips getGrowingTips(Node aNode) {
		Flowers.Flower.GrowingTips tips = new Flowers.Flower.GrowingTips();
		Element aElement = (Element) aNode;

		Flowers.Flower.GrowingTips.Tempreture temp = new Flowers.Flower.GrowingTips.Tempreture();
		Node qtNode = aElement.getElementsByTagName(XML.TEMPRETURE.value())
				.item(0);
		Element tempElement = (Element) qtNode;
		temp.setMeasure(tempElement.getAttribute(XML.MEASURE.value()));
		temp.setValue(Util.valueOfBigInt(tempElement.getTextContent()));
		tips.setTempreture(temp);

		Flowers.Flower.GrowingTips.Lighting light = new Flowers.Flower.GrowingTips.Lighting();
		qtNode = aElement.getElementsByTagName(XML.LIGHTING.value())
				.item(0);
		tempElement = (Element) qtNode;
		light.setLightRequiring(tempElement.getAttribute(XML.LIGHTREQUIRING.value()));
		tips.setLighting(light);

		Flowers.Flower.GrowingTips.Watering water = new Flowers.Flower.GrowingTips.Watering();
		qtNode = aElement.getElementsByTagName(XML.WATERING.value())
				.item(0);
		tempElement = (Element) qtNode;
		water.setMeasure(tempElement.getAttribute(XML.MEASURE.value()));
		water.setValue(Util.valueOfBigInt(tempElement.getTextContent()));
		tips.setWatering(water);

		return tips;
	}

	/**
	 * Saves Flowers object in XML file (through DOM).
	 *
	 * @param flowers
	 *            Flowers object to be saved.
	 * @param xmlFileName
	 *            Output xml file name.
	 */
	public static void saveXML(Flowers flowers, String xmlFileName)
			throws ParserConfigurationException, TransformerException {

		// obtain DOM parser

		// get document builder factory
		// this way you obtain DOM analyzer based on internal implementaion
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following invocation:
		// 		DocumentBuilderFactory.newInstance()
		// returns factory based on the external XERCES library.
		// (see xercesImpl.jar/META-INF/services/javax.xml.parsers.DocumentBuilderFactory)
		//
		// if there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// 		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(Constants.CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL,
				DOMController.class.getClass().getClassLoader());
		// LET SONAR BE HAPPY
		dbf.setAttribute(javax.xml.XMLConstants.ACCESS_EXTERNAL_DTD, "");
		dbf.setAttribute(javax.xml.XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

		// set properties for Factory
		dbf.setNamespaceAware(true); // <-- XML document has namespace

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// this is the root element
		Element tElement = document.createElement(XML.FLOWERS.value());
		/*Element tElement = document.createElementNS(
				Constants.MY_NS__URI, Constants.MY_NS__PREFIX + ":" + XML.FLOWERS.value());
        */

		// set schema location
		tElement.setAttributeNS(
				XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI,
				Constants.SCHEMA_LOCATION__ATTR_FQN,
				Constants.SCHEMA_LOCATION__URI);
		tElement.setAttribute("xmlns", Constants.MY_NS__URI);



		List<Flowers.Flower> fls = flowers.getFlower();
		for (Flowers.Flower fl : fls) {
			Element flowerElem = document.createElement(XML.FLOWER.value());

			Element name = document.createElement(XML.NAME.value());
			name.setTextContent(fl.getName());
			flowerElem.appendChild(name);

			Element soil = document.createElement(XML.SOIL.value());
			soil.setTextContent(fl.getSoil());
			flowerElem.appendChild(soil);

			Element origin = document.createElement(XML.ORIGIN.value());
			origin.setTextContent(fl.getOrigin());
			flowerElem.appendChild(origin);

			flowerElem.appendChild(GetVisualParamsElement(document, fl));
			flowerElem.appendChild(GetGrowingTipsElement(document, fl));

			Element multi = document.createElement(XML.MULTIPLYING.value());
			multi.setTextContent(fl.getMultiplying());
			flowerElem.appendChild(multi);

			tElement.appendChild(flowerElem);
		}

		document.appendChild(tElement);

		// add questions elements
		/*for (Question question : test.getQuestions()) {
			// add question
			Element qElement = document.createElement(XML.QUESTION.value());
			tElement.appendChild(qElement);

			// add question text
			Element qtElement =
					document.createElement(XML.QUESTION_TEXT.value());
			qtElement.setTextContent(question.getQuestionText());
			qElement.appendChild(qtElement);

			// add answers
			for (Answer answer : question.getAnswers()) {
				Element aElement = document.createElement(XML.ANSWER.value());
				aElement.setTextContent(answer.getContent());

				// set attribute
				if (answer.isCorrect())
					aElement.setAttribute(XML.CORRECT.value(), "true");
				qElement.appendChild(aElement);
			}
		}*/

		/*Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Result output = new StreamResult(new File(xmlFileName));
		Source input = new DOMSource(document);
		transformer.transform(input, output);*/
		Transformer.saveToXML(document, xmlFileName); // DOM -> XML
	}

	/**
	 * Get visualParams to xml document.
	 * @param document xml document.
	 * @param flower Flower object where is data.
	 */
	private static Element GetVisualParamsElement(Document document, Flowers.Flower flower) {
		Element result = document.createElement(XML.VISUALPARAMS.value());

		Element stemColour = document.createElement(XML.STEMCOLOR.value());
		stemColour.setTextContent(flower.getVisualParameters().getStemColour());
		result.appendChild(stemColour);

		Element leafColour = document.createElement(XML.LEAFCOLOR.value());
		leafColour.setTextContent(flower.getVisualParameters().getLeafColour());
		result.appendChild(leafColour);

		Element ave = document.createElement(XML.AVELENFLOWER.value());
		ave.setAttribute(XML.MEASURE.value(), flower.getVisualParameters().getAveLenFlower().getMeasure());
		ave.setTextContent(flower.getVisualParameters().getAveLenFlower().getValue().toString());
		result.appendChild(ave);

		return result;
	}

	/**
	 * Get growingTips to xml document.
	 * @param document xml document.
	 * @param flower Flower object where is data.
	 */
	private static Element GetGrowingTipsElement(Document document, Flowers.Flower flower) {
		Element result = document.createElement(XML.GROWINGTIPS.value());

		Element temp = document.createElement(XML.TEMPRETURE.value());
		temp.setAttribute(XML.MEASURE.value(), flower.getGrowingTips().getTempreture().getMeasure());
		temp.setTextContent(flower.getGrowingTips().getTempreture().getValue().toString());
		result.appendChild(temp);

		Element light = document.createElement(XML.LIGHTING.value());
		light.setAttribute(XML.LIGHTREQUIRING.value(), flower.getGrowingTips().getLighting().getLightRequiring());
		result.appendChild(light);

		Element water = document.createElement(XML.WATERING.value());
		water.setAttribute(XML.MEASURE.value(), flower.getGrowingTips().getWatering().getMeasure());
		water.setTextContent(flower.getGrowingTips().getWatering().getValue().toString());
		result.appendChild(water);

		return result;
	}

	/*
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, TransformerException {

		// try to parse NOT valid XML document with validation on (failed)
		DOMController domContr = new DOMController(Constants.VALID_XML_FILE, Constants.XSD_FILE);
		try {
			domContr.parse(true); // <-- parse with validation (failed)
		} catch (SAXException ex) {
			ex.printStackTrace();
			System.err.println("====================================");
			System.err.println("XML not valid");
			System.err.println("Test object --> " + domContr.getTest());
			System.err.println("====================================");
		}

		// try to parse NOT valid XML document with validation off (success)
		domContr.parse(false); // <-- parse with validation off (success)

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + domContr.getTest());
		System.out.println("====================================");

		// save test in XML file
		Test test = domContr.getTest();
		DOMController.saveXML(test, Constants.VALID_XML_FILE + ".dom.xml");
	}
	*/
}