

public class SubArraySum {
	public static int subArraySum(int[] nums, int k) {
		int count = 0;
		for (int index = 0; index < nums.length; index++) {
			int sum = 0;
			for (int nextIndex = index; nextIndex < nums.length; nextIndex++) {
				sum += nums[nextIndex];
				if (sum == k) {
					count++;
					//System.out.println("Start"+index+"end"+nextIndex);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("Count : " + subArraySum(new int[] { 2, 8, 5, 5, -1, 4, 6 }, 10));
		System.out.println("Count : " + subArraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println("Count : " + subArraySum(new int[] { 0, 0, 0 }, 0));
	}
}



