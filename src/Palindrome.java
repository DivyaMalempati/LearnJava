import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Palindrome {
	public boolean palindromeNumber(int x) {
		return isPalindrome(x) ? true : false;
	}

	public boolean isPalindrome(int x) {
		int reversed = 0, temp = x;
		if (x <= 0) {
			return false;
		}
		while (x != 0) {
			int dividend = x % 10;
			reversed = reversed * 10 + dividend;
			x = x / 10;
		}
		return (temp == reversed) ? true : false;
	}

	public String longestSubStringPalindrome(String string) {
		if (string.isEmpty() || string.length() == 1) {
			return string;
		}
		String resultPalindrome = "";
		for (int index = 0; index < string.length(); index++) {
			StringBuilder stringBuilder = new StringBuilder();
			StringBuilder possibleStrings = new StringBuilder();
			for (int nextIndex = index; nextIndex < string.length(); nextIndex++) {
				possibleStrings = stringBuilder.append(string.charAt(nextIndex));
				String isPalindromestring = possibleStrings.toString();
				if (isPalindromestring.length() > resultPalindrome.length()) {
					if (isStringPalindrome(isPalindromestring)) {
						resultPalindrome = isPalindromestring;
					}
				}
			}
		}
		return resultPalindrome;
	}

	public boolean isStringPalindrome(String amIPalindrome) {
		int length = amIPalindrome.length();
		if (amIPalindrome.isEmpty()) {
			return true;
		}
		String reverse = "";
		for (int index = length - 1; index >= 0; index--) {
			reverse += amIPalindrome.charAt(index);
		}
		if (amIPalindrome.equals(reverse)) {
			return true;
		}
		return false;
	}

	@Test
	public void longestPalinSub_Test() {
		assertThrows(NullPointerException.class, () -> {
			longestSubStringPalindrome(null);
		});
		assertEquals("", longestSubStringPalindrome(""));
		assertEquals(" ", longestSubStringPalindrome(" "));
		assertEquals("a", longestSubStringPalindrome("a"));
		assertEquals("a", longestSubStringPalindrome("ac"));
		assertEquals("bab", longestSubStringPalindrome("babad"));
		assertEquals("bb", longestSubStringPalindrome("cbbd"));
		assertEquals("racecarracecar", longestSubStringPalindrome("racecarracecar"));
	}

	@Test
	public void palindromeNumber_Test() {
		assertFalse(palindromeNumber(-1));
		assertTrue(palindromeNumber(1));
		assertTrue(palindromeNumber(121));
		assertFalse(palindromeNumber(1211));
	}
}