package com.divya.learnjava;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.divya.learnjava.CircularLinkedList.CircularLinkedListNode;
import org.junit.jupiter.api.Test;

class CircularLinkedListTest {

	@Test
	public void circularLinkList_Test() {
		CircularLinkedList linkedList = new CircularLinkedList();
		CircularLinkedListNode a04 = new CircularLinkedListNode(null);
		CircularLinkedListNode a03 = new CircularLinkedListNode(a04);
		CircularLinkedListNode a02 = new CircularLinkedListNode(a03);
		CircularLinkedListNode a01 = new CircularLinkedListNode(a02);
		a04.next = a02;
		linkedList.head = a01;
		assertTrue(linkedList.isCircular().isCircular);
		assertEquals(4,linkedList.isCircular().countSlowPointerMoves);
		a04.next=null;
		assertFalse(linkedList.isCircular().isCircular);
		a04.next=a01;
		assertTrue(linkedList.isCircular().isCircular);
		assertEquals(5,linkedList.isCircular().countSlowPointerMoves);
		
	}

}
