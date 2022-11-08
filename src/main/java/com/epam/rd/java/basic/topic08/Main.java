package com.epam.rd.java.basic.topic08;



import com.epam.rd.java.basic.topic08.controller.DOMController;
import com.epam.rd.java.basic.topic08.controller.SAXController;
import com.epam.rd.java.basic.topic08.controller.STAXController;
import com.epam.rd.java.basic.topic08.ua.nure.Flowers;
import com.epam.rd.java.basic.topic08.util.Sorter;
import com.epam.rd.java.basic.topic08.util.Transformer;
import org.xml.sax.SAXException;



public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			return;
		}

		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////

		// get container
		DOMController domController = new DOMController(xmlFileName);
		try {
			domController.parse(true); // <-- parse with validation
		} catch (SAXException ex) {
			ex.printStackTrace();
			System.err.println("====================================");
			System.err.println("XML not valid");
			System.err.println("====================================");
		}

		// sort (case 1)
		Sorter.sortFlowersByFlowerName(domController.getFlowers());

		// save
		String outputXmlFile = "output.dom.xml";
		Flowers fls = domController.getFlowers();
		DOMController.saveXML(fls, outputXmlFile);
		//System.out.println(fls);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////

		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true); // <-- do parse with validation on (success)
		fls = saxController.getFlowers();

		// sort  (case 2)
		Sorter.sortFlowersByFlowerOrigin(fls);

		// save
		outputXmlFile = "output.sax.xml";
		DOMController.saveXML(fls, outputXmlFile);

		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////

		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse(); // <-- do parse (success)
		fls = staxController.getFlowers();

		// sort  (case 3)
		Sorter.sortFlowersByFlowerWatering(fls);

		// save
		outputXmlFile = "output.stax.xml";
		DOMController.saveXML(fls, outputXmlFile);

		////////////////////////////////////////////////////////
		// Transform xml to html
		////////////////////////////////////////////////////////
		System.out.println("XML ==> HTML");
		String xslFileName = "input.xsl";
		String htmlFileName = "input.html";
		Transformer.saveToHTML(xmlFileName, xslFileName, htmlFileName);
	}

}
