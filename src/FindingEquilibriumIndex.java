import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FindingEquilibriumIndex {
	/**
	 * Equilibrium index of an array is an index such that the sum of elements at
	 * lower indexes is equal to the sum of elements at higher indexes. </br>
	 * @
	 * Time Complexity O(n^2) </br>
	 * @param array
	 * @return Index if present or -1
	 */
	public static int findEquilibriumIndexBruteForce(int[] array) {
		for (int index = 0; index < array.length; index++) {
			boolean isTrue = isEquilibriumIndex(index, array);
			if (isTrue) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * Equilibrium Index function Returns if the index is equilibrium index
	 * 
	 * @param index
	 * @param array
	 * @return true/false if the index
	 */
	private static boolean isEquilibriumIndex(int index, int[] array) {
		int leftSum = 0, rightSum = 0;
		for (int startIndex = 0; startIndex < index; startIndex++) {
			leftSum += array[startIndex];
		}
		for (int startIndex = index + 1; startIndex < array.length; startIndex++) {
			rightSum += array[startIndex];
		}
		return (leftSum == rightSum);
	}

	/**
	 * Equilibrium index of an array is an index such that the sum of elements at
	 * lower indexes is equal to the sum of elements at higher indexes.</br>
	 * Time Complexity O(n) </br>
	 * 
	 * @param array
	 * @return
	 */
	private static int findEquilibriumIndex(int[] array) {
		int totalSum = 0;
		for (int value : array) {
			totalSum += value;
		}
		int index = 0;
		int oldLeftSum = 0;
		int oldRightSum = totalSum - array[0];
		for (index = 1; index < array.length; index++) {
			oldLeftSum += array[index - 1];// -7
			oldRightSum -= array[index];// 6
			System.out.println("LeftSum :" + oldLeftSum + " RightSum :" + oldRightSum);
			if (oldLeftSum == oldRightSum) {
				return index;
			}
		}
		return -1;
	}

	@Test
	public void findingEquilibrium_BruteForce_Test() {
		assertEquals(3, findEquilibriumIndexBruteForce(new int[] { -7, 1, 5, 2, -4, 3, 0 }));
		// assertEquals(-1, findEquilibriumIndexBruteForce(new int[] { 0, 1, 2, 3, 4, 5,
		// 6, 7, 8 }));
	}

	@Test
	public void findingEquilibrium_Test() {
		assertEquals(3, findEquilibriumIndex(new int[] { -7, 1, 5, 2, -4, 3, 0 }));
	}

	@Test
	public void findingEquilibrium_False_Test() {
		assertEquals(-1, findEquilibriumIndexBruteForce(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }));

	}
}
