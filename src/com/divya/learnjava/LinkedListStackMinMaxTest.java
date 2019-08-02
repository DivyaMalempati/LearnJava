package com.divya.learnjava;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackMinMaxTest {
	LinkedListStackMinMax linkedList = new LinkedListStackMinMax();

	@Test
	void minMax_IsEmpty_Test() {
		assertTrue(linkedList.isEmpty());
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 10, linkedList.peek());
		assertFalse(linkedList.isEmpty());
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.isEmpty());
	}

	@Test
	void minMax_MinValueTest() {
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.push(20));
		assertTrue(linkedList.push(30));
		assertTrue(linkedList.push(40));
		assertEquals((Integer) 20, linkedList.minStack.peek());
		assertEquals((Integer) 40, linkedList.pop());
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 10, linkedList.minStack.peek());
		assertTrue(linkedList.push(50));
		assertTrue(linkedList.push(5));
		assertEquals((Integer) 5, linkedList.minStack.peek());
		assertEquals((Integer) 5, linkedList.pop());
		assertEquals((Integer) 10, linkedList.minStack.peek());
		assertEquals(4, linkedList.size());
	}

	@Test
	void minMax_MaxValueTest() {
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.push(20));
		assertTrue(linkedList.push(30));
		assertTrue(linkedList.push(40));
		assertEquals((Integer) 40, linkedList.maxStack.peek());
		assertEquals((Integer) 40, linkedList.pop());
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 30, linkedList.maxStack.peek());
		assertTrue(linkedList.push(50));
		assertTrue(linkedList.push(5));
		assertTrue(linkedList.push(10));
		assertEquals((Integer) 50, linkedList.maxStack.peek());
		assertEquals(6, linkedList.size());
	}
}
