package com.leafy.core;

import com.leafy.core.mqtt.MqttClientFactory;
import com.leafy.core.mqtt.MqttMessageListener;
import com.leafy.core.mqtt.MqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MqttTest {

    @Test
    public void testPublishMessage() throws Exception {

        MqttClientFactory factory = new MqttClientFactory();

        MqttClient mqttClientMock = factory.getMqttClient();

        MqttPublisher mqttPublisher = new MqttPublisher();
        mqttPublisher.setMqttClient(mqttClientMock);

        mqttPublisher.publishMessage("test/topic", "Test message");
    }

    @Test
    public void testSubscribeMessage() throws Exception {

        MqttClientFactory mqttConfig = new MqttClientFactory();
        MqttClient mqttClientMock = mqttConfig.getMqttClient();

        CountDownLatch latch = new CountDownLatch(5);

        MqttMessageListener mqttMessageListener = new MqttMessageListener(latch);
        mqttClientMock.setCallback(mqttMessageListener);


        mqttClientMock.subscribe("PVHBE/AirTemperature");
        latch.await(60, TimeUnit.SECONDS); // Attendi fino a che il latch non viene segnalato entro 10 secondi

        mqttClientMock.disconnect();
        mqttClientMock.close();



    }
}