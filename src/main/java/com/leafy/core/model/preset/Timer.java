package com.leafy.core.model.preset;

import java.time.Duration;
import java.time.LocalTime;

public class Timer {
    private LocalTime startTime;
    private LocalTime endTime;


    private Timer(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private Timer getTimer(LocalTime startTime, Duration duration) {
        return new Timer(startTime, startTime.plusSeconds(duration.getSeconds()));
    }

    private Timer getTimer(LocalTime startTime, LocalTime endTime) {
        if (endTime.isBefore(startTime))
            return null;
        return new Timer(startTime, endTime);
    }
}
