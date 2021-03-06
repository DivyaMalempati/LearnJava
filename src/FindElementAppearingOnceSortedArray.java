import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sound.midi.MidiChannel;

import org.junit.Test;

public class FindElementAppearingOnceSortedArray {

	@Test(expected=RuntimeException.class)
	public void findElement_ZeroElement_SuccessTest() {
		int[] array = {  };
		findElementAppearingOnce(array);
	}

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
		int startIndex = 0, endIndex = array.length - 1;
		
		if (array.length % 2 == 0) {
			throw new RuntimeException("Odd Array Length Expected");
		}
		while (startIndex <= endIndex) {
			if (startIndex == endIndex) {
				return array[startIndex];
			}
			int midIndex = (int) Math.floor((startIndex + endIndex) / 2);
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
