package com.divya.learnjava;

public class LinkedListQueue {
	private QueueNode head;
	private QueueNode tail;
	private int sizeOfTheQueue;

	public LinkedListQueue() {
		head = null;
		tail = null;
		sizeOfTheQueue = 0;
	}

	private static class QueueNode {
		QueueNode next;
		Integer element;

		QueueNode(int element) {
			this.element = element;
			next = null;
		}
	}

	/**
	 * Always Insert At Last
	 * 
	 * Time Complexity is O(1)
	 * 
	 * @param element
	 * @return true/false based on insertion
	 */
	public boolean enQueue(Integer element) {
		QueueNode newNode = new QueueNode(element);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		sizeOfTheQueue++;
		return true;
	}

	/**
	 * Always Delete First Inserted Element
	 * 
	 * Time Complexity is O(1)
	 * 
	 * @return the deletedElement
	 * @throws {@link
	 *             RuntimeException} when Queue is Empty.
	 */
	public Integer deQueue() {
		Integer deletedElement = null;
		if (head == null) {
			throw new RuntimeException("Queue is Empty. ");
		}
		deletedElement = head.element;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		sizeOfTheQueue--;
		return deletedElement;
	}

	/**
	 * This function returns the first Inserted Element
	 * 
	 * Time Complexity is O(1)
	 * 
	 * @return First Element
	 * @throws {@link
	 *             RuntimeException} When the Queue is empty
	 */
	public Integer peek() {
		if (head != null) {
			return head.element;
		}
		throw new RuntimeException("Queue is Empty. ");
	}

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public Integer size() {
		return sizeOfTheQueue;
	}
}
