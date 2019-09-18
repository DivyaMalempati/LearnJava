package com.divya.learnjava;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.divya.learnjava.LinkedList.LinkedListNode;

class ReverseALinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

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

	public ListNode reverseList(ListNode head) {
		ListNode currNode = head;
		ListNode previousNode = null;
		while (currNode != null) {
			ListNode temp = currNode.next;
			currNode.next = previousNode;
			previousNode = currNode;
			currNode = temp;
		}
		return previousNode;
	}

	private void printList(ListNode currNode) {
		while (currNode != null) {
			System.out.println(currNode.val);
			currNode = currNode.next;
		}
	}

	public ListNode reverseListBetween(ListNode head, int m, int n) {
		ListNode currNode = head;
		if (m == 1) {
			return reverseListTillN(currNode, n - m + 1);
		}
		// ListNode reverseNode = new ListNode(-1);
		int count = 1;
		while (currNode != null) {

			if (count == m - 1) {
				currNode.next = reverseListTillN(currNode.next, n - m + 1);
				break;
			}
			++count;
			currNode = currNode.next;
		}
		return head;
	}

	private ListNode reverseListTillN(ListNode currNode, int count) {
		ListNode previousNode = null;
		ListNode oldCurrNode = currNode;
		ListNode nextNode = currNode.next;
		while (count-- > 0) {
			nextNode = currNode.next;
			currNode.next = previousNode;
			previousNode = currNode;
			currNode = nextNode;
		}
		oldCurrNode.next = nextNode;
		return previousNode;
	}

	@Test
	public void reverseListBetween_Test() {
		ListNode node = new ListNode(10);
		ListNode node1 = new ListNode(20);
		node.next = node1;
		ListNode node2 = new ListNode(30);
		node1.next = node2;
		ListNode node3 = new ListNode(40);
		node2.next = node3;
		ListNode node4 = new ListNode(50);
		node3.next = node4;
		ListNode reversedNode = reverseListBetween(node,1,1);
		printList(reversedNode);
		// ListNode reversedHead = reverseListTillN(node, 2);
		// printList(reversedHead);
	}

	@Test
	public void reverse_ListTest() {
		ListNode node = new ListNode(10);
		ListNode node1 = new ListNode(20);
		node.next = node1;
		ListNode node2 = new ListNode(30);
		node1.next = node2;
		ListNode node3 = new ListNode(40);
		node2.next = node3;

		ListNode reverseHeadNode = new ListNode(40);
		ListNode node5 = new ListNode(30);
		reverseHeadNode.next = node5;
		ListNode node6 = new ListNode(20);
		node5.next = node6;
		ListNode node7 = new ListNode(10);
		node6.next = node7;

		ListNode actualReverseHeadNode = reverseList(node);
		compareTwoLists(reverseHeadNode, actualReverseHeadNode);
		actualReverseHeadNode = reverseList(null);
		compareTwoLists(null, actualReverseHeadNode);
	}

	private void compareTwoLists(ListNode reverseHeadNode, ListNode actualReverseHeadNode) {
		ListNode originalNode = reverseHeadNode, actualNode = actualReverseHeadNode;
		for (; originalNode != null
				&& actualNode != null; originalNode = originalNode.next, actualNode = actualNode.next) {
			assertEquals(originalNode.val, actualNode.val);
		}
		assertNull(actualNode);
		assertNull(originalNode);
	}

	@Test
	public void reverseLinkedListTest() {
		assertNull(ReverseALinkedList.reverseLinkedList(new LinkedList().getHead()));
		assertArrayEquals(new Integer[] { 1 },
				ReverseALinkedList.reverseLinkedList(new LinkedList(1).getHead()).toArray());
		assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 },
				ReverseALinkedList.reverseLinkedList(new LinkedList(1, 2, 3, 4, 5).getHead()).toArray());
	}
}