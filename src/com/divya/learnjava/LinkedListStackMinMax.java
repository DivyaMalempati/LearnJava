package com.divya.learnjava;

import com.divya.learnjava.LinkedListStack;

public class LinkedListStackMinMax extends LinkedListStack<Integer> {
	LinkedListStack<Integer> minStack;
	LinkedListStack<Integer> maxStack;

	public LinkedListStackMinMax() {
		minStack = new LinkedListStack<>();
		maxStack = new LinkedListStack<>();
	}

	static class ElementInfo {
		Integer element;
		int count;

	}

	@Override
	public boolean push(Integer element) {

		if (isEmpty()) {
			minStack.push(element);
			maxStack.push(element);
		} else {
			if (element < minStack.peek()) {
				minStack.push(element);
			} else if (element == minValueInStackPeek()) {
				minStack.pop();
				minStack.push(element);
			}
			if (element > maxStack.peek()) {
				maxStack.push(element);
			} else if (element == maxStack.peek()) {
				maxStack.pop();
				maxStack.push(element);
			}
		}
		return super.push(element);
	}

	@Override
	public Integer pop() {
		int elementDeleted = super.pop();
		if (!isEmpty()) {
			if (elementDeleted == minValueInStackPeek()) {
				minStack.pop();
			} else if (elementDeleted == maxValueInStackPeek()) {
				maxStack.pop();
			}
		}
		return elementDeleted;
	}

	private Integer minValueInStackPeek() {
		return minStack.peek();
	}

	private Integer maxValueInStackPeek() {
		return maxStack.peek();
	}

	@Override
	public Integer peek() {
		return super.peek();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public int size() {
		return super.size();
	}
}
