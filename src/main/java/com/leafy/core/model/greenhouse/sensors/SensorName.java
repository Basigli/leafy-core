package com.leafy.core.model.greenhouse.sensors;

public enum SensorName {
    AIR_HUM("AirHumidity"),
    AIR_TEMP("AirTemperature"),
    IS_TANK_EMPTY("IsTankEmpty"),
    LIGHT_QUANTITY("LightQuantity"),
    TERRAIN_HUM("TerrainHumidity");
    private final String payloadValue;

    public String getPayloadValue() {
        return payloadValue;
    }

    private SensorName(String payloadValue) {
        this.payloadValue = payloadValue;
    }
}
