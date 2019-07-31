import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class FindTheSumAndSplitArray{
	@Test
	public void findSum_Test() {
		assertEquals(13, findSumAndSplitArray(new int[] {6,4,13,3}));
	}
	public int findSumAndSplitArray(int[] array) {
		int sum=0;
		for(int index=0;index<array.length;index++) {
			sum+=array[index];
		}
		int elementToSearch=sum/2;
		for(int index=0;index<array.length;index++) {
			if(elementToSearch==array[index]) {
				return elementToSearch;
			}
		}
		return -1;
	}
}