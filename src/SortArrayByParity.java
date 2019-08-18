import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortArrayByParity {
	public int[] sortArrayParity(int[] A) {
		int[] newArray = new int[A.length];
		int startLength = 0, endLength = newArray.length - 1;
		for (int index = 0; index < A.length; index++) {
			if (A[index] % 2 == 0) {
				newArray[startLength++] = A[index];
			} else {
				newArray[endLength--] = A[index];
			}
		}

		return newArray;
	}

	@Test
	public void sortArrayTest() {
		assertArrayEquals(new int[] { 2, 4, 1, 3 }, sortArrayParity(new int[] { 3, 2, 1, 4 }));
	}
}
