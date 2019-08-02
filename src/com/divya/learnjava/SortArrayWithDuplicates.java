//delete this code

package com.divya.learnjava;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortArrayWithDuplicates {
	public static int[] sortArray(int[] array) {
		int sortedCountArray[] = new int[3];
		for (int value : array) {
			sortedCountArray[value] = sortedCountArray[value] + 1;
		}
		int sortedCount = 0;
		for (int index = 0; index < sortedCountArray.length; index++) {
			for (int maxNumberOfTimes = 0; maxNumberOfTimes < sortedCountArray[index]; maxNumberOfTimes++) {
				array[sortedCount++] = index;
			}
		}
		return array;
	}

	@Test
	public void sortArray_WithDuplicates_Test() {
		assertArrayEquals(new int[] { 0, 0, 1, 1, 1, 1, 2, 2 },
				SortArrayWithDuplicates.sortArray(new int[] { 1, 2, 1, 0, 1, 2, 0, 1 }));
	}

}