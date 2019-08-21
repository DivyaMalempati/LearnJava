package com.divya.learnjava.stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class MissingParanthesisUsingStack {
	public boolean isValidParathesisExpression(String string) {
		Stack<Character> openParanthesisStack = new Stack<>();
		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) == '(') {
				openParanthesisStack.push('(');
			} else if (string.charAt(index) == ')') {
				if (openParanthesisStack.isEmpty()) {
					System.out.println("\"(\"is Missing.");
					return false;
				}
				Character charecterPopped = openParanthesisStack.pop();
				if (charecterPopped != '(') {
					System.out.println("Instead of Open Paranthesis found something" + charecterPopped);

					return false;
				}
			}
		}
		if (openParanthesisStack.size() == 0) {
			return true;
		} else {
			System.out.println("\")\" is Missing.");
			return false;
		}
	}

	@Test
	public void missingParanthesisTest() {
		assertFalse(isValidParathesisExpression("1+2)3+4*(5*6)"));
		assertTrue(isValidParathesisExpression("((1*2)+((2*3)*2)*3)"));
	}

}
