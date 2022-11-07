package com.epam.rd.java.basic.topic08.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "flower"
})
@XmlRootElement(name = "flowers", namespace = "http://www.nure.ua")
public class Flowers {

    @XmlElement(namespace = "http://www.nure.ua")
    protected List<Flower> flower;


    public List<Flower> getFlower() {
        if (flower == null) {
            flower = new ArrayList<>();
        }
        return this.flower;
    }


}