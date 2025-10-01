#!/usr/bin/env python3
"""
Simple MQTT Message Sender
This program sends a message to an MQTT broker.
"""

import paho.mqtt.client as mqtt
import time
import json
from datetime import datetime

class MQTTSender:
    def __init__(self, broker_host="localhost", broker_port=1883, username=None, password=None):
        """
        Initialize MQTT sender
        
        Args:
            broker_host (str): MQTT broker hostname or IP
            broker_port (int): MQTT broker port (default: 1883)
            username (str): Username for authentication (optional)
            password (str): Password for authentication (optional)
        """
        self.broker_host = broker_host
        self.broker_port = broker_port
        self.username = username
        self.password = password
        self.client = mqtt.Client()
        
        # Set up authentication if provided
        if username and password:
            self.client.username_pw_set(username, password)
        
        # Set up callbacks
        self.client.on_connect = self.on_connect
        self.client.on_publish = self.on_publish
        self.client.on_disconnect = self.on_disconnect

    def on_connect(self, client, userdata, flags, rc):
        """Callback for when the client connects to the broker"""
        if rc == 0:
            print(f"✅ Connected to MQTT broker at {self.broker_host}:{self.broker_port}")
        else:
            print(f"❌ Failed to connect to MQTT broker. Return code: {rc}")

    def on_publish(self, client, userdata, mid):
        """Callback for when a message is published"""
        print(f"📤 Message published successfully (Message ID: {mid})")

    def on_disconnect(self, client, userdata, rc):
        """Callback for when the client disconnects"""
        print(f"🔌 Disconnected from MQTT broker")

    def connect(self):
        """Connect to the MQTT broker"""
        try:
            print(f"🔄 Connecting to MQTT broker at {self.broker_host}:{self.broker_port}...")
            self.client.connect(self.broker_host, self.broker_port, 60)
            self.client.loop_start()  # Start the network loop in a separate thread
            time.sleep(1)  # Give some time for the connection to establish
            return True
        except Exception as e:
            print(f"❌ Error connecting to MQTT broker: {e}")
            return False

    def send_message(self, topic, message, qos=0, retain=False):
        """
        Send a message to the specified topic
        
        Args:
            topic (str): MQTT topic to publish to
            message (str or dict): Message to send
            qos (int): Quality of Service level (0, 1, or 2)
            retain (bool): Whether to retain the message
        """
        try:
            # Convert dict to JSON string if needed
            if isinstance(message, dict):
                message = json.dumps(message)
            
            # Publish the message
            result = self.client.publish(topic, message, qos=qos, retain=retain)
            
            if result.rc == mqtt.MQTT_ERR_SUCCESS:
                print(f"📨 Sending message to topic '{topic}': {message}")
                return True
            else:
                print(f"❌ Failed to send message. Error code: {result.rc}")
                return False
                
        except Exception as e:
            print(f"❌ Error sending message: {e}")
            return False

    def disconnect(self):
        """Disconnect from the MQTT broker"""
        self.client.loop_stop()
        self.client.disconnect()

def main():
    """Main function demonstrating MQTT message sending"""
    
    # Configuration - Update these values for your MQTT broker
    BROKER_HOST = "localhost"  # Change to your MQTT broker address
    BROKER_PORT = 1883         # Change if using different port
    USERNAME = None            # Set if authentication required
    PASSWORD = None            # Set if authentication required
    
    # Topic and message configuration
    TOPIC = "sensors/temperature"
    
    # Create MQTT sender instance
    mqtt_sender = MQTTSender(
        broker_host=BROKER_HOST,
        broker_port=BROKER_PORT,
        username=USERNAME,
        password=PASSWORD
    )
    
    # Connect to broker
    if not mqtt_sender.connect():
        print("❌ Failed to connect to MQTT broker. Exiting...")
        return
    
    try:
        # Example 1: Send a simple text message
        print("\n--- Example 1: Simple text message ---")
        mqtt_sender.send_message(TOPIC, "25.6°C")
        time.sleep(1)
        
        # Example 2: Send a JSON message
        print("\n--- Example 2: JSON message ---")
        sensor_data = {
            "timestamp": datetime.now().isoformat(),
            "sensor_id": "temp_001",
            "temperature": 25.6,
            "humidity": 60.2,
            "location": "Living Room"
        }
        mqtt_sender.send_message("sensors/data", sensor_data)
        time.sleep(1)
        
        # Example 3: Send multiple messages
        print("\n--- Example 3: Multiple messages ---")
        topics_and_messages = [
            ("sensors/temperature", "26.1°C"),
            ("sensors/humidity", "58.7%"),
            ("sensors/pressure", "1013.25 hPa"),
            ("status/device", "online")
        ]
        
        for topic, message in topics_and_messages:
            mqtt_sender.send_message(topic, message)
            time.sleep(0.5)
            
        # Example 4: Send with different QoS levels
        print("\n--- Example 4: Different QoS levels ---")
        mqtt_sender.send_message("critical/alert", "High temperature detected!", qos=1)
        time.sleep(1)
        
        print("\n✅ All messages sent successfully!")
        
    except KeyboardInterrupt:
        print("\n🛑 Interrupted by user")
    except Exception as e:
        print(f"❌ An error occurred: {e}")
    finally:
        # Clean up
        mqtt_sender.disconnect()
        print("👋 MQTT sender disconnected")

if __name__ == "__main__":
    main()