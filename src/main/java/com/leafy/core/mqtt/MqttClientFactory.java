package com.leafy.core.mqtt;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttClientFactory {

    private static final String MQTT_BROKER = "tcp://192.168.1.22:1883";
    private static final String CLIENT_ID = "spring-client";

    private MqttClient mqttClient = null;
    @Bean
    public MqttClient getMqttClient() throws Exception {
        if (this.mqttClient != null) {
            return this.mqttClient;
        }

        MqttClient mqttClient = new MqttClient(MQTT_BROKER, CLIENT_ID);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        mqttClient.connect(options);
        this.mqttClient = mqttClient;
        return mqttClient;
    }
}