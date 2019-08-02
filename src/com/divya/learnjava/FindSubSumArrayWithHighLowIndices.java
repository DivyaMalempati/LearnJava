package com.divya.learnjava;

public class FindSubSumArrayWithHighLowIndices {
	static class MinMaxInArrayWithSum {
		int minIndex = 0, maxIndex = 0;
		int maxSum = Integer.MIN_VALUE;
	}

	public static MinMaxInArrayWithSum findSubSum(int[] array) {
		MinMaxInArrayWithSum minMax = new MinMaxInArrayWithSum();
		for (int index = 0; index < array.length; index++) {
			int sum = 0;
			for (int nextIndex = index; nextIndex < array.length; nextIndex++) {
				sum += array[nextIndex];
				if (sum > minMax.maxSum) {
					minMax.minIndex = index;
					minMax.maxIndex = nextIndex;
					minMax.maxSum = sum;
				}
			}
		}
		return minMax;
	}
}
