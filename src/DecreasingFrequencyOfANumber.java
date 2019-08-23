import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DecreasingFrequencyOfANumber {
	public void decreasingFrequency(int[] array) {
		boolean[] booleanArray = new boolean[array.length];
		int[] countArray = new int[array.length];
		int[] elementArray = new int[array.length];
		for (int index = 0; index < array.length; index++) {
			if (!booleanArray[index]) {
				int count = 1;
				for (int nextIndex = index + 1; nextIndex < array.length; nextIndex++) {
					if (array[index] == array[nextIndex]) {
						booleanArray[nextIndex] = true;
						++count;
					}
				}
				// System.out.println(" Value " + array[index] + "Index : " + index + " count "
				// + count);
				countArray[index] = count;
				elementArray[index] = array[index];
			}
		}
		// printArray(booleanArray);
		// printIntArray(elementArray);
		// printIntArray(countArray);
		sortCountArray(countArray, elementArray);
		printArray(array, countArray, elementArray);
	}

	private void printIntArray(int[] elementArray) {
		System.out.print("[");
		for (int i : elementArray) {
			System.out.print(i + ",");
		}
		System.out.println("]");
	}

	private void printArray(boolean[] booleanArray) {
		System.out.print("[");
		for (boolean i : booleanArray) {
			System.out.print(i + ",");
		}

	}

	private void printArray(int[] array, int[] countArray, int[] elementArray) {
		System.out.print("[");
		for (int index = 0; index < array.length; index++) {
			int count = countArray[index];
			while (count != 0) {
				System.out.print(elementArray[index] + ",");
				count--;

			}
		}
		System.out.println("]");
	}

	private void sortCountArray(int[] countArray, int[] elementArray) {
		printIntArray(elementArray);
		for (int index = 0; index < countArray.length; index++) {
			for (int nextIndex = index + 1; nextIndex < countArray.length; nextIndex++) {
				if (countArray[index] < countArray[nextIndex]) {
					swapElements(countArray, index, nextIndex);
					swapElements(elementArray, index, nextIndex);
				}
			}
		}
		printIntArray(elementArray);
	}

	private void swapElements(int[] countArray, int index, int nextIndex) {
		int temp = countArray[index];
		countArray[index] = countArray[nextIndex];
		countArray[nextIndex] = temp;
	}

	public String frequencySortUsingMap(String s) {
		Map<Character, Integer> charCountMap = new HashMap<>();
		for (int index = 0; index < s.length(); index++) {
			if (!charCountMap.containsKey(s.charAt(index))) {
				int count = 1;
				for (int nextIndex = index + 1; nextIndex < s.length(); nextIndex++) {
					if (s.charAt(index) == s.charAt(nextIndex)) {
						++count;
					}
				}
				charCountMap.put(s.charAt(index), count);
			}
		}

		List<Pair> entryList = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			entryList.add(new Pair(entry.getValue(), entry.getKey()));
		}
		Collections.sort(entryList, Collections.reverseOrder());
		StringBuilder newString = new StringBuilder();
		for (Pair pair : entryList) {
			newString.append(pair);
		}
		return newString.toString();
	}

	public String frequencySort(String s) {
		int[] array = new int[256];
		for (int i : s.toCharArray()) {
			array[i]++;
		}
		List<Pair> entryList = new ArrayList<>();
		for (int index = 0; index < array.length; index++) {
			if (array[index] != 0) {
				entryList.add(new Pair(array[index], (char) index));
			}
		}
		Collections.sort(entryList, Collections.reverseOrder());
		StringBuilder newString = new StringBuilder();
		for (Pair pair : entryList) {
			newString.append(pair);
		}
		return newString.toString();
	}

	public int[] frequencySortUsingMapInteger(int[] array) {
		Map<Integer, Integer> countValueMap = new HashMap<>();
		for (int index = 0; index < array.length; index++) {
			int count = 1;
			if (!countValueMap.containsKey(array[index])) {
				for (int nextIndex = index + 1; nextIndex < array.length; nextIndex++) {
					if (array[index] == array[nextIndex]) {
						++count;
					}
				}
				countValueMap.put(array[index], count);
			}
		}
		List<Pair1> entryList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : countValueMap.entrySet()) {
			entryList.add(new Pair1(entry.getValue(), entry.getKey()));
		}
		Collections.sort(entryList, Collections.reverseOrder());

		for (int index = 0, arrayIndex = 0; index < entryList.size(); index++) {
			int count = entryList.get(index).sortKey;
			while (count-- > 0) {
				array[arrayIndex++] = entryList.get(index).object;
			}
		}

		return array;
	}

	static class Pair implements Comparable<Pair> {
		Integer sortKey;
		char object;

		public Pair(Integer value, char key) {
			sortKey = value;
			object = key;
		}

		@Override
		public int compareTo(Pair o) {
			if (sortKey > o.sortKey)
				return 1;
			else if (sortKey == o.sortKey) {
				return 0;
			}
			return -1;
		}

		@Override
		public String toString() {
			int count = sortKey;
			StringBuilder string = new StringBuilder();
			while (count-- > 0) {
				string.append(object);
			}
			return string.toString();
		}

	}

	static class Pair1 implements Comparable<Pair1> {
		Integer sortKey;
		Integer object;

		public Pair1(Integer value, Integer key) {
			sortKey = value;
			object = key;
		}

		@Override
		public int compareTo(Pair1 o) {
			if (sortKey > o.sortKey)
				return 1;
			else if (sortKey == o.sortKey) {
				return 0;
			}
			return -1;
		}

		@Override
		public String toString() {
			int count = sortKey;
			StringBuilder string = new StringBuilder();
			while (count-- > 0) {
				string.append(object);
				if (count != 0) {
					string.append(",");
				}
			}
			return string.toString();
		}

	}

	@Test
	public void stringFreq_Test() {
		assertEquals("eert", frequencySort("tree"));
		assertEquals("aaabbA", frequencySort("Abaaab"));
		assertEquals("aaacc", frequencySort("ccaaa"));
	}

	@Test
	public void integerFreq_Test() {
		assertArrayEquals(new int[] { 8, 8, 8, 2, 2, 5, 5, 6 },
				frequencySortUsingMapInteger(new int[] { 2, 5, 2, 8, 5, 6, 8, 8 }));
	}

}
