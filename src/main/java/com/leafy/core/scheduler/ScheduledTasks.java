package com.leafy.core.scheduler;


import com.leafy.core.model.greenhouse.Actuator;
import com.leafy.core.model.greenhouse.ActuatorName;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000)
    public void performTask() throws Exception {
        Actuator irrigationPump = new Actuator(ActuatorName.IRRIGATION, "PVHBE");
        irrigationPump.turnOn();
    }
}
