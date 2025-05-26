package com.leafy.core.model.preset;

import com.leafy.core.model.greenhouse.sensors.SensorName;

public enum SetPointsMode {
    LEADING_EDGE,
    TRAILING_EDGE;

    public static SetPointsMode getFromSensorName(SensorName sensorName) {
        if (sensorName == SensorName.AIR_HUM || sensorName == SensorName.AIR_TEMP || sensorName == SensorName.TERRAIN_HUM) {
            return TRAILING_EDGE;
        } else if (sensorName == SensorName.LIGHT_QUANTITY) {
            return LEADING_EDGE;
        }
        return null;
    }
}
