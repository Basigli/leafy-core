package com.leafy.core;

import com.leafy.core.mqtt.MqttConfig;
import com.leafy.core.mqtt.MqttMessageListener;
import com.leafy.core.mqtt.MqttPublisher;
import com.leafy.core.mqtt.MqttSubscriber;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class MqttPublisherTest {

    @Test
    public void testPublishMessage() throws Exception {
        // Mock del client MQTT
        MqttConfig mqttConfig = new MqttConfig();

        //MqttClient mqttClientMock = Mockito.mock(MqttClient.class);
        MqttClient mqttClientMock = mqttConfig.mqttClient();
        // Simulazione del comportamento del client MQTT
        //doNothing().when(mqttClientMock).connect(any());
        //doNothing().when(mqttClientMock).publish(anyString(), any(MqttMessage.class));

        // Creazione dell'istanza del MqttPublisher con il client MQTT mockato
        MqttPublisher mqttPublisher = new MqttPublisher();
        mqttPublisher.setMqttClient(mqttClientMock);
        // Chiamata del metodo per pubblicare un messaggio
        mqttPublisher.publishMessage("test/topic", "Test message");

        // Verifica che il metodo publish sia stato chiamato correttamente
        //verify(mqttClientMock).publish("test/topic", new MqttMessage("Test message".getBytes()));
    }
    @Test
    public void testSubscribeMessage() throws Exception {
        //MqttSubscriber mqttSubscriber = new MqttSubscriber();
        MqttConfig mqttConfig = new MqttConfig();
        MqttClient mqttClientMock = mqttConfig.mqttClient();
        //mqttSubscriber.setMqttClient(mqttClientMock);
        CountDownLatch latch = new CountDownLatch(1);
        //mqttSubscriber.subscribeToTopic("PVHBE/AirTemperature");
        MqttMessageListener mqttMessageListener = new MqttMessageListener(latch);
        mqttClientMock.setCallback(mqttMessageListener);


        mqttClientMock.subscribe("PVHBE/AirTemperature");
        latch.await(10, TimeUnit.SECONDS); // Attendi fino a che il latch non viene segnalato entro 10 secondi

        mqttClientMock.disconnect();
        mqttClientMock.close();
        //verify(mqttClientMock).setCallback(mqttMessageListener);
        //verify(mqttClientMock).subscribe("PVHBE/AirTemperature");


    }
}