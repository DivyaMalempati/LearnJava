package com.divya.learnjava.stack;

public class LinkedListStack<T> implements StackInterface<T> {
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
	@Override
	public void push(T element) {
		StackNode<T> newNode = new StackNode<T>(element);
		newNode.next = top;
		top = newNode;
		sizeOfTheStack++;
	}

	/**
	 * Always Delete Element at First
	 * 
	 * Time Complexity O(1)
	 * 
	 * @return The Deleted Element
	 * 
	 */
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		T elementReturned = null;
		elementReturned = top.element;
		top = top.next;
		sizeOfTheStack--;
		return elementReturned;
	}

	/**
	 * Peek Is a function to see the top most element in the stack
	 * 
	 * Time Complexity is O(1)
	 * 
	 * @return The Element On Top of the stack
	 */
	@Override
	public T peek() {
		StackNode<T> currentNode = top;
		if (top != null) {
			return currentNode.element;
		}
		throw new RuntimeException("Stack is Empty");
	}

	@Override
	public boolean isEmpty() {
		return (top == null) ? true : false;
	}

	@Override
	public int size() {
		return sizeOfTheStack;
	}
}
