import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AddToArrayFormInteger {
	public List<Integer> addToArrayForm(int[] A, int K) {
		StringBuilder sb = new StringBuilder();
		for (Integer integer : A) {
			sb = sb.append(integer);
		}
		BigInteger number = new BigInteger(sb.toString());
		BigInteger KBI = new BigInteger("" + K);
		number = number.add(KBI);
		LinkedList<Integer> list = new LinkedList<>();
		for (char digit : number.toString().toCharArray()) {
			list.add(Integer.valueOf("" + digit));
		}
		return list;
	}

	public List<Integer> addToArrayIntForm(int[] array, int K) {
		StringBuilder sb = new StringBuilder();
		for (int i : array) {
			sb.append(i);
		}
		Integer value = new Integer(sb.toString());
		value += K;
		LinkedList<Integer> list = new LinkedList<>();
		while (value > 0) {
			int div = value % 10;
			list.addFirst(div);
			value /= 10;
		}
		return list;
	}

	@Test
	public void addIntegerTest() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(9);
		assertEquals(list, addToArrayIntForm(new int[] { 1, 2, 3 }, 6));
	}

	@Test
	public void addBigIntegerTest() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(9);
		assertEquals(list, addToArrayForm(new int[] { 1, 2, 3 }, 6));
	}
}
