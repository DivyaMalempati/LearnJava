package com.divya.learnjava.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StackUtils {

	private StackUtils() {
	}

	public static <T> void reverseAStack(StackInterface<T> inputStack) {
		Stack<T> tempStack = new Stack<>();
		Stack<T> reverseStack = new Stack<>();
		while (!inputStack.isEmpty()) {
			tempStack.push(inputStack.pop());
		}
		while (!tempStack.isEmpty()) {
			reverseStack.push(tempStack.pop());
		}
		while (!reverseStack.isEmpty()) {
			inputStack.push(reverseStack.pop());
		}
	}

	public static <T> void reverseAStackUsingQueue(StackInterface<T> inputStack) {
		Queue<T> inputQueue = new LinkedList<>();
		while (!inputStack.isEmpty()) {
			inputQueue.add(inputStack.pop());
		}
		while (!inputQueue.isEmpty()) {
			inputStack.push(inputQueue.remove());
		}
	}

	@Test
	public void reverseAStack_Test() {
		List<StackInterface<Integer>> listOfStacks = new java.util.LinkedList<>();
		listOfStacks.add(new StacksUsingArrays<>(2));
		listOfStacks.add(new StackUsingArraysFromLast<>(2));
		listOfStacks.add(new LinkedListStackMinMax());
		for (StackInterface<Integer> stack : listOfStacks) {
			stack.push(10);
			stack.push(20);
			reverseAStackUsingQueue(stack);
			assertEquals((Integer) 10, stack.pop());
			assertEquals((Integer) 20, stack.pop());
			assertTrue(stack.isEmpty());
		}
	}

}
