package com.divya.learnjava;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
	DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

	@Test
	void doublyLinkedList_IsEmpty_Test() {
		assertTrue(doublyLinkedList.isEmpty());
		assertTrue(doublyLinkedList.insertAtFirst(10));
		assertFalse(doublyLinkedList.isEmpty());
	}

	@Test
	void doublyLinkedList_insertAt_First_Last_Test() {
		assertTrue(doublyLinkedList.isEmpty());
		assertTrue(doublyLinkedList.insertAtFirst(10));
		doublyLinkedList.printDoublyLinkedList();
		assertTrue(doublyLinkedList.insertAtLast(20));
		doublyLinkedList.printDoublyLinkedList();
		assertTrue(doublyLinkedList.insertAtFirst(1));
		doublyLinkedList.printDoublyLinkedList();
		assertTrue(doublyLinkedList.insertAtLast(30));
		doublyLinkedList.printDoublyLinkedList();
	}

	@Test
	void doublyLinkedList_deleteAt_First_Null_Test() {
		doublyLinkedList_DeleteAtFirst_Test();
		assertThrows(RuntimeException.class, () -> {
			doublyLinkedList.deleteAtFirst();
		});
		doublyLinkedList.printDoublyLinkedList();

	}

	@Test
	void doublyLinkedList_DeleteAtFirst_Test() {
		assertTrue(doublyLinkedList.isEmpty());
		assertTrue(doublyLinkedList.insertAtFirst(10));
		assertEquals((Integer) 10, doublyLinkedList.deleteAtFirst());
	}

	@Test
	void doublyLinkedList_deleteAt_Last_Null_Test() {
		assertTrue(doublyLinkedList.isEmpty());
		assertTrue(doublyLinkedList.insertAtFirst(10));
		doublyLinkedList.printDoublyLinkedList();
		assertEquals((Integer) 10, doublyLinkedList.deleteAtFirst());
		doublyLinkedList.printDoublyLinkedList();
		assertTrue(doublyLinkedList.insertAtLast(20));
		doublyLinkedList.printDoublyLinkedList();
		assertTrue(doublyLinkedList.insertAtFirst(1));
		doublyLinkedList.printDoublyLinkedList();
		assertEquals((Integer) 20, doublyLinkedList.deleteAtLast());
		doublyLinkedList.printDoublyLinkedList();
		assertEquals(1, doublyLinkedList.size());
	}
}
