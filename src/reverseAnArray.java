import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

	public String reverseAString(String string) {
		StringBuilder reverseString = new StringBuilder();
		for (int index = string.length() - 1; index >= 0; index--) {
			reverseString.append(string.charAt(index));
		}
		return reverseString.toString();
	}

	public String reverseWords(String s) {
		if (s.length() == 0) {
			return s;
		}
		String[] wordsString = new String[s.length()];
		wordsString = s.split(" ");
		StringBuilder returnString = new StringBuilder();
		for (int index = 0; index < wordsString.length; index++) {
			wordsString[index] = reverseAString(wordsString[index]);
		}
		for (int index = 0; index < wordsString.length; index++) {
			returnString.append(wordsString[index]);
			if (index != wordsString.length - 1) {
				returnString.append(" ");
			}
		}

		return returnString.toString();
	}

	public String reverseStringBasedOnIndex(String s, int k) {
		int count = k, stringCount = s.length();
		StringBuilder reverseString = new StringBuilder();
		while (count < s.length()) {
			for (int index = count - 1; index >= 0; index--) {
				reverseString.append(s.charAt(index));
				stringCount++;
			}
			System.out.println(reverseString.toString());
			for (int index = count; index < 2 * k; index++) {
				reverseString.append(s.charAt(index));
				stringCount++;
			}

			System.out.println(reverseString.toString());
			count++;
			count = 2 * k;
		}
		return reverseString.toString();
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

	@Test
	public void reverseStringTest() {
		assertEquals("", reverseAString(""));
		assertEquals("olleh", reverseAString("hello"));
		assertEquals("olleH", reverseAString("Hello"));
	}

	@Test
	public void reverseWordsTest() {
		assertEquals("", reverseWords(""));
		assertEquals("olleh i ma taerg", reverseWords("hello i am great"));
	}

	@Test
	public void reverseStringIndex_Test() {
		assertEquals("bacdfeg", reverseStringBasedOnIndex("abcdefg", 2));
	}

}
