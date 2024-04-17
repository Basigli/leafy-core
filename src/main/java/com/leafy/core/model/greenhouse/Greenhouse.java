package com.leafy.core.model.greenhouse;

import java.util.List;

public class Greenhouse implements IGreenhouse {
    private Integer id;
    private String arduino_id;
    private String name;
    private boolean isInAutoMode;
    private Integer growthStage;
    //private Preset preset;
    private List<Sensor> sensors;
    private List<Actuator> actuators;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArduino_id() {
        return arduino_id;
    }

    public void setArduino_id(String arduino_id) {
        this.arduino_id = arduino_id;
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
}
