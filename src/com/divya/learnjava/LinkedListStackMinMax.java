package com.divya.learnjava;

public class LinkedListStackMinMax extends LinkedListStack<Integer> {
	LinkedListStack<ElementInfo> minStack;
	LinkedListStack<ElementInfo> maxStack;

	public LinkedListStackMinMax() {
		minStack = new LinkedListStack<>();
		maxStack = new LinkedListStack<>();
	}

	/**
	 * A Class to keep track of duplicate elements count whenever an element is
	 * inserted in stack
	 * 
	 * @author DivyaMalempati
	 *
	 */
	static class ElementInfo {
		private Integer element;
		int count;

		public ElementInfo(Integer element) {
			this.element = element;
			count = 1;
		}

	}

	/**
	 * <br>
	 * Time Complexity O(1)<br>
	 */
	@Override
	public boolean push(Integer element) {
		if (isEmpty()) {
			minStack.push(new ElementInfo(element));
			maxStack.push(new ElementInfo(element));
		} else {
			if (element < minValueInStack()) {
				minStack.push(new ElementInfo(element));
			} else if (element == minValueInStack()) {
				minStack.peek().count += 1;
			}
			if (element > maxValueInStack()) {
				maxStack.push(new ElementInfo(element));
			} else if (element == maxValueInStack()) {
				maxStack.peek().count += 1;
			}
		}
		return super.push(element);
	}

	/**
	 * This method returns the Maximum value at the top of the Max stack <br>
	 * Time Complexity O(1)<br>
	 * 
	 * @return Element
	 * 
	 */
	public Integer maxValueInStack() {
		return maxStack.peek().element;
	}

	/**
	 * This method returns the Minimum value at the top of the Minimum stack<br>
	 * Time Complexity O(1) <br>
	 * 
	 * @return Element
	 */
	public Integer minValueInStack() {
		return minStack.peek().element;
	}

	/**
	 * Always Delete Element at First from Stack.<br>
	 * Time Complexity O(1) <br>
	 * 
	 * @return Element
	 */
	@Override
	public Integer pop() {
		Integer elementDeleted = super.pop();
		if (!isEmpty()) {
			if (elementDeleted == minValueInStack()) {
				minStack.peek().count -= 1;
				if (minStack.peek().count == 0) {
					minStack.pop();
				}
			}
			if (elementDeleted == maxValueInStack()) {
				maxStack.peek().count -= 1;
				if (maxStack.peek().count == 0) {
					maxStack.pop();
				}
			}
		}
		return elementDeleted;
	}

	/**
	 * Peek Is a function to see the top most element in the stack<br>
	 * Time Complexity is O(1) <br>
	 * 
	 * @return Element
	 */
	@Override
	public Integer peek() {
		return super.peek();
	}

	/**
	 * Checks If the Stack is Empty
	 * 
	 * @return true/false
	 */
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	/**
	 * 
	 * 
	 * @return Size of the Stack
	 */
	@Override
	public int size() {
		return super.size();
	}
}
