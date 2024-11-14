package com.leafy.core.model.greenhouse;

public class Sensor implements ISensor {
    private String arduinoId;
    private SensorName name;
    private MeasureUnit measureUnit;

    @Override
    public Float readValue() {
        return null;
    }

}
