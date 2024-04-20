package com.leafy.core.model.greenhouse;

public enum ActuatorName {
    IRRIGATION("IrrigationPump"),
    UV_LIGHT("UVLight"),
    VENTILATION("Ventilation");

    private final String payloadValue;

    public String getPayloadValue() {
        return payloadValue;
    }

    private ActuatorName(String payloadValue) {
        this.payloadValue = payloadValue;
    }
}
