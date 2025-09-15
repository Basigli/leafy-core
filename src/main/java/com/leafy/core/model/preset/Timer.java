package com.leafy.core.model.preset;

import java.time.Duration;
import java.time.LocalTime;

public class Timer {
    private final LocalTime startTime;
    private final LocalTime endTime;


    private Timer(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Timer getTimer(LocalTime startTime, Duration duration) {
        return new Timer(startTime, startTime.plusSeconds(duration.getSeconds()));
    }

    public static Timer getTimer(LocalTime startTime, LocalTime endTime) {
        if (endTime.isBefore(startTime))
            return null;
        return new Timer(startTime, endTime);
    }

    public boolean isOver() {
        return LocalTime.now().isAfter(this.endTime);
    }
}
