package com.leafy.core.model.greenhouse;

import com.leafy.core.mqtt.MqttClientFactory;
import com.leafy.core.mqtt.MqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class Actuator implements IActuator {
    private String arduinoId;
    private ActuatorName name;
    private ActuatorState state;
    private MqttPublisher publisher;
    private String topic;


    public Actuator(ActuatorName name, String arduinoId) throws Exception {
        MqttClientFactory factory = new MqttClientFactory();
        MqttClient mqttClient = factory.getMqttClient();

        this.publisher = new MqttPublisher();
        this.publisher.setMqttClient(mqttClient);
        this.name = name;
        this.arduinoId = arduinoId;
        this.setTopic();
    }

    private void setTopic() {
        this.topic = this.arduinoId + "/" + this.name.getPayloadValue();
    }


    public String getArduinoId() {
        return arduinoId;
    }

    public void setArduinoId(String arduinoId) {
        this.arduinoId = arduinoId;
        this.setTopic();
    }

    public ActuatorName getName() {
        return name;
    }

    public void setName(ActuatorName name) {
        this.name = name;
        this.setTopic();
    }

    public ActuatorState getState() {
        return state;
    }

    public void setState(ActuatorState state) {
        this.state = state;
    }

    public boolean turnOn() {
        try {
            this.publisher.publishMessage(this.topic, ActuatorState.ON.getPayloadValue());
            this.state = ActuatorState.ON;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean turnOff() {
        try {
            this.publisher.publishMessage(this.topic, ActuatorState.OFF.getPayloadValue());
            this.state = ActuatorState.OFF;
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
