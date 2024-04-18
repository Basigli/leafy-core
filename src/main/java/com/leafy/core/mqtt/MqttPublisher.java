package com.leafy.core.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisher {

    private MqttClient mqttClient;
    @Autowired
    public void setMqttClient(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }
    public void publishMessage(String topic, String payload) throws Exception {
        MqttMessage message = new MqttMessage(payload.getBytes());
        mqttClient.publish(topic, message);
    }
}