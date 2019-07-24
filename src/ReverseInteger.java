import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1: 
 * Input: 123 Output: 321
 * 
 * Example 2:
 * Input: -123 Output: -321
 * 
 * Example 3:
 * Input: 120 Output: 21
 * 
 * Note: Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−2^31, 2^31 − 1]. For the
 * purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 */
public class ReverseInteger {
	@Test
	public void ReverseInteger_Positive_Test() {
		assertEquals(321, reverse(123));
	}

	@Test
	public void ReverseInteger_Negative_Test() {
		assertEquals(-321, reverse(-123));
	}

	@Test
	public void ReverseInteger_BigNumber_Test() {
		assertEquals(-987654321,reverse(-123456789));
	}
	
	public int reverse(int num) {
		
		// Handling negative numbers
		boolean negativeFlag = false;
		if (num < 0) {
			negativeFlag = true;
			num = -num;
		}

		int reversed = 0, prev_rev_num = 0;
		while (num != 0) {
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			if ((reversed - digit) / 10 != prev_rev_num) {
				System.out.println("WARNING OVERFLOWED!!!");
				return 0;
			}

			prev_rev_num = reversed;

			num = num / 10;
		}
		return (negativeFlag == true) ? -reversed : reversed;
	}
}