package com.divya.learnjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.divya.learnjava.LinkedList.LinkedListNode;

class ReverseALinkedList {

	public static LinkedListNode reverseLinkedList(LinkedListNode head) {
		if (head == null) {
			return head;
		}
		LinkedListNode currentNode = head;
		LinkedListNode nextNode = currentNode.next;
		head.next = null;
		while (nextNode != null) {
			nextNode.printList();
			LinkedListNode newNextNextNode = nextNode.next;
			nextNode.next = currentNode;

			// Incrementing Logic
			currentNode = nextNode;
			nextNode = newNextNextNode;
		}

		return currentNode;
	}

	@Test
	public void reverseLinkedListTest() {
		assertArrayEquals(new Integer[] {}, ReverseALinkedList.reverseLinkedList(new LinkedList().getHead()).toArray());
		assertArrayEquals(new Integer[] { 1 },
				ReverseALinkedList.reverseLinkedList(new LinkedList(1).getHead()).toArray());
		assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 },
				ReverseALinkedList.reverseLinkedList(new LinkedList(1, 2, 3, 4, 5).getHead()).toArray());
	}
}