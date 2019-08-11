package com.divya.learnjava.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class StacksGenericInterfaceTest {

	@Test
	public void genericStackOperationsInterfacesTest() {
		List<StackInterface<Integer>> listOfStacks = new java.util.LinkedList<>();
		listOfStacks.add(new StacksUsingArrays<>(1));
		listOfStacks.add(new StackUsingArraysFromLast<>(1));
		listOfStacks.add(new LinkedListStackMinMax());
		for (StackInterface<Integer> stacks : listOfStacks) {
			assertThrows(RuntimeException.class, () -> {
				stacks.peek();
			});
			stacks.push(10);
			assertEquals((Integer) 10, stacks.peek());
			assertEquals(1, stacks.size());
			assertFalse(stacks.isEmpty());
			assertEquals((Integer) 10, stacks.pop());
			assertThrows(RuntimeException.class, () -> {
				stacks.pop();
			});
			assertTrue(stacks.isEmpty());
		}
	}

	@Test
	public void stacksWithLimitedSizeTest() {
		List<StackInterface<Integer>> stacks = new java.util.LinkedList<>();
		stacks.add(new StacksUsingArrays<>(2));
		stacks.add(new StackUsingArraysFromLast<>(2));
		for (StackInterface<Integer> stack : stacks) {
			stack.push(10);
			stack.push(20);
			assertThrows(RuntimeException.class, () -> {
				stack.push(30);
			});
		}
	}
}
