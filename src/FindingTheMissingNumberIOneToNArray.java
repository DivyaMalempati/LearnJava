import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FindingTheMissingNumberIOneToNArray {
	public int missingNumber(int[] nums) {
		int sumOfNNumbers = nums.length * (nums.length + 1) / 2, sumOfArray = 0;
			for (int index = 0; index < nums.length; index++) {
				sumOfArray += nums[index];
			}
		return sumOfNNumbers - sumOfArray;
	}

	@Test
	public void missingNumber_Test() {
		assertEquals(2, missingNumber(new int[] {3,0,1}));
		assertEquals(8, missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		assertEquals(1, missingNumber(new int[] {0}));
	}
}