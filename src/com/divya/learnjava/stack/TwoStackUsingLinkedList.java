package com.divya.learnjava.stack;

import java.util.LinkedList;
import java.util.Queue;

public class TwoStackUsingLinkedList {
	private int[] topsArray;
	private Node[] array;
	private Queue<Integer> freeList;

	public TwoStackUsingLinkedList(int noOfStacks, int arraySize) {
		topsArray = new int[noOfStacks];
		for (int index = 0; index < topsArray.length; index++) {
			topsArray[index] = -1;
		}
		array = new Node[arraySize];
		freeList = new LinkedList<>();
		for (int index = 0; index < arraySize; index++) {
			freeList.add(index);
		}
	}

	private class Node {
		int previousIndex;
		Integer element;

		public Node(int element, int previousIndex) {
			this.previousIndex = previousIndex;
			this.element = element;
		}
	}

	public void push(int stackIndex, Integer element) {
		if (!isFull()) {
			Node newNode = new Node(element, topsArray[stackIndex]);
			int freeIndex = removeFreeIndex();
			array[freeIndex] = newNode;
			topsArray[stackIndex] = freeIndex;
		} else {
			throw new RuntimeException("Stack is Full");
		}
	}

	public Integer pop(int stackIndex) {
		if (!isEmpty(stackIndex)) {
			Node currentNode = array[topsArray[stackIndex]];
			Integer elementReturned = currentNode.element;
			freeList.add(topsArray[stackIndex]);
			topsArray[stackIndex] = currentNode.previousIndex;
			return elementReturned;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	private int peek(int stackIndex) {
		return array[topsArray[stackIndex]].element;
	}

	private boolean isEmpty(int stackIndex) {
		if (topsArray[stackIndex] == -1) {
			return true;
		}
		return false;
	}

	private int removeFreeIndex() {
		return freeList.remove();
	}

	private boolean isFull() {
		return freeList.isEmpty();
	}

}
