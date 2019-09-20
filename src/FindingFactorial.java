import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class FindingFactorial {
	int count = 0;
	Map<Integer, Long> array = new HashMap<>();

	public int factorialOfANumber(int number) {
		int temp = 1;
		while (number > 0) {
			temp *= number--;
		}
		return temp;
	}

	public long factorialUsingRecursion(int number) {
		count++;
		if (number == 0) {
			array.put(0, (long) 1);
			return (long) 1;
		}
		Long value;
		if (array.containsKey(number - 1)) {
			value = number * array.get(number - 1);

		} else {
			value = number * factorialUsingRecursion(number - 1);
		}
		array.put(number, value);
		return value;

	}

	@Test
	public void FactorialTest() {
		assertEquals(1, factorialOfANumber(0));
		assertEquals(120, factorialOfANumber(5));
		assertEquals(1, factorialUsingRecursion(0));
		assertEquals(6, factorialUsingRecursion(3));
		for (int index = 100; index >= 0; index--) {
			factorialUsingRecursion(index);
		}
		System.out.println(count);
		System.out.println(array);
	}
}
