package com.leafy.core.model.greenhouse;

public enum ActuatorName {
    IRRIGATION("IrrigationPump"),
    UV_LIGHT("UVLight"),
    VENTILATION("Ventilation");

    private final String payloadName;

    public String getPayloadName() {
        return payloadName;
    }

    private ActuatorName(String payloadName) {
        this.payloadName = payloadName;
    }
}
