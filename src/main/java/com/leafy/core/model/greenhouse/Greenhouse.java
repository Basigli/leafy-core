package com.leafy.core.model.greenhouse;

import com.leafy.core.model.greenhouse.sensors.ISensor;
import com.leafy.core.model.greenhouse.sensors.Sensor;
import com.leafy.core.model.preset.Preset;
import java.util.List;

// @Table("GREENHOUSE")
public class Greenhouse implements IGreenhouse {
    private Integer id;
    private String arduinoId;
    private String name;
    private boolean isInAutoMode;
    private Integer growthStage;
    private List<ISensor> sensors;
    private List<IActuator> actuators;
    private Preset preset;

    // region Get/Set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArduinoId() {
        return arduinoId;
    }

    public void setArduinoId(String arduinoId) {
        this.arduinoId = arduinoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInAutoMode() {
        return isInAutoMode;
    }

    public void setInAutoMode(boolean inAutoMode) {
        isInAutoMode = inAutoMode;
    }

    public Integer getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(Integer growthStage) {
        this.growthStage = growthStage;
    }
    // endregion

    public boolean autoMode() {
        return false;
    }


}
