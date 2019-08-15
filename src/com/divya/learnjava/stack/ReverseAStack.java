package com.divya.learnjava.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class ReverseAStack {
	private Stack<Integer> tempStack = new Stack<>();
	private Integer tempTop = 0;

	public Stack<Integer> reverseStack(Stack<Integer> stack) {
		int correctELementCount = 0;
		if (!stack.isEmpty()) {
			while (correctELementCount < stack.size()) {
				tempTop = stack.pop();
				while (stack.size() - correctELementCount != 0) {
					tempStack.push(stack.pop());
				}
				stack.push(tempTop);
				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
				correctELementCount++;
			}
			return stack;
		} else {
			throw new RuntimeException("Stack is Empty");
		}
	}

	@Test
	public void reverseTest() {
		Stack<Integer> stack = new Stack<>();
		assertThrows(RuntimeException.class, () -> {
			reverseStack(stack);
		});
		stack.push(1);
		stack.push(2);
		Stack<Integer> reverseStack = new Stack<>();
		reverseStack.push(2);
		reverseStack.push(1);
		assertEquals(reverseStack, reverseStack(stack));

	}

}