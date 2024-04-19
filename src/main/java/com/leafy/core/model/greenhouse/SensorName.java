package com.leafy.core.model.greenhouse;

public enum SensorName {
    AIR_HUM("AirHumidity"),
    AIR_TEMP("AirTemperature"),
    IS_TANK_EMPTY("IsTankEmpty"),
    LIGHT_QUANTITY("LightQuantity"),
    TERRAIN_HUM("TerrainHumidity");
    private final String payloadName;

    public String getPayloadName() {
        return payloadName;
    }

    private SensorName(String payloadName) {
        this.payloadName = payloadName;
    }
}
