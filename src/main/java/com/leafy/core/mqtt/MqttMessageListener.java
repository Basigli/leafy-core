package com.leafy.core.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

//@Component
public class MqttMessageListener implements MqttCallback {

    private final CountDownLatch latch;

    public MqttMessageListener(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void connectionLost(Throwable throwable) {
       // to implement
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        String payload = new String(mqttMessage.getPayload());
        System.out.println("Message received at " + topic + ": " + payload);
        latch.countDown();
    }


    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // to implement
    }
}