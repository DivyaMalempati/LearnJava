import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sound.midi.MidiChannel;

import org.junit.Test;

public class FindElementAppearingOnceSortedArray {

	@Test
	public void findElement_OneElement_SuccessTest() {
		int[] array = { 1 };
		assertEquals(1, findElementAppearingOnce(array));
	}

	@Test
	public void findElement_Mid_SuccessTest() {
		int[] array = { 1, 1, 3, 3, 4, 6, 6, 7, 7 };
		assertEquals(4, findElementAppearingOnce(array));
	}

	@Test
	public void findElement_Last_SuccessTest() {
		int[] array = { 1, 1, 2 };
		assertEquals(2, findElementAppearingOnce(array));
	}

	@Test(expected = RuntimeException.class)
	public void findElement_Even_SuccessTest() {
		int[] array = { 1, 1, 2, 2 };
		findElementAppearingOnce(array);
	}

	@Test
	public void findElement_Left_SuccessTest() {
		int[] array = { 1, 1, 3, 4, 4, 6, 6, 7, 7 };
		assertEquals(3, findElementAppearingOnce(array));
	}

	@Test
	public void findElement_Right_SuccessTest() {
		int[] array = { 1, 1, 3, 3, 4, 4, 5, 6, 6, 7, 7 };
		assertEquals(5, findElementAppearingOnce(array));
	}

	public static int findElementAppearingOnce(int[] array) {
		System.out.println(array.length);
		int startIndex = 0, endIndex = array.length - 1;
		if (array.length % 2 == 0) {
			throw new RuntimeException("Expected Odd Array Size");
		}
		if (array.length == 1) {
			return array[startIndex];
		}
		while (startIndex <= endIndex) {
			if (startIndex == endIndex) {
				return array[startIndex];
			}
			System.out.println("StartIndex" + startIndex + " EndIndex :" + endIndex);
			int midIndex = (int) Math.floor((startIndex + endIndex) / 2);
			System.out.println("MidIndex" + midIndex);
			if (array[midIndex] != array[midIndex - 1] && array[midIndex] != array[midIndex + 1]) {
				return array[midIndex];
			}
			if ((midIndex % 2 == 0 && array[midIndex] == array[midIndex + 1])
					|| (midIndex % 2 == 1 && array[midIndex] == array[midIndex - 1])) {
				startIndex = midIndex + 1;
			} else {
				endIndex = midIndex - 1;
			}
		}
		return -1;
	}

}