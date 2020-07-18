package com.ntthuat.data_structure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Stack_From_Multiple_Queue {

  @Test
  void test_Stack() {
    final Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertEquals(Integer.valueOf(3), stack.pop());
    assertEquals(Integer.valueOf(2), stack.pop());
    assertEquals(Integer.valueOf(1), stack.pop());
  }
  
  @Test
  void test_Queue() {
    final Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    assertEquals(Integer.valueOf(1), queue.poll());
    assertEquals(Integer.valueOf(2), queue.poll());
    assertEquals(Integer.valueOf(3), queue.poll());
  }

  private Queue<Integer> queue1 = new LinkedList<>();
  private Queue<Integer> queue2 = new LinkedList<>();

  @Test
  void test_Stack_From_Multiple_Queue() {
    push(1);
    push(2);
    push(3);
    push(4);
    push(5);

    assertEquals(Integer.valueOf(5), pop());
    push(6);
    push(7);
    assertEquals(Integer.valueOf(7), pop());
    assertEquals(Integer.valueOf(6), pop());
    assertEquals(Integer.valueOf(4), pop());
    assertEquals(Integer.valueOf(3), pop());
    assertEquals(Integer.valueOf(2), pop());
    assertEquals(Integer.valueOf(1), pop());
    assertEquals(null, pop());
  }

  private void push(Integer i) {
    if (queue1.size() == 0) {
      queue2.add(i);
    } else {
      queue1.add(i);
    }
  }

  private Integer pop() {
    if (queue1.size() == 0 && queue2.size() == 0) {
      return null;
    }
    if (queue1.size() > queue2.size()) {
      while (queue1.size() > 1) {
        Integer value = queue1.poll();
        queue2.add(value);
      }

      return queue1.poll();
    } else {
      while (queue2.size() > 1) {
        Integer value = queue2.poll();
        queue1.add(value);
      }
      return queue2.poll();
    }
  }
}
