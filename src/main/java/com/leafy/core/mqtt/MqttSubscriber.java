package com.leafy.core.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriber {
    private MqttClient mqttClient;

    @Autowired
    private MqttMessageListener mqttMessageListener;

    public void subscribeToTopic(String topic) throws MqttException {
        mqttClient.setCallback(mqttMessageListener);
        mqttClient.subscribe(topic);
    }

    @Autowired
    public void setMqttClient(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }
}
