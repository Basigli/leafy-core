package com.leafy.core.model.greenhouse;

public enum ActuatorState {
    ON("1"),
    OFF("0");

    private final String payloadValue;

    public String getPayloadValue() {
        return payloadValue;
    }

    private ActuatorState(String payloadValue) {
        this.payloadValue = payloadValue;
    }

}
