package com.divya.learnjava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LinkedListQueueTest {

	@Test
	void LinkedList_queueTest() {
		LinkedListQueue listQueue = new LinkedListQueue();
		assertTrue(listQueue.isEmpty());
		listQueue.enQueue(10);
		listQueue.enQueue(20);
		listQueue.enQueue(30);
		listQueue.enQueue(40);
		assertFalse(listQueue.isEmpty());
		assertEquals((Integer) 10, listQueue.peek());
		assertEquals((Integer) 4, listQueue.size());
		assertEquals((Integer) 10, listQueue.deQueue());
		assertEquals((Integer) 3, listQueue.size());
		assertEquals((Integer) 20, listQueue.deQueue());
		assertEquals((Integer) 30, listQueue.deQueue());
		assertEquals((Integer) 40, listQueue.deQueue());
		assertThrows(RuntimeException.class, () -> {
			listQueue.peek();
		});
		assertThrows(RuntimeException.class, () -> {
			listQueue.deQueue();
		});
	}

}
