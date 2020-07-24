package com.ntthuat.publish_subscribe_pattern;

/**
 * @author ntthuat
 */
class Subscriber {

    int id;

    public Subscriber(int id) {
        this.id = id;
    }

    @OnMessage
    private void onMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
