package com.divya.learnjava;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.awt.List;

import org.junit.jupiter.api.Test;

/**
 * Definition for singly-linked list. </br>
 * public class ListNode </br>
 * { int val; </br>
 * ListNode next;</br>
 * ListNode(int x) {</br>
 * val = x;</br>
 * }</br>
 * }
 */
public class MergeSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeLists(ListNode l1, ListNode l2) {
		ListNode tempNode = new ListNode(-1), currL1 = l1, currL2 = l2, res = tempNode;
		ListNode newNode;
		for (; currL1 != null && currL2 != null;) {
			if (currL1.val <= currL2.val) {
				newNode = new ListNode(currL1.val);
				tempNode.next = newNode;
				tempNode = tempNode.next;
				currL1 = currL1.next;
			} else {
				newNode = new ListNode(currL2.val);
				tempNode.next = newNode;
				tempNode = tempNode.next;
				currL2 = currL2.next;
			}
		}
		while (currL1 != null) {
			newNode = new ListNode(currL1.val);
			tempNode.next = newNode;
			tempNode = tempNode.next;
			currL1 = currL1.next;
		}
		while (currL2 != null) {
			newNode = new ListNode(currL2.val);
			tempNode.next = newNode;
			tempNode = tempNode.next;
			currL2 = currL2.next;
		}
		// System.out.print("[");
		// res = res.next;
		// for (; res != null; res = res.next) {
		// System.out.print(res.val);
		// if (res != null) {
		// System.out.print(",");
		// }
		// }
		// System.out.println("]");
		return res.next;
	}

	public int[] mergeArray(int[] array1, int[] array2) {
		int[] newArray = new int[array1.length + array2.length];
		int newArrayIndex = 0, firstIndex = 0, secondIndex = 0;
		for (; firstIndex < array1.length && secondIndex < array2.length; newArrayIndex++) {
			if (array1[firstIndex] <= array2[secondIndex]) {
				newArray[newArrayIndex] = array1[firstIndex++];
			} else {
				newArray[newArrayIndex] = array2[secondIndex++];
			}
		}
		while (firstIndex < array1.length) {
			newArray[newArrayIndex++] = array1[firstIndex++];
		}
		while (secondIndex < array2.length) {
			newArray[newArrayIndex++] = array2[secondIndex++];
		}
		return newArray;
	}

	public int[] mergeInPlace(int[] array1, int size1, int[] array2, int size2) {
		int inPlaceIndex = array1.length;
		for (; size2 > 0;) {
			if (size1 > 0 && array1[size1 - 1] > array2[size2 - 1]) {
				array1[--inPlaceIndex] = array1[--size1];
			} else {
				array1[--inPlaceIndex] = array2[--size2];
			}
		}
		return array1;
	}

	private ListNode mergeKSortedLists(ListNode[] lists) {
		ListNode tempNode = lists[0];
		for (int index = 1; index < lists.length; index++) {
			tempNode = mergeLists(tempNode, lists[index]);
		}
		return tempNode;
	}

	@Test
	public void merge_arrayTest() {
		int[] newArray = new int[] { 10, 15, 20, 25, 30, 40, 60 };
		assertArrayEquals(newArray, mergeArray(new int[] { 10, 20, 30 }, new int[] { 15, 25, 40, 60 }));
		// assertArrayEquals(newArray, mergeInPlace(new int[] { 10, 20, 30 }, 3, new
		// int[] { 15, 25, 40, 60 }, 4));
	}

	@Test
	public void merge_inPlaceArray_Test() {
		int[] newArray = new int[] { 5, 10, 20, 25, 30, 40, 60 };
		assertArrayEquals(newArray,
				mergeInPlace(new int[] { 10, 20, 30, 0, 0, 0, 0 }, 3, new int[] { 5, 25, 40, 60 }, 4));
	}

	@Test
	public void merge_listTest() {
		ListNode l1 = new ListNode(10);
		ListNode l11 = new ListNode(20);
		l1.next = l11;
		ListNode l2 = new ListNode(15);
		ListNode l21 = new ListNode(25);
		l2.next = l21;
		// l2.next.next.val = 40;
		// l2.next.next.next.val = 60;
		ListNode mergedList = new ListNode(10);
		ListNode mergedList1 = new ListNode(15);
		ListNode mergedList2 = new ListNode(20);
		ListNode mergedList3 = new ListNode(25);
		mergedList.next = mergedList1;
		mergedList1.next = mergedList2;
		mergedList2.next = mergedList3;
		// assertEquals(mergedList, mergeLists(l1, l2));
	}

	@Test
	public void merKListsTest() {

	}
}
