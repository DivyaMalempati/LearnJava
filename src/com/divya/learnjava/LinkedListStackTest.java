package com.divya.learnjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	@Test
	void LinkedListStack_isEmpty_Test() {
		LinkedListStack linkedList = new LinkedListStack();
		assertTrue(linkedList.isEmpty());
	}

}
