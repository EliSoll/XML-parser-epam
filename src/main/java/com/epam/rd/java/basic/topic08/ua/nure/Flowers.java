package com.epam.rd.java.basic.topic08.ua.nure;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flower" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="([a-zA-Z�-��-�])+"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="soil">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="�����������"/>
 *                         &lt;enumeration value="���������"/>
 *                         &lt;enumeration value="�������-�����������"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="origin">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="([a-zA-Z�-��-�])+"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="visualParameters">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="stemColour">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="([a-zA-Z�-��-�])+"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="leafColour">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="([a-zA-Z�-��-�])+"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="aveLenFlower" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
 *                                     &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="cm" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="growingTips">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tempreture">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
 *                                     &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="celcius" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="lighting">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="lightRequiring" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="yes"/>
 *                                           &lt;enumeration value="no"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="watering" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
 *                                     &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="mlPerWeek" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="multiplying">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="������"/>
 *                         &lt;enumeration value="�������"/>
 *                         &lt;enumeration value="������"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "flower"
})
@XmlRootElement(name = "flowers")
public class Flowers {

    protected List<Flowers.Flower> flower;

    /**
     * Gets the value of the flower property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flower property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlower().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Flowers.Flower }
     *
     *
     */
    public List<Flowers.Flower> getFlower() {
        if (flower == null) {
            flower = new ArrayList<Flowers.Flower>();
        }
        return this.flower;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="([a-zA-Z�-��-�])+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="soil">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="�����������"/>
     *               &lt;enumeration value="���������"/>
     *               &lt;enumeration value="�������-�����������"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="origin">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="([a-zA-Z�-��-�])+"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="visualParameters">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stemColour">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="([a-zA-Z�-��-�])+"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="leafColour">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="([a-zA-Z�-��-�])+"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="aveLenFlower" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
     *                           &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="cm" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="growingTips">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tempreture">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
     *                           &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="celcius" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="lighting">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="lightRequiring" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="yes"/>
     *                                 &lt;enumeration value="no"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="watering" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
     *                           &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="mlPerWeek" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="multiplying">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="������"/>
     *               &lt;enumeration value="�������"/>
     *               &lt;enumeration value="������"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "name",
            "soil",
            "origin",
            "visualParameters",
            "growingTips",
            "multiplying"
    })
    public static class Flower {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String soil;
        @XmlElement(required = true)
        protected String origin;
        @XmlElement(required = true)
        protected Flowers.Flower.VisualParameters visualParameters;
        @XmlElement(required = true)
        protected Flowers.Flower.GrowingTips growingTips;
        @XmlElement(required = true)
        protected String multiplying;

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the soil property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSoil() {
            return soil;
        }

        /**
         * Sets the value of the soil property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSoil(String value) {
            this.soil = value;
        }

        /**
         * Gets the value of the origin property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

        /**
         * Gets the value of the visualParameters property.
         *
         * @return
         *     possible object is
         *     {@link Flowers.Flower.VisualParameters }
         *
         */
        public Flowers.Flower.VisualParameters getVisualParameters() {
            return visualParameters;
        }

        /**
         * Sets the value of the visualParameters property.
         *
         * @param value
         *     allowed object is
         *     {@link Flowers.Flower.VisualParameters }
         *
         */
        public void setVisualParameters(Flowers.Flower.VisualParameters value) {
            this.visualParameters = value;
        }

        /**
         * Gets the value of the growingTips property.
         *
         * @return
         *     possible object is
         *     {@link Flowers.Flower.GrowingTips }
         *
         */
        public Flowers.Flower.GrowingTips getGrowingTips() {
            return growingTips;
        }

        /**
         * Sets the value of the growingTips property.
         *
         * @param value
         *     allowed object is
         *     {@link Flowers.Flower.GrowingTips }
         *
         */
        public void setGrowingTips(Flowers.Flower.GrowingTips value) {
            this.growingTips = value;
        }

        /**
         * Gets the value of the multiplying property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMultiplying() {
            return multiplying;
        }

        /**
         * Sets the value of the multiplying property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMultiplying(String value) {
            this.multiplying = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tempreture">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
         *                 &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="celcius" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="lighting">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="lightRequiring" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="yes"/>
         *                       &lt;enumeration value="no"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="watering" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
         *                 &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="mlPerWeek" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "tempreture",
                "lighting",
                "watering"
        })
        public static class GrowingTips {

            @XmlElement(required = true)
            protected Flowers.Flower.GrowingTips.Tempreture tempreture;
            @XmlElement(required = true)
            protected Flowers.Flower.GrowingTips.Lighting lighting;
            protected Flowers.Flower.GrowingTips.Watering watering;

            /**
             * Gets the value of the tempreture property.
             *
             * @return
             *     possible object is
             *     {@link Flowers.Flower.GrowingTips.Tempreture }
             *
             */
            public Flowers.Flower.GrowingTips.Tempreture getTempreture() {
                return tempreture;
            }

            /**
             * Sets the value of the tempreture property.
             *
             * @param value
             *     allowed object is
             *     {@link Flowers.Flower.GrowingTips.Tempreture }
             *
             */
            public void setTempreture(Flowers.Flower.GrowingTips.Tempreture value) {
                this.tempreture = value;
            }

            /**
             * Gets the value of the lighting property.
             *
             * @return
             *     possible object is
             *     {@link Flowers.Flower.GrowingTips.Lighting }
             *
             */
            public Flowers.Flower.GrowingTips.Lighting getLighting() {
                return lighting;
            }

            /**
             * Sets the value of the lighting property.
             *
             * @param value
             *     allowed object is
             *     {@link Flowers.Flower.GrowingTips.Lighting }
             *
             */
            public void setLighting(Flowers.Flower.GrowingTips.Lighting value) {
                this.lighting = value;
            }

            /**
             * Gets the value of the watering property.
             *
             * @return
             *     possible object is
             *     {@link Flowers.Flower.GrowingTips.Watering }
             *
             */
            public Flowers.Flower.GrowingTips.Watering getWatering() {
                return watering;
            }

            /**
             * Sets the value of the watering property.
             *
             * @param value
             *     allowed object is
             *     {@link Flowers.Flower.GrowingTips.Watering }
             *
             */
            public void setWatering(Flowers.Flower.GrowingTips.Watering value) {
                this.watering = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="lightRequiring" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="yes"/>
             *             &lt;enumeration value="no"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Lighting {

                @XmlAttribute(name = "lightRequiring", required = true)
                protected String lightRequiring;

                /**
                 * Gets the value of the lightRequiring property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLightRequiring() {
                    return lightRequiring;
                }

                /**
                 * Sets the value of the lightRequiring property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLightRequiring(String value) {
                    this.lightRequiring = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
             *       &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="celcius" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class Tempreture {

                @XmlValue
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger value;
                @XmlAttribute(name = "measure", required = true)
                protected String measure;

                /**
                 * Gets the value of the value property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setValue(BigInteger value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the measure property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getMeasure() {
                    if (measure == null) {
                        return "celcius";
                    } else {
                        return measure;
                    }
                }

                /**
                 * Sets the value of the measure property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setMeasure(String value) {
                    this.measure = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
             *       &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="mlPerWeek" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class Watering {

                @XmlValue
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger value;
                @XmlAttribute(name = "measure", required = true)
                protected String measure;

                /**
                 * Gets the value of the value property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setValue(BigInteger value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the measure property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getMeasure() {
                    if (measure == null) {
                        return "mlPerWeek";
                    } else {
                        return measure;
                    }
                }

                /**
                 * Sets the value of the measure property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setMeasure(String value) {
                    this.measure = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="stemColour">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="([a-zA-Z�-��-�])+"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="leafColour">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="([a-zA-Z�-��-�])+"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="aveLenFlower" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
         *                 &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="cm" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "stemColour",
                "leafColour",
                "aveLenFlower"
        })
        public static class VisualParameters {

            @XmlElement(required = true)
            protected String stemColour;
            @XmlElement(required = true)
            protected String leafColour;
            protected Flowers.Flower.VisualParameters.AveLenFlower aveLenFlower;

            /**
             * Gets the value of the stemColour property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getStemColour() {
                return stemColour;
            }

            /**
             * Sets the value of the stemColour property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setStemColour(String value) {
                this.stemColour = value;
            }

            /**
             * Gets the value of the leafColour property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getLeafColour() {
                return leafColour;
            }

            /**
             * Sets the value of the leafColour property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setLeafColour(String value) {
                this.leafColour = value;
            }

            /**
             * Gets the value of the aveLenFlower property.
             *
             * @return
             *     possible object is
             *     {@link Flowers.Flower.VisualParameters.AveLenFlower }
             *
             */
            public Flowers.Flower.VisualParameters.AveLenFlower getAveLenFlower() {
                return aveLenFlower;
            }

            /**
             * Sets the value of the aveLenFlower property.
             *
             * @param value
             *     allowed object is
             *     {@link Flowers.Flower.VisualParameters.AveLenFlower }
             *
             */
            public void setAveLenFlower(Flowers.Flower.VisualParameters.AveLenFlower value) {
                this.aveLenFlower = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
             *       &lt;attribute name="measure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="cm" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "value"
            })
            public static class AveLenFlower {

                @XmlValue
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger value;
                @XmlAttribute(name = "measure", required = true)
                protected String measure;

                /**
                 * Gets the value of the value property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setValue(BigInteger value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the measure property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getMeasure() {
                    if (measure == null) {
                        return "cm";
                    } else {
                        return measure;
                    }
                }

                /**
                 * Sets the value of the measure property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setMeasure(String value) {
                    this.measure = value;
                }

            }

        }

    }

}
