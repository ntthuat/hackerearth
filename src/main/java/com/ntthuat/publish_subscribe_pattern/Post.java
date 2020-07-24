package com.ntthuat.publish_subscribe_pattern;

/**
 * @author ntthuat
 */
abstract class Post {
    String message;

    Post(String message) {
        this.message = message;
    }
}
