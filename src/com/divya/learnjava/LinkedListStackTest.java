package com.divya.learnjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {
	LinkedListStack<Integer> linkedList = new LinkedListStack<>();

	@Test
	void linkedListStack_isEmpty_Test() {
		assertTrue(linkedList.isEmpty());
		assertTrue(linkedList.push(10));
		assertFalse(linkedList.isEmpty());
	}

	@Test
	void linkedList_PushPop_Test() {
		assertTrue(linkedList.isEmpty());
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.isEmpty());
		assertTrue(linkedList.push(20));
		assertTrue(linkedList.push(30));
		assertTrue(linkedList.push(40));
		assertEquals(3, linkedList.size());
	}
}
