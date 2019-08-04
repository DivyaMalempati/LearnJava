package com.divya.learnjava;

public class LinkedListStack<T> {
	private StackNode<T> top;
	private int sizeOfTheStack;

	public LinkedListStack() {
		top = null;
		sizeOfTheStack = 0;
	}

	private static class StackNode<T> {
		StackNode<T> next;
		T element;

		public StackNode(T element) {
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
	public boolean push(T element) {
		StackNode<T> newNode = new StackNode<T>(element);
			newNode.next = top;
			top = newNode;
			sizeOfTheStack++;
			return true;
	}

	/**
	 * Always Delete Element at First
	 * 
	 * Time Complexity O(1)
	 * 
	 * @return The Deleted Element
	 * 
	 */
	public T pop() {
		StackNode<T> currentNode = top;
		T elementReturned = null;
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
	 * @return The Element On Top of the stack
	 */
	public T peek() {
		StackNode<T> currentNode = top;
		if (top != null) {
			return currentNode.element;
		}
		return null;
	}

	public boolean isEmpty() {
		return (top == null) ? true : false;
	}

	public int size() {
		return sizeOfTheStack;
	}
}
