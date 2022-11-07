package com.epam.rd.java.basic.topic08;



import com.epam.rd.java.basic.topic08.controller.DOMController;
import com.epam.rd.java.basic.topic08.controller.SAXController;
import com.epam.rd.java.basic.topic08.controller.STAXController;
import com.epam.rd.java.basic.topic08.util.Sorting;
import com.epam.rd.java.basic.topic08.entity.Flowers;

public final class Main {

	public static void main(final String[] args) throws Exception {
		String xmlFileName = "input.xml";



		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);

		Flowers flowers = domController.getFlowers();
		Sorting.setSortFlowersByAveLen(flowers);

		String outputXmlFile = "output.dom.xml";
		DOMController.saveXML(flowers, outputXmlFile);



		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		flowers = saxController.getFlowers();

		Sorting.setSortFlowersByFlowersName(flowers);

		outputXmlFile = "output.sax.xml";
		DOMController.saveXML(flowers, outputXmlFile);



		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		flowers = staxController.getFlowers();

		Sorting.setSortFlowersByWateringMeasure(flowers);

		outputXmlFile = "output.stax.xml";
		DOMController.saveXML(flowers, outputXmlFile);
	}
}