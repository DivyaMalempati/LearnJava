package com.divya.learnjava;

import static org.junit.jupiter.api.Assertions.*;
import com.divya.learnjava.FindSubSumArrayWithHighLowIndices.MinMaxInArrayWithSum;

import org.junit.jupiter.api.Test;

class FindSubSumArrayWithHighLowIndicesTest {

	@Test
	public void findSubSumOfArray_Test() {
		MinMaxInArrayWithSum minMax = FindSubSumArrayWithHighLowIndices
				.findSubSum(new int[] { -2, -3, 3, 4, 5, -1, 5 });
		assertEquals(16, minMax.maxSum);
		minMax = FindSubSumArrayWithHighLowIndices.findSubSum(new int[] { 1, -1, 1, 1, 1, 2, -4, 3, 2, 1 });
		assertEquals(7, minMax.maxSum);
		assertEquals(0, minMax.minIndex);
		assertEquals(9, minMax.maxIndex);
	}
}
