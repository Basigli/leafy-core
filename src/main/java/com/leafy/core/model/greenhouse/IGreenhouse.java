package com.leafy.core.model.greenhouse;

import com.leafy.core.model.preset.Preset;

public interface IGreenhouse {
    Integer getId();

    void setId(Integer id);

    String getArduinoId();
    void setArduinoId(String arduinoId);

    String getName();

    void setName(String name);

    boolean isInAutoMode();

    void setInAutoMode(boolean inAutoMode);

    Integer getGrowthStage();

    void setGrowthStage(Integer growthStage);
    boolean autoMode();
}
