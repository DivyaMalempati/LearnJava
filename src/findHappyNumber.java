import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class findHappyNumber {
	public boolean isHappy(int number) {
		int sumOfSquares = 0;
		HashSet<Integer> sumOfSquareValues = new HashSet<>();
		while (sumOfSquares != 1) {
			sumOfSquares = 0;
			while (number != 0) {
				sumOfSquares += ((int) Math.pow((double) number % 10, 2));
				number = number / 10;
			}
			if (sumOfSquareValues.contains(sumOfSquares)) {
				return false;
			} else {
				sumOfSquareValues.add(sumOfSquares);
			}
			number = sumOfSquares;
		}
		return true;
	}

	@Test
	public void isHappyTest() {
		assertFalse(isHappy(0));
		assertTrue(isHappy(19));
		assertFalse(isHappy(119));
		assertFalse(isHappy(1192));
	}
}
