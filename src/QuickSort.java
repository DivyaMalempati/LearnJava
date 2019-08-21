
public class QuickSort {
	public int[] quickSort(int[] array, int start, int end) {
		if (array.length < 2) {
			return array;
		}
		int pivotIndex = 0;
		int pivot = array[0];
		quickSort(array, pivotIndex + 1, array.length);
		return array;
	}
}
