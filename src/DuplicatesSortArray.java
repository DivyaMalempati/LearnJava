import org.junit.jupiter.api.Test;

public class DuplicatesSortArray {
	public int[] findingDuplicateCount(int[] array) {
		int[] tempArray = new int[3];
		for (int index = 0; index < array.length; index++) {
			int value = array[index];
			tempArray[value] = tempArray[value] + 1;
		}
		for (int value : tempArray) {
			System.out.print(value + ",");
		}
		System.out.println();
		System.out.print("[");
		for (int index = 0; index < tempArray.length; index++) {
			int maxCountToPrint = tempArray[index], count = 0;
			while (count < maxCountToPrint) {
				System.out.print(index + ",");
				count++;
			}

		}
		System.out.println("]");
		return tempArray;
	}

	@Test
	public void findingDuplicate_Test() {
		findingDuplicateCount(new int[] { 0, 2, 1, 0, 2, 1, 0, 1, 0 });
	}
}
