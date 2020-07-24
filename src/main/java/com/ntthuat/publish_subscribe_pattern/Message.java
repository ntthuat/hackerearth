package com.ntthuat.publish_subscribe_pattern;

import lombok.Getter;

/**
 * @author ntthuat
 */
@Getter
public class Message extends Post {
    String message;

    public Message(String message) {
        super(message);
        this.message = message;
    }
}
