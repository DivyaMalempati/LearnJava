package com.divya.java.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListImpl implements List<Integer> {
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

	/**
	 * Appends the specified element to the end of this list
	 * 
	 * @param <b>element</b>
	 *            element to be appended to this list
	 * @return true
	 */
	@Override
	public boolean add(Integer element) {
		doubleArraySizeIfNeeded();
		array[numberOfElementsInArray++] = element;
		return true;
	}

	/**
	 * double Array Size when number of elements in a array reach length</br>
	 * 
	 */
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

	/**
	 * remove the element at specified index
	 * 
	 * @param index
	 * 
	 * @return <b>element</b> element to be deleted
	 */
	@Override
	public Integer remove(int index) {
		if (!isEmpty()) {
			int elementRemoved = array[index];
			if (index != array.length - 1) {
				shiftElementsRightToRemove(index, array);
			} else {
				numberOfElementsInArray--;
			}
			reduceArraySizeIfNeeded();
			return elementRemoved;
		}
		throw new RuntimeException("Array is Empty");
	}

	private void shiftElementsRightToRemove(int index, int[] array) {
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

	/**
	 * first occurrence of the element to be removed from Array
	 * 
	 * @param <b>element</b>
	 *            element to be removed
	 * @return <b>true</b> if this list contains the specified element
	 */
	public boolean remove(Integer element) {
		if (contains(element)) {
			remove(getIndex(element));
		}
		return false;
	}

	private int getIndex(Object element) {
		for (int index = 0; index < numberOfElementsInArray; index++) {
			if ((Integer) element == array[index]) {
				return index;
			}
		}
		throw new RuntimeException("Cant find an Element");
	}

	/**
	 * Returns true if this list contains the specified element.</br>
	 * 
	 * @param <b>element</br>
	 *            element whose presence in this list is to be tested
	 * @return <b>true</b> if this list contains the specified element
	 */
	@Override
	public boolean contains(Object element) {
		for (int index = 0; index < numberOfElementsInArray; index++) {
			if (array[index] == (Integer) element) {
				return true;
			}
		}
		return false;
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

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return :a string representation of the object.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("[");
		for (int index = 0; index < numberOfElementsInArray; index++) {
			string.append(array[index]);
			if (index < numberOfElementsInArray - 1) {
				string.append(",");
			}
		}
		string.append("]");
		return string.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if (contains(o)) {
			remove(getIndex(o));
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param :index
	 *            index of the element to return
	 * @return :the element at the specified position in this list
	 */
	@Override
	public Integer get(int index) {
		if (index < numberOfElementsInArray) {
			return array[index];
		}
		return null;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param: index
	 *             index of the element to replace </br>
	 *             element element to be stored at the specified position
	 * @return: the element previously at the specified position
	 */
	@Override
	public Integer set(int index, Integer element) {
		if (index < size()) {
			int elementReplaced = array[index];
			array[index] = element;
			return elementReplaced;
		}
		throw new RuntimeException("Array Index Out Of Bounds");
	}

	/**
	 * Inserts the specified element at the specified position in this list(optional
	 * operation).</br>
	 * Shifts the element currently at that position(if any) and any subsequent
	 * elements to the right (adds one to their indices).</br>
	 * 
	 * @param: index
	 *             index at which the specified element is to be inserted element
	 *             element to be inserted
	 */
	@Override
	public void add(int index, Integer element) {
		doubleArraySizeIfNeeded();
		shiftElementsRightToInsert(index);
		set(index, element);
		numberOfElementsInArray++;
		System.out.println(this);
	}

	private void shiftElementsRightToInsert(int index) {
		for (int shiftIndex = numberOfElementsInArray - 1; shiftIndex >= index; shiftIndex--) {
			array[shiftIndex + 1] = array[shiftIndex];
		}
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Integer> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Integer> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
