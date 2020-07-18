package com.ntthuat.data_structure;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ntthuat
 */
class Entry_Example {

  @Test
  void iterate_forEach_MapEntry() {
    final Map<String, String> map = new HashMap<>();
    map.put("Key-0", "Value-0");
    map.put("Key-1", "Value-1");
    map.put("Key-2", "Value-2");
    map.put("Key-3", "Value-3");
    map.put("Key-4", "Value-4");
    map.put("Key-5", "Value-5");
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }

  @Test
  void iterate_while_MapEntry() {
    final Map<String, String> map = new HashMap<>();
    map.put("Key-0", "Value-0");
    map.put("Key-1", "Value-1");
    map.put("Key-2", "Value-2");
    map.put("Key-3", "Value-3");
    map.put("Key-4", "Value-4");
    map.put("Key-5", "Value-5");
    final Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, String> entry = it.next();
      System.out.println(entry.getKey() + " = " + entry.getValue());
    }
  }

  @Test
  void iterate_forEach_java8() {
    final Map<String, String> map = new HashMap<>();
    map.put("Key-0", "Value-0");
    map.put("Key-1", "Value-1");
    map.put("Key-2", "Value-2");
    map.put("Key-3", "Value-3");
    map.put("Key-4", "Value-4");
    map.put("Key-5", "Value-5");
    map.forEach((key, value) -> System.out.println(key + " = " + value));
  }
}
