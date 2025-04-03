package com.leafy.core.model.greenhouse.sensors;

public class AirTemperatureSensor extends Sensor {
    public AirTemperatureSensor(String arduinoId) {
        super(arduinoId);
    }

    @Override
    public Float readValue() {
        return null;
    }
}
