package com.divya.learnjava.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class LinkedListStackMinMaxTest {
	LinkedListStackMinMax linkedList = new LinkedListStackMinMax();

	@Test
	void minMax_IsEmpty_Test() {
		assertTrue(linkedList.isEmpty());
		linkedList.push(10);
		assertEquals((Integer) 10, linkedList.peek());
		assertFalse(linkedList.isEmpty());
		assertEquals((Integer) 10, linkedList.pop());
		assertTrue(linkedList.isEmpty());
	}

	@Test
	void minMax_MinValueTest() {
		linkedList.push(10);
		assertEquals((Integer) 10, linkedList.pop());
		linkedList.push(20);
		linkedList.push(30);
		linkedList.push(40);
		assertEquals((Integer) 20, linkedList.minValueInStack());
		assertEquals((Integer) 40, linkedList.pop());
		linkedList.push(10);
		assertEquals((Integer) 10, linkedList.minValueInStack());
		linkedList.push(50);
		linkedList.push(5);
		assertEquals((Integer) 5, linkedList.minValueInStack());
		assertEquals((Integer) 5, linkedList.pop());
		assertEquals((Integer) 10, linkedList.minValueInStack());
		assertEquals(4, linkedList.size());
	}

	@Test
	void minMax_MaxValueTest() {
		linkedList.push(10);
		assertEquals((Integer) 10, linkedList.pop());
		linkedList.push(20);
		linkedList.push(30);
		linkedList.push(40);
		assertEquals((Integer) 40, linkedList.maxValueInStack());
		assertEquals((Integer) 40, linkedList.pop());
		linkedList.push(10);
		assertEquals((Integer) 30, linkedList.maxValueInStack());
		linkedList.push(50);
		linkedList.push(5);
		linkedList.push(10);
		assertEquals((Integer) 50, linkedList.maxValueInStack());
		assertEquals(6, linkedList.size());
	}

	@Test
	void minMax_duplicates_Test() {
		linkedList.push(1);
		linkedList.push(1);
		linkedList.push(1);
		linkedList.push(1);
		System.out.println("Min Size: " + linkedList.minStack.size() + "MaxStack : " + linkedList.maxStack.size());
		assertEquals((Integer) 1, linkedList.minValueInStack());
		assertEquals((Integer) 1, linkedList.maxValueInStack());
		assertEquals((Integer) 1, linkedList.pop());
		System.out.println("Min Size: " + linkedList.minStack.size() + "MaxStack : " + linkedList.maxStack.size());
		assertEquals((Integer) 1, linkedList.minValueInStack());
		assertEquals((Integer) 1, linkedList.maxValueInStack());
		assertEquals((Integer) 1, linkedList.pop());
		System.out.println("Min Size: " + linkedList.minStack.size() + "MaxStack : " + linkedList.maxStack.size());
		assertEquals((Integer) 1, linkedList.minValueInStack());
		assertEquals((Integer) 1, linkedList.maxValueInStack());
		assertEquals((Integer) 1, linkedList.pop());
		System.out.println("Min Size: " + linkedList.minStack.size() + "MaxStack : " + linkedList.maxStack.size());
		assertEquals((Integer) 1, linkedList.minValueInStack());
		assertEquals((Integer) 1, linkedList.maxValueInStack());
		assertEquals((Integer) 1, linkedList.pop());
		System.out.println("Min Size: " + linkedList.minStack.size() + "MaxStack : " + linkedList.maxStack.size());
		assertEquals((Integer) 1, linkedList.minValueInStack());
		assertEquals((Integer) 1, linkedList.maxValueInStack());

	}
}
