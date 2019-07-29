import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SearchAnElement {
	@Test
	public void searchAnElement_NullArray_Test() {
		assertEquals(-1, searchAnElementWithAdjacentOneDiff(2, new int[] {}));
	}

	@Test
	public void searchAnElement_StartElement_Test() {
		assertEquals(0, searchAnElementWithAdjacentOneDiff(0, new int[] { 0, 1, 2, 1, 2, 3 }));
	}

	@Test
	public void searchAnElement_LastElement_Test() {
		assertEquals(5, searchAnElementWithAdjacentOneDiff(3, new int[] { 0, 1, 2, 1, 2, 3 }));
	}

	@Test
	public void searchAnElement_MidElements_Test() {
		assertEquals(2, searchAnElementWithAdjacentOneDiff(2, new int[] { 0, 1, 2, 1, 2, 3 }));
		assertEquals(2, searchAnElementWithAdjacentOneDiff(6, new int[] { 8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 }));
	}

	public int searchAnElementWithAdjacentOneDiff(int element, int[] array) {
		int startIndex = 0, endIndex = array.length - 1;
		for (int index = 0; index <= endIndex; index++) {
			if (array[startIndex] == element && Math.abs(array[startIndex + 1] - element) == 1) {
				return startIndex;
			}
			if (index == endIndex && array[endIndex] == element && Math.abs(array[endIndex - 1] - element) == 1) {
				return endIndex;
			}
			if (array[index] == element && Math.abs(array[index + 1] - element) == 1
					&& Math.abs(array[index - 1] - element) == 1) {
				return index;
			}
		}
		return -1;
	}

}