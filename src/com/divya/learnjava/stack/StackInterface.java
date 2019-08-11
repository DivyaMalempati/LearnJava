package com.divya.learnjava.stack;

/**
 * This is a Data Structure Interface that provides Last In First Out behavior
 * 
 * @author divya
 *
 * @param <T>
 */
public interface StackInterface<T> {

	/**
	 * Inserts an element that will be deleted at First
	 * 
	 * @param element
	 */
	public void push(T element);

	/**
	 * Deletes the last Inserted Element
	 * 
	 * @return element
	 */
	public T pop();

	/**
	 * Returns the number of elements inserted
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Checks if the Stack is Empty
	 * 
	 * @return true when Empty /false when not Empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the Last Inserted Element
	 * 
	 * @return element
	 */
	public T peek();

}
