package com.divya.learnjava;

import org.junit.jupiter.api.Test;

public class CircularLinkedList {
	CircularLinkedListNode head;

	static class CircularLinkedListResult {
		boolean isCircular;
		int countSlowPointerMoves;
	}

	static class CircularLinkedListNode {
		CircularLinkedListNode next;

		public CircularLinkedListNode(CircularLinkedListNode next) {
			super();
			this.next = next;
		}
	}

	public CircularLinkedListResult isCircular() {
		CircularLinkedListNode slowPointer = head;
		CircularLinkedListNode fastPointer = head;
		CircularLinkedListResult result= new CircularLinkedListResult();
		int countSlowPointerMoves = 1;
		while (slowPointer != null && fastPointer != null) {
			slowPointer = slowPointer.next;
			countSlowPointerMoves++;
			if (fastPointer.next != null) {
				fastPointer = fastPointer.next.next;
			} else {
				break;
			}
			if (slowPointer == fastPointer) {
				result.isCircular= true;
				result.countSlowPointerMoves=countSlowPointerMoves;
				return result;
			}
		}
		result.isCircular=false;
		return result;
	}
}
