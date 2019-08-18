import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class reverseAnArray {
	public int[] reverse(int[] array) {
		for (int startIndex = 0, lastIndex = array.length - 1; startIndex <= lastIndex; startIndex++, lastIndex--) {
			int temp = array[startIndex];
			array[startIndex] = array[lastIndex];
			array[lastIndex] = temp;
		}
		return array;
	}

	public char[] reverseCharacterArray(char[] s) {
		int first = 0, last = s.length - 1;
		while (first < last) {
			char temp = s[first];
			s[first++] = s[last];
			s[last--] = temp;
		}
		return s;
	}

	@Test
	public void reverseTest() {
		assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, reverse(new int[] { 1, 2, 3, 4, 5 }));
		assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 }, reverse(new int[] { 1, 2, 3, 4, 5, 6 }));
	}

	@Test
	public void reverseCharacter_Test() {
		assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'H' },
				reverseCharacterArray(new char[] { 'H', 'e', 'l', 'l', 'o' }));

	}

}
