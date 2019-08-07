import org.junit.jupiter.api.Test;

public class FindLeadersInAnArray {
	public void findLeadersInAnArray(int[] array) {
		for (int index = 0; index < array.length; index++) {
			if (ifIsLeaderTrue(index, array)) {
				System.out.println(array[index]);
			}
		}
		System.out.println();
	}

	private boolean ifIsLeaderTrue(int index, int[] array) {
		for (int startIndex = index + 1; startIndex < array.length; startIndex++) {
			if (array[index] < array[startIndex]) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void findLeader_Test() {
		findLeadersInAnArray(new int[] { 16, 17, 4, 3, 5, 2 });
		findLeadersInAnArray(new int[] { 20, 19, 18, 17, 16, 15, 14 });
		findLeadersInAnArray(new int[] { 1, 2, 3, 4, 5, 6 });
	}
}
