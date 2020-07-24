package com.ntthuat.publish_subscribe_pattern;

import org.junit.jupiter.api.Test;

/**
 * @author ntthuat
 */
class PublishSubscribePatternTest {

    @Test
    void testFlow_success() {
        // Create 4 subscriber
        Subscriber subscriber = new Subscriber(1);
        Subscriber subscriber2 = new Subscriber(2);
        Subscriber subscriber3 = new Subscriber(3);
        Subscriber subscriber4 = new Subscriber(4);

        // subscribe into 3 different channels with different subscriber on each channel
        Event.operation.subscribe("action#create", subscriber);
        Event.operation.subscribe("action#create", subscriber2);
        Event.operation.subscribe("action#update", subscriber3);
        Event.operation.subscribe("action#delete", subscriber4);

        Message message = new Message("Create Action");
        Message message2 = new Message("Update Action");

        Event.operation.publish("action#create", message);
        Event.operation.publish("action#update", message2);
    }
}
