package com.divya.java.util;

import java.util.ArrayList;

public class ArrayListImpl extends ArrayList<Integer> {
	private static int INITIAL_ARRAY_CAPACITY = 10;
	private int[] array;
	private int numberOfElementsInArray;

	public ArrayListImpl() {
		this(INITIAL_ARRAY_CAPACITY);
	}

	public ArrayListImpl(int initialSize) {
		array = new int[initialSize];
		numberOfElementsInArray = 0;
	}

	public boolean add(int element) {
		doubleArraySizeIfNeeded();
		array[numberOfElementsInArray++] = element;
		return true;
	}

	private void doubleArraySize() {
		int[] newArray = new int[array.length * 2];
		for (int index = 0; index < numberOfElementsInArray; index++) {
			newArray[index] = array[index];
		}
		array = newArray;
	}

	private void doubleArraySizeIfNeeded() {
		if (numberOfElementsInArray == array.length) {
			doubleArraySize();
		}
	}

	public Integer remove() {
		if (!isEmpty()) {
			return remove(numberOfElementsInArray - 1);
		}
		throw new RuntimeException("Array is Empty");
	}

	public Integer remove(int index) {
		if (!isEmpty()) {
			int elementRemoved = array[index];
			if (index != array.length - 1) {
				shiftElements(index, array);
			} else {
				numberOfElementsInArray--;
			}
			reduceArraySizeIfNeeded();
			return elementRemoved;
		}
		throw new RuntimeException("Array is Empty");
	}

	private void shiftElements(int index, int[] array) {
		for (int shiftIndex = index; shiftIndex < numberOfElementsInArray; shiftIndex++) {
			array[shiftIndex] = array[shiftIndex + 1];
		}
		numberOfElementsInArray--;
	}

	private void reduceArraySizeIfNeeded() {
		if (numberOfElementsInArray <= array.length / 2) {
			reduceArraySize();
		}
	}

	private void reduceArraySize() {
		int[] newArray = new int[array.length / 2];
		for (int index = 0; index < numberOfElementsInArray; index++) {
			newArray[index] = array[index];
		}
		array = newArray;
	}

	public boolean isEmpty() {
		if (numberOfElementsInArray == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return numberOfElementsInArray;
	}

	int arraySize() {
		return array.length;
	}

	public void printArray() {
		System.out.print("[");
		for (int index = 0; index < numberOfElementsInArray; index++) {
			System.out.print(array[index]);
			if (index < numberOfElementsInArray - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}
