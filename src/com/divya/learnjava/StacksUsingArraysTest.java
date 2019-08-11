package com.divya.learnjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StacksUsingArraysTest {

	@Test
	public void StacksUsingArrays_isEmpty_Test() {
		// List<StackInterface<Integer>> arrayOfStacks = new LinkedList<>();
		StackInterface<Integer> stacks = new StacksUsingArrays<>(0);
		stacks.push(10);
		assertEquals(1, stacks.size());
		assertFalse(stacks.isEmpty());
		 assertThrows(RuntimeException.class, () -> {
		 stacks.push(1);
		 });
		assertEquals((Integer) 10, stacks.pop());
		assertThrows(RuntimeException.class, () -> {
			stacks.pop();
		});
		assertTrue(stacks.isEmpty());
	}

}
