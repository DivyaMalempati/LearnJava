import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PracticeArraysTest {

	@Test
	void isArrayPalindromeTest() {
		assertTrue(PracticeArrays.isArrayPalindrome(new int[] { 1 }));
		assertTrue(PracticeArrays.isArrayPalindrome(new int[] { 1, 2, 1 }));
		assertTrue(PracticeArrays.isArrayPalindrome(new int[] { 1, 2, 2, 1 }));
		assertTrue(PracticeArrays.isArrayPalindrome(new int[] { 1, 2, 3, 3, 2, 1 }));
		assertFalse(PracticeArrays.isArrayPalindrome(new int[] { 1, 2 }));
		assertFalse(PracticeArrays.isArrayPalindrome(new int[] { 1, 2, 3 }));
		assertFalse(PracticeArrays.isArrayPalindrome(new int[] { 1, 2, 3, 2 }));

	}

	@Test
	void splitArrayIntoTwoTest() {
		PracticeArrays.TwoGenericObjects<Integer[], Integer[]> splitArrayIntoTwo = PracticeArrays
				.splitArrayIntoTwo(new int[] {});
		assertEquals(0, splitArrayIntoTwo.getFirst().length);
		assertEquals(0, splitArrayIntoTwo.getSecond().length);
		splitArrayIntoTwo = PracticeArrays.splitArrayIntoTwo(new int[] { 58 });
		assertEquals(1, splitArrayIntoTwo.getFirst().length);
		assertEquals(0, splitArrayIntoTwo.getSecond().length);
		splitArrayIntoTwo = PracticeArrays.splitArrayIntoTwo(new int[] { 58, 24 });
		assertEquals(1, splitArrayIntoTwo.getFirst().length);
		assertEquals(1, splitArrayIntoTwo.getSecond().length);
		splitArrayIntoTwo = PracticeArrays.splitArrayIntoTwo(new int[] { 58, 24, 13 });
		assertEquals(2, splitArrayIntoTwo.getFirst().length);
		assertEquals(1, splitArrayIntoTwo.getSecond().length);
		splitArrayIntoTwo = PracticeArrays.splitArrayIntoTwo(new int[] { 58, 24, 13, 15 });
		assertEquals(2, splitArrayIntoTwo.getFirst().length);
		assertEquals(2, splitArrayIntoTwo.getSecond().length);
	}

	@Test
	void largestAndSmallestElementOfAnArrayTest() {
		PracticeArrays.TwoGenericObjects<Integer, Integer> largestAndSmallestElementOfAnArray = PracticeArrays
				.largestAndSmallestElementOfAnArray(new int[] { 1 });
		assertEquals(1, largestAndSmallestElementOfAnArray.getFirst().intValue());
		assertEquals(1, largestAndSmallestElementOfAnArray.getSecond().intValue());
		largestAndSmallestElementOfAnArray = PracticeArrays.largestAndSmallestElementOfAnArray(new int[] { 2, 24, 90 });
		assertEquals(90, largestAndSmallestElementOfAnArray.getFirst().intValue());
		assertEquals(2, largestAndSmallestElementOfAnArray.getSecond().intValue());
		largestAndSmallestElementOfAnArray = PracticeArrays
				.largestAndSmallestElementOfAnArray(new int[] { 100, 2, 81 });
		assertEquals(100, largestAndSmallestElementOfAnArray.getFirst().intValue());
		assertEquals(2, largestAndSmallestElementOfAnArray.getSecond().intValue());

	}

	@Test
	void minMaxDifferenceInArrayTest() {
		PracticeArrays.TwoGenericObjects<Integer, Integer> minMaxDifferenceInArray = PracticeArrays
				.minMaxDifferenceInArray(new int[] { 1 });
		assertEquals(0, minMaxDifferenceInArray.getFirst().intValue());
		assertEquals(0, minMaxDifferenceInArray.getSecond().intValue());
		minMaxDifferenceInArray = PracticeArrays.minMaxDifferenceInArray(new int[] { 1, 2 });
		assertEquals(1, minMaxDifferenceInArray.getFirst().intValue());
		assertEquals(1, minMaxDifferenceInArray.getSecond().intValue());
		minMaxDifferenceInArray = PracticeArrays.minMaxDifferenceInArray(new int[] { 3, 8, 1 });
		assertEquals(7, minMaxDifferenceInArray.getFirst().intValue());
		assertEquals(2, minMaxDifferenceInArray.getSecond().intValue());
	}

	@Test
	void findElementInArrayTest() {
		assertTrue(PracticeArrays.findElementInArray(1, new int[] { 1 }));
		assertTrue(PracticeArrays.findElementInArray(28, new int[] { 4, 28, 9, 1 }));
		assertFalse(PracticeArrays.findElementInArray(8, new int[] { 4, 28, 9, 1, 72, 18, 10 }));
		assertFalse(PracticeArrays.findElementInArray(1, new int[] {}));

	}

	@Test
	void copyInReverseOrderTest() {
		assertArrayEquals(new int[] {}, PracticeArrays.copyInReverseOrder(new int[] {}));
		assertArrayEquals(new int[] { 1 }, PracticeArrays.copyInReverseOrder(new int[] { 1 }));
		assertArrayEquals(new int[] { 2, 1 }, PracticeArrays.copyInReverseOrder(new int[] { 1, 2 }));
	}
	
	@Test
	void extractSubArrayTest() {
		assertArrayEquals(new int[] {1}, PracticeArrays.extractSubArray(0,0,new int[] {1}));
		assertArrayEquals(new int[] {30, 25, 40, 32}, PracticeArrays.extractSubArray(6,3,new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}));
		assertArrayEquals(new int[] {30, 25, 40, 32, 31, 35}, PracticeArrays.extractSubArray(3,8,new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}));
	}
	

}