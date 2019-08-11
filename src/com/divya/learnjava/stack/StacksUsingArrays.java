package com.divya.learnjava.stack;

public class StacksUsingArrays<T> implements StackInterface<T> {
	/**
	 * Given to implement stacks on arrays using</br>
	 * push() pop() size() isEmpty()
	 */
	int top;
	T[] array;

	public StacksUsingArrays(int arraySize) {
		top = -1;
		array = (T[]) new Object[arraySize];
	}

	@Override
	public void push(T element) {
		if (size() < array.length) {
			array[++top] = element;
		} else {
			throw new RuntimeException("Stack is Full.");
		}
	}

	@Override
	public T pop() {
		if (size() != 0) {
			T element = array[top--];
			return element;
		}
		throw new RuntimeException("Stack Is Empty.");
	}

	@Override
	public int size() {
		return top + 1;
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
			throw new RuntimeException("Stack is Empty.");
		}
		return array[top];
	}

}
