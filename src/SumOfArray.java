import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SumOfArray {
	int count = 0;

	private int sumOfArrayRecursion(int[] array, int start, int end) {
		count++;
		if (end > start) {
			return array[start] + sumOfArrayRecursion(array, start + 1, end);
		}
		return array[start];
	}

	public int sum(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		return sumOfArrayRecursion(array, 0, array.length - 1);
	}

	public int maximumNumberRecursion(int[] array, int start, int end) {
		if (start == end) {
			return array[start];
		}
		int currentValue = array[start];
		int restToCompare = maximumNumberRecursion(array, start + 1, end);
		if (currentValue > restToCompare) {
			return currentValue;
		} else {
			return restToCompare;
		}
	}

	@Test
	public void sumTest() {
		assertEquals(0, sum(new int[] {}));
		assertEquals(6, sum(new int[] { 1, 2, 3 }));
		assertEquals(10, sum(new int[] { 1, 2, 3, 4 }));
		System.out.println(count);
	}

	public String fractionDecimal(int numerator, int denominator) {
		StringBuilder resultString = new StringBuilder();
		double quotient = (double) numerator / denominator;
		boolean isResultSame = isExact(quotient, numerator, denominator);
		/**
		 * Rewrite this code
		 * 
		 */
		
		if (!isResultSame) {
			System.out.println("Not Same " + quotient);
		} else {
			System.out.println("Same " + quotient);
		}
		StringBuilder newString = new StringBuilder("0.");

		if (resultString.length() > 6) {
			char value = resultString.charAt(3);
			newString.append("(" + value + ")\"");
			return new String("\"" + newString.toString());
		}

		return new String("\"" + resultString.toString() + "\"");
	}

	private boolean isExact(double quotient, int numerator, int denominator) {
		double newNumerator = (double) quotient * denominator;
		// System.out.println(newNumerator);
		if (newNumerator == numerator) {
			return true;
		}
		return false;
	}

	@Test
	public void maximumNumber() {
		assertEquals(65, maximumNumberRecursion(new int[] { 51, 65, 3, 7, 27, 49 }, 0, 5));
	}

	@Test
	public void fractionDecimalTest() {
		System.out.println(fractionDecimal(1, 2));
		System.out.println(fractionDecimal(2, 3));
		System.out.println(fractionDecimal(2, 1));
		System.out.println(fractionDecimal(333, 4));
	}

}
