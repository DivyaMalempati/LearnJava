package com.divya.learnjava.stack;

public class StackUsingArraysFromLast<T> implements StackInterface<T> {
	private int top;
	private T[] array;

	public StackUsingArraysFromLast(int arraySize) {
		array = (T[]) new Object[arraySize];
		top = array.length;
	}

	@Override
	public void push(T element) {
		if (size() < array.length) {
			array[--top] = element;
		} else {
			throw new RuntimeException("Stack is Full");
		}
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			return array[top++];
		}
		throw new RuntimeException("Stack is Empty");
	}

	@Override
	public int size() {
		return array.length - top;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return array[top];
	}
}
