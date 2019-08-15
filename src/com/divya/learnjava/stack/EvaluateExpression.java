package com.divya.learnjava.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class EvaluateExpression {
	public Integer evaluatingExpression(String expressionToEvaluate) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		for (char character : expressionToEvaluate.toCharArray()) {
			if (character == '+') {
				evaluatingStack(operandStack, operatorStack);
				operatorStack.push(character);
			} else if (character == '*') {
				operatorStack.push(character);
			} else if (Character.isDigit(character)) {
				operandStack.push(Character.digit(character, 10));
			} else {
				throw new RuntimeException("Unknown Operand or Operator is given" + character);
			}
		}
		evaluatingStack(operandStack, operatorStack);
		return operandStack.pop();
	}

	private void evaluatingStack(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		while (!operatorStack.isEmpty()) {
			if (operatorStack.peek() == '+') {
				operandStack.push(operandStack.pop() + operandStack.pop());
				operatorStack.pop();
			} else if (operatorStack.peek() == '*') {
				operandStack.push(operandStack.pop() * operandStack.pop());
				operatorStack.pop();
			} else {
				throw new RuntimeException("Unknown Operand or Operator is given");
			}
		}
	}

	@Test
	public void evaluatingStack_test() {
		assertEquals((Integer) 38, evaluatingExpression("1+2*3+4*6+7*1"));
		assertEquals((Integer) 6, evaluatingExpression("2*3"));
		assertThrows(RuntimeException.class, () -> {
			evaluatingExpression("1+2*3+4*6+7*1/");
		});
	}
}
