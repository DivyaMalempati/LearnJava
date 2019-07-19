import java.util.Scanner;

class RemoveDuplicates {
	public static void main(String[] args) {
		int[] array = new int[] { 0, 0, 1, 1, 2, 2, 3, 3, 4 };
		int elementsCount = removeDuplicates(array);
		System.out.println(elementsCount);
		System.out.print("[");
		for (int i = 0; i < elementsCount; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
		int val=3,elements;
		elements=removeElement(array,val);
		System.out.println(elements);
		for(int i=0;i<elements;i++) {
			System.out.println(array[i]+", ");
		}
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int countUniqueElements = 0, element = nums[0];
		for (int index = 0; index < nums.length-1; index++) {
			if (element != nums[index]) {
				countUniqueElements++;
				element = nums[index];
				nums[countUniqueElements] = element;
			}
		}

		return countUniqueElements + 1;
	}
	public static int removeElement(int[] nums, int val) {
        int countUniqueElements=nums.length;
        for(int index=nums.length-1;index>=0;index--){
        	if(nums[index]==val){
        		countUniqueElements--;
        		nums[index]=nums[index+1];
           }
        }
        return countUniqueElements;
    }
}
