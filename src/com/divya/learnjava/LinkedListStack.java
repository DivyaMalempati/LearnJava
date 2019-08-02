package com.divya.learnjava;

public class LinkedListStack {
	private StackNode top;
	private int sizeOfTheStack;

	public LinkedListStack() {
		top = null;
		sizeOfTheStack = 0;
	}

	private static class StackNode {
		StackNode next;
		Integer element;

		public StackNode(Integer element) {
			this.element = element;
			this.next = null;
		}
	}

	/**
	 * Always add Element at first
	 * 
	 * Time Complexity O(1)
	 * 
	 * @param element
	 * @return true/false after insertion
	 */
	public boolean push(Integer element) {
		StackNode newNode = new StackNode(element);
		if (top != null) {
			newNode.next = top;
			top = newNode;
			sizeOfTheStack++;
			return true;
		}
		return false;
	}

	/**
	 * Always Delete Element at First
	 * 
	 * Time Complexity O(1)
	 * 
	 * @return Deleted Element
	 * 
	 */
	public Integer pop() {
		StackNode currentNode = top;
		Integer elementReturned = -1;
		if (top != null) {
			elementReturned = currentNode.element;
			top = currentNode.next;
			sizeOfTheStack--;
		}
		return elementReturned;
	}

	/**
	 * Peek Is a function to see the top most element in the stack
	 * 
	 * Time Complexity is O(1)
	 * 
	 * @return The Element
	 */
	public Integer peek() {
		StackNode currentNode = top;
		if (top != null) {
			return currentNode.element;
		}
		return -1;
	}

	public boolean isEmpty() {
		return (top == null) ? true : false;
	}
	
	public Integer size() {
		return sizeOfTheStack;
	}
}
