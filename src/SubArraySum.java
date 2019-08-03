import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SubArraySum {
	public static int subArraySum(int[] nums, int k) {
		int count = 0;
		for (int index = 0; index < nums.length; index++) {
			int sum = 0;
			for (int nextIndex = index; nextIndex < nums.length; nextIndex++) {
				sum += nums[nextIndex];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	@Test
	public void subSum_Test() {
		assertEquals(3, subArraySum(new int[] { 2, 8, 5, 5, -1, 4, 6 }, 10));
		assertEquals(2, subArraySum(new int[] { 1, 1, 1 }, 2));
		assertEquals(6, subArraySum(new int[] { 0, 0, 0 }, 0));
		assertEquals(4, subArraySum(new int[] { 1, -1, 1, -1 }, 0));
	}
}
