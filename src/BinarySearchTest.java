import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	@Test
	public void validateSearch() {
		assertFalse(searchAnElementUsingBinarySearch(new int[] {}, 1));
		assertTrue(searchAnElementUsingBinarySearch(new int[] { 1 }, 1));
		assertTrue(searchAnElementUsingBinarySearch(new int[] { 1, 2, 3, 4 }, 2));
		assertFalse(searchAnElementUsingBinarySearch(new int[] { 1, 2, 4, 5, 10 }, 3));
		assertFalse(searchAnElementUsingBinarySearch(new int[] { 1, 2, 3, 4 }, 0));
	}

	public static boolean searchAnElementUsingBinarySearch(int[] array, int element) {
		int startIndex = 0, endIndex = array.length - 1;
		// Base conditions
		if (array.length == 0 || element < array[startIndex] || element > array[endIndex]) {
			return false;
		}

		while (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			if (array[startIndex] == element || array[midIndex] == element || array[endIndex] == element) {
				return true;
			}
			if (element < array[midIndex]) {
				endIndex = midIndex - 1;
			} else if (element > array[midIndex]) {
				startIndex = midIndex + 1;
			}
		}
		return false;
	}
}