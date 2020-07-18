package com.ntthuat.data_structure;

import org.junit.jupiter.api.Test;

import java.util.*;

public class List_Example {

  @Test
  void test1() {
    List<String> list = new ArrayList<>();
    list.add("Value1");
    list.add("Value2");
    list.add("Value3");
    list.add("Value4");
    list.add("Value5");
  }

  @Test
  void test2() {
    LinkedList<String> list = new LinkedList<>();
    list.add("Value1");
    list.add("Value2");
    list.add("Value3");
    list.add("Value4");
    list.add("Value5");
  }
}
