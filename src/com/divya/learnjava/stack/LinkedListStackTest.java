package com.divya.learnjava.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {
	LinkedListStack<Integer> linkedList = new LinkedListStack<>();

	@Test
	void linkedListStack_isEmpty_Test() {
		assertTrue(linkedList.isEmpty());
		linkedList.push(10);
		assertFalse(linkedList.isEmpty());
	}

	@Test
	void linkedList_PushPop_Test() {
		assertTrue(linkedList.isEmpty());
		linkedList.push(10);
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.isEmpty());
		linkedList.push(20);
		linkedList.push(30);
		linkedList.push(40);
		assertEquals(3, linkedList.size());
	}
}
