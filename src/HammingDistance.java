import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		LinkedList<Boolean> xArray = new LinkedList<>();
		LinkedList<Boolean> yArray = new LinkedList<>();

		while (x > 0) {
			xArray.addFirst(x % 2 != 0);
			x /= 2;
		}
		while (y > 0) {
			yArray.addFirst(y % 2 != 0);
			y /= 2;
		}
		int count = 0;
		int remainingSize = Math.abs(xArray.size() - yArray.size());
		int copyRemainingSize = remainingSize;
		if (copyRemainingSize != 0) {
			if (xArray.size() < yArray.size()) {
				while (copyRemainingSize > 0) {
					xArray.addFirst(false);
					copyRemainingSize--;
				}
			} else {
				while (copyRemainingSize > 0) {

					yArray.addFirst(false);
					copyRemainingSize--;
				}
			}
		}
		int size = xArray.size() < yArray.size() ? xArray.size() : yArray.size();
		for (int xIndex = xArray.size() - 1, yIndex = yArray.size() - 1; size > 0; xIndex--, yIndex--) {
			if (xArray.get(xIndex) != yArray.get(yIndex)) {
				count++;
			}
			size--;
		}
		// if (remainingSize != 0) {
		// if (xArray.size() > yArray.size()) {
		// for (int index = remainingSize; index >= 0; index--) {
		// if (xArray.get(index) == true) {
		// count++;
		// }
		// }
		// } else {
		// for (int index = remainingSize; index >= 0; index--) {
		// if (yArray.get(index) == true) {
		// count++;
		// }
		// }
		// }
		// }
		return count;
	}

	private void printBoolArray(LinkedList<Boolean> array) {
		System.out.print("[");
		for (int index = 0; index < array.size(); index++) {
			if (array.get(index)) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			System.out.print(",");
		}
		System.out.println("]");
	}

	@Test
	public void hammingDistanceTest() {
		assertEquals(1, hammingDistance(0, 1));
		assertEquals(1, hammingDistance(4, 5));
		assertEquals(1, hammingDistance(4, 6));
		assertEquals(2, hammingDistance(4, 7));
		assertEquals(2, hammingDistance(4, 8));
		assertEquals(3, hammingDistance(4, 10));
		assertEquals(4, hammingDistance(100, 128));
	}
}