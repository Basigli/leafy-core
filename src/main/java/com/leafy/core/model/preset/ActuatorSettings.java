package com.leafy.core.model.preset;

import com.leafy.core.model.greenhouse.sensors.Sensor;
import com.leafy.core.model.greenhouse.sensors.SensorName;

import java.util.List;
public class ActuatorSettings {
    private ActuatorStageMode actuatorStageMode;
    private List<Timer> timers;
    private SetPointsMode setPointsMode;
    private Integer lowSetPoint;
    private Integer highSetPoint;

    private SensorName sensorAttached;

    public ActuatorSettings(ActuatorStageMode actuatorStageMode, List<Timer> timers, SetPointsMode setPointsMode, Integer lowSetPoint, Integer highSetPoint, SensorName sensorAttached) {
        this.actuatorStageMode = actuatorStageMode;
        this.timers = timers;
        this.setPointsMode = setPointsMode;
        this.lowSetPoint = lowSetPoint;
        this.highSetPoint = highSetPoint;
        this.sensorAttached = sensorAttached;
    }

    public ActuatorSettings getTemporizedSettings(List<Timer> timers) {
        return new ActuatorSettings(ActuatorStageMode.TEMPORIZED, timers, null, null, null, null);
    }


    public ActuatorSettings getSensorizedSettings(SensorName sensorAttached, Integer lowSetPoint, Integer highSetPoint) {
        SetPointsMode setPointsMode = SetPointsMode.getFromSensorName(sensorAttached);
        if (lowSetPoint >= highSetPoint) {
            return null;
        }
        if (highSetPoint > 100) {
            return null;
        }
        return new ActuatorSettings(ActuatorStageMode.SENSORIZED, null, setPointsMode, lowSetPoint, highSetPoint, sensorAttached);
    }




}
