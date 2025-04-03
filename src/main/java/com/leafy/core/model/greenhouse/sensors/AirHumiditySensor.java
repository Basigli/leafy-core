package com.leafy.core.model.greenhouse.sensors;

public class AirHumiditySensor extends Sensor {
    public AirHumiditySensor(String arduinoId) {
        super(arduinoId);
    }
    public Float readValue() {
        return 2F;
    }

}
