package com.epam.rd.java.basic.topic08.constants;


public enum XML {
    // these are tags
    FLOWERS("flowers"),
    FLOWER("flower"),
    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    VISUALPARAMS("visualParameters"),
    STEMCOLOR("stemColour"),
    LEAFCOLOR("leafColour"),
    AVELENFLOWER("aveLenFlower"),
    GROWINGTIPS("growingTips"),
    TEMPRETURE("tempreture"),
    LIGHTING("lighting"),
    WATERING("watering"),
    MULTIPLYING("multiplying"),

    // these are attributes
    MEASURE("measure"),
    LIGHTREQUIRING("lightRequiring");

    private String value;

    public String value() {
        return value;
    }

    XML(String value) {
        this.value = value.intern();
    }
}
