import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class FindDuplicateElementInArray {
	@Test(expected = RuntimeException.class)
	public void findDuplicate_EmptyArray_Test() {
		int[] array = {};
		findDuplicateElementInArray(array);
	}

	@Test(expected = RuntimeException.class)
	public void findDuplicate_SingleArray_Test() {
		int[] array = { 1 };
		assertEquals(1, findDuplicateElementInArray(array));
	}

	@Test
	public void findDuplicate_Array_Test() {
		assertDuplicateElements(new int[] { 1, 2, 3, 1, 4 }, 1);
		assertDuplicateElements(new int[] { 1, 1 }, 1);
		assertDuplicateElements(new int[] { 1, 2, 2 }, 2);
		assertDuplicateElements(new int[] { 1, 2, 3, 2 }, 2);
		assertDuplicateElements(new int[] { 1, 2, 3, 4, 6, 5, 7, 8, 9, 10, 6 }, 6);
		assertDuplicateElements(new int[] { 1, 2, 3, 4, 5, 5, 7, 8, 9, 10, 6 }, 5);
	}

	private void assertDuplicateElements(int[] array, int actualResult) {
		assertEquals(actualResult, findDuplicateElementInArray(array));
		assertEquals(actualResult, findingDuplicateElements(array));
	}

	public static int findDuplicateElementInArray(int[] array) {
		/*
		 * if its is specifically given one element then just find the sum of n numbers
		 * sumOfNNumbers=n*(n+1)/2 sum of the elements and subtract it to find
		 * extraElement = sum - sumOfNNumbers
		 */
		if (array.length == 0) {
			throw new RuntimeException("Empty Array");
		}
		if (array.length <= 1) {
			throw new RuntimeException("No Duplicates found");
		}
		int sum = 0, numberOfElements = ((array.length - 1) * array.length) / 2;
		for (int i : array) {
			sum += i;
		}
		int extraElement = sum - numberOfElements;
		return extraElement;
	}

	public static int findDuplicateInArray(int[] nums) {
		int temp = -1;
		/*
		 * If there are more than 1 duplicates the above doesn't work then just traverse
		 * and compare until you find a duplicate
		 * 
		 */
		if (nums.length != 0 && nums.length > 1) {
			for (int lastIndex = nums.length - 1; lastIndex >= 0; lastIndex--) {
				for (int beforeLastIndex = 0; beforeLastIndex < lastIndex; beforeLastIndex++) {
					if (nums[lastIndex] == nums[beforeLastIndex]) {
						temp = nums[lastIndex];
					}
				}
			}
		}
		return temp;
	}

	public int findingDuplicateElements(int[] array) {
	HashSet<Integer> storeAndSearchArray = new HashSet<Integer>();
		for (int index = 0; index < array.length; index++) {
			if (!storeAndSearchArray.contains(array[index])) {
				storeAndSearchArray.add(array[index]);
			} else {
				return array[index];
			}
		}
		return -1;
	}
}
