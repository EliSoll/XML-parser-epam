package com.epam.rd.java.basic.topic08.util;

import java.util.Collections;
import java.util.Comparator;

import com.epam.rd.java.basic.topic08.ua.nure.Flowers;



/**
 * Contains static methods for sorting.
 *
 *
 */
public class Sorter {
    ////////////////////////////////////////////////////////////
    // these are comparators
    ////////////////////////////////////////////////////////////

    /**
     * Sorts flowers by flower name
     */
    public static final Comparator<Flowers.Flower> sortFlowersByFlowerName = new Comparator<Flowers.Flower>() {
        @Override
        public int compare(Flowers.Flower o1, Flowers.Flower o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    /**
     * Sorts flowers by flower origin
     */
    public static final Comparator<Flowers.Flower> sortFlowersByFlowerOrigin = new Comparator<Flowers.Flower>() {
        @Override
        public int compare(Flowers.Flower o1, Flowers.Flower o2) {
            return o1.getOrigin().compareTo(o2.getOrigin());
        }
    };

    /**
     * Sorts flowers by flower watering.
     */
    public static final Comparator<Flowers.Flower> sortFlowersByFlowerWatering = new Comparator<Flowers.Flower>() {
        @Override
        public int compare(Flowers.Flower o1, Flowers.Flower o2) {
            return -o1.getGrowingTips().getWatering().getValue().compareTo(o2.getGrowingTips().getWatering().getValue());
        }
    };


    ////////////////////////////////////////////////////////////
    // these methods take Test object and sort it
    // with according comparator
    ////////////////////////////////////////////////////////////

    public static final void sortFlowersByFlowerName(Flowers test) {
        Collections.sort(test.getFlower(),
                sortFlowersByFlowerName);
    }

    public static final void sortFlowersByFlowerOrigin(Flowers test) {
        Collections.sort(test.getFlower(),
                sortFlowersByFlowerOrigin);
    }

    public static final void sortFlowersByFlowerWatering(Flowers test) {
        Collections.sort(test.getFlower(),
                sortFlowersByFlowerWatering);
    }

    /*
	public static void main(String[] args) throws Exception {
		// Test.xml --> Test object
		DOMController domController = new DOMController(Constants.VALID_XML_FILE, Constants.XSD_FILE);
		domController.parse(false);
		Test test = domController.getTest();

		System.out.println("====================================");
		System.out.println(test);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortQuestionsByQuestionText(test);
		System.out.println(test);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortAnswersByContent(test);
		System.out.println(test);
	}
	*/
}
