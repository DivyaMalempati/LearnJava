package com.divya.learnjava.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoStackImplementationTest {

	@Test
	public void twoStacksImplementation() {
		TwoStackImplementation stack = new TwoStackImplementation(10);
		Boolean head = true, tail = false;
		assertTrue(stack.isEmpty(head));
		assertFalse(stack.isFullstack());
		assertEquals(0, stack.size(head));
		stack.push(head, 0);
		stack.push(head, 10);
		stack.push(tail, 90);
		assertEquals(90, stack.peek(tail));
		assertEquals(10, stack.peek(head));
		stack.push(head, 20);
		stack.push(head, 30);
		stack.push(tail, 80);
		stack.push(tail, 70);
		stack.push(tail, 60);
		assertEquals((Integer) 60, stack.pop(tail));
		stack.push(head, 40);
		stack.push(head, 50);
		stack.push(tail, 60);
		assertThrows(RuntimeException.class, () -> {
			stack.push(head, 60);
		});
		assertEquals((Integer) 50, stack.pop(head));
		assertEquals((Integer) 40, stack.pop(head));
		assertEquals((Integer) 30, stack.pop(head));
		assertEquals((Integer) 20, stack.pop(head));
		assertEquals((Integer) 10, stack.pop(head));
		assertEquals((Integer) 0, stack.pop(head));
		assertThrows(RuntimeException.class, () -> {
			stack.pop(head);
		});
	}
}
