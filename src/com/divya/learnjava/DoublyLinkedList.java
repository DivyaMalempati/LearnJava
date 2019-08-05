package com.divya.learnjava;

public class DoublyLinkedList {
	private DoublyLinkedListNode head;
	private int sizeOfTheList;

	public DoublyLinkedList() {
		head = null;
		sizeOfTheList = 0;
	}

	private static class DoublyLinkedListNode {
		Integer element;
		DoublyLinkedListNode previous;
		DoublyLinkedListNode next;

		public DoublyLinkedListNode(Integer element) {
			this.element = element;
			previous = null;
			next = null;
		}
	}

	// Always Insert At First
	public boolean insertAtFirst(Integer element) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(element);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		sizeOfTheList++;
		return true;
	}

	public boolean insertAtLast(Integer element) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(element);
		DoublyLinkedListNode currentNode = head;
		if (isEmpty()) {
			head = newNode;
		} else {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			newNode.previous = currentNode;
			currentNode.next = newNode;
		}
		sizeOfTheList++;
		return true;
	}

	public Integer deleteAtFirst() {
		Integer elementDeleted = null;
		if (isEmpty()) {
			throw new RuntimeException("List Is Empty");
		} else {
			elementDeleted = head.element;
			head = head.next;
		}
		sizeOfTheList--;
		return elementDeleted;
	}

	public Integer deleteAtLast() {
		DoublyLinkedListNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		Integer elementDeleted = currentNode.element;
		currentNode.previous.next = null;
		sizeOfTheList--;
		return elementDeleted;

	}

	public Integer deleteAtIndex(int index) {
		if (index < 0 || index > sizeOfTheList) {
			throw new RuntimeException("Index Out of Bounds Exception");
		}
		Integer elementReturned = null;
		if (isEmpty()) {
			throw new RuntimeException("List is Empty");
		}
		int count = 0;
		if (index == 0) {
			return deleteAtFirst();
		}
		if (index == sizeOfTheList) {
			return deleteAtLast();
		}
		for (DoublyLinkedListNode currentNode = head; currentNode != null; currentNode = currentNode.next, count++) {
			if (index == count) {
				elementReturned = currentNode.element;
				currentNode.previous.next = currentNode.next;
				currentNode.next.previous = currentNode.previous;
				sizeOfTheList--;
			}
		}
		return elementReturned;

	}

	public void printDoublyLinkedList() {
		DoublyLinkedListNode currentNode = head;
		System.out.print("[");
		while (currentNode != null) {
			System.out.print(currentNode.element);
			currentNode = currentNode.next;
			if (currentNode != null) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		return sizeOfTheList;
	}
}
