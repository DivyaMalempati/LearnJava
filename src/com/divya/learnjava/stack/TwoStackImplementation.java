package com.divya.learnjava.stack;

import java.util.ArrayList;
import java.util.List;

public class TwoStackImplementation {
	private int top1;
	private int top2;
	private Integer[] array;

	public TwoStackImplementation(int arraySize) {
		array = new Integer[arraySize];
		top1 = -1;
		top2 = array.length;
	}

	public void push(boolean stackNumber, Integer element) {
		if (!isFullstack()) {
			if (stackNumber) {
				array[++top1] = element;
			} else {
				array[--top2] = element;
			}
		} else {
			throw new RuntimeException("Stack is Full");
		}
	}

	public Integer pop(boolean stackNumber) {
		int elementReturned = peek(stackNumber);
		if (stackNumber) {
			top1--;
		} else {
			top2++;
		}
		return elementReturned;
	}

	public int peek(boolean stackNumber) {
		if (!isEmpty(stackNumber)) {
			if (stackNumber) {
				return array[top1];
			} else {
				return array[top2];
			}
		} else {
			throw new RuntimeException("Stack is Empty");
		}

	}

	public boolean isEmpty(boolean stackNumber) {
		if (stackNumber) {
			if (size(stackNumber) == 0) {
				return true;
			}
		}
		return false;
	}

	public int size(boolean stackNumber) {
		if (stackNumber) {
			return top1 + 1;
		} else {
			return array.length - top2;
		}
	}

	protected boolean isFullstack() {
		return (array.length == size(true) + size(false)) ? true : false;
	}
}
