package com.leafy.core.model.greenhouse.sensors;

public abstract class Sensor implements ISensor {
    protected String arduinoId;
    protected SensorName name;
    protected MeasureUnit measureUnit;

    protected Float value;
    public Sensor(String arduinoId) {
        this.arduinoId = arduinoId;
    }

    public String toString() {
        return "";
    }

}
