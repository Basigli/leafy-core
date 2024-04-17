package com.leafy.core.model.greenhouse;

import java.util.List;

public class Greenhouse implements IGreenhouse {
    private int id;
    private String arduino_id;
    private String name;
    private boolean isInAutoMode;
    private int growthStage;
    //private Preset preset;
    private List<Sensor> sensors;
    private List<Actuator> actuators;


}
