package com.leafy.core.model.preset;

import com.leafy.core.model.greenhouse.ActuatorName;

import java.util.Map;

public class Stages {
    private Integer duration;
    private Map<ActuatorName, ActuatorSettings> actuatorSettingsMap;
}
