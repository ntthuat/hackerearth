package com.ntthuat.publish_subscribe_pattern;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ntthuat
 */
public class Event {

    static {
        init();
    }

    static Operation operation;

    static ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<Object>>> channels;

    static void init() {
        channels = new ConcurrentHashMap<>();
        operation = new Operation();
    }
}
