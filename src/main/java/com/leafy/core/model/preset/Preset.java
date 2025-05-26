package com.leafy.core.model.preset;

import java.util.List;

public class Preset implements IPreset {
    private String name;
    private String description;
    private Integer stagesNumber;
    private Integer presetId;
    private List<Stages> stages;
}
