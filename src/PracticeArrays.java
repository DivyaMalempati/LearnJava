import java.util.Scanner;

public class PracticeArrays {
	public static void main(String[] args) {
		int size = 0;
		final Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the array :");
		size = scanner.nextInt();
		// Dynamic memory allocation
		final int[] array = new int[size];
		// { 58, 24, 13, 15, 63, 9, 8, 81, 1, 78 }
		readElements(size, scanner, array);
		printArray(array);
		System.out.println("Enter the number to be searched in Array :");
		int elementToFind = scanner.nextInt();
		findElementInArray(elementToFind, array);
		typesOfNumbers(array);
		copyInReverseOrder(array);
		sumOfArray(array);
		productofArray(array);
		// two Dimensional Array
		final int[][] twoDimArray = readElementsTwoDimension();
		printTwoDimArray(twoDimArray);
		// array is populated using call by reference
		readElements(size, scanner, array);
		// largestAndSmallestElementOfAnArray(array);
		isArrayPalindrome(array);

		// splitArrayIntoTwo(array);
		minMaxDifferenceInArray(array);
		// subArray From Main Array
		int startIndex, endIndex;
		startIndex = scanner.nextInt();
		endIndex = scanner.nextInt();
		int[] newArray = new int[] { 10, 12, 20, 15 };
		extractSubArray(startIndex, endIndex, newArray);
		insertIntoArray(newArray);
		newArray= new int[] {1,2,3,4,5};
		moveOneELementCircular(newArray);
		scanner.close();
	}

	public static int[] moveOneELementCircular(int[] newArray) {
		int initialElement=newArray[newArray.length-1];
		for(int shiftIndex=newArray.length-2;shiftIndex>=0;shiftIndex--) {
			newArray[shiftIndex+1]=newArray[shiftIndex];
			
		}
		newArray[0]=initialElement;
		System.out.print("[");
		for(int i:newArray) {
			System.out.print(i+",");
		}
		System.out.print("]");
		return newArray;
	}

	private static void insertIntoArray(int[] array) {
		// int[] array = { 4, 8, 5, 6, 3, 2 };
		int highestElement = Integer.MIN_VALUE, secondHighestElement = highestElement, highestElementIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (highestElement < array[i]) {
				secondHighestElement = highestElement;
				highestElement = array[i];
				highestElementIndex = i;
			} else if (secondHighestElement < array[i] && array[i] < highestElement) {
				secondHighestElement = array[i];
			}
		}
		int[] newArray = new int[array.length + 1];
		for (int index = 0, newArrayIndex = 0; index < array.length; index++, newArrayIndex++) {
			if (highestElementIndex == newArrayIndex) {
				newArray[highestElementIndex] = secondHighestElement;
				newArray[highestElementIndex + 1] = highestElement - secondHighestElement;
				newArrayIndex++;

			} else {
				newArray[newArrayIndex] = array[index];
			}

		}
		System.out.print("[");
		for (int i = 0; i < newArray.length; i++) {

			System.out.print(newArray[i] + ",");

		}
		System.out.print("]");
		System.out.println(
				"Highest Element is : " + highestElement + " and Second Highest ELement is : " + secondHighestElement);
	}

	static int[] extractSubArray(int startIndex, int endIndex, int[] array) {
		if (startIndex > endIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			endIndex = temp;
		}
		int size = endIndex - startIndex + 1;
		System.out.println(size);
		int[] subArray = new int[size];
		for (int i = 0; i < size; i++) {
			subArray[i] = array[startIndex++];
		}
		return subArray;
	}

	/*
	 * Theja Review COmments Investigate FInal keyword use foreach when ever index
	 * is not being used explicitly
	 * 
	 */

	static TwoGenericObjects<Integer, Integer> minMaxDifferenceInArray(int[] array) {
		// int[] array1 = { 28, 9, 10, 45, 1, 82, 24, 18 };
		Integer maxDiff, minDiff;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		printArray(array);
		if (array.length >= 3) {
			maxDiff = array[0] - array[array.length - 1];
			minDiff = array[array.length - 2] - array[array.length - 1];

		} else if (array.length == 2) {
			maxDiff = array[0] - array[array.length - 1];
			minDiff = maxDiff;
		} else {
			maxDiff = 0;
			minDiff = 0;
		}

		return new TwoGenericObjects<Integer, Integer>(maxDiff, minDiff);
	}

	static class TwoGenericObjects<FIRST, SECOND> {
		private final FIRST first;
		private final SECOND second;

		public TwoGenericObjects(FIRST first, SECOND second) {
			this.first = first;
			this.second = second;
		}

		public FIRST getFirst() {
			return first;
		}

		public SECOND getSecond() {
			return second;
		}
	}

	static TwoGenericObjects<Integer[], Integer[]> splitArrayIntoTwo(final int[] array) {
		int leftArraySize = 0, rightArraySize = 0;
		if (array.length % 2 == 0) {
			leftArraySize = array.length / 2;
			rightArraySize = array.length / 2;
		} else {
			leftArraySize = array.length / 2 + 1;
			rightArraySize = array.length / 2;
		}
		final Integer[] splitArray1 = new Integer[leftArraySize];
		final Integer[] splitArray2 = new Integer[rightArraySize];
		for (int i = 0; i < leftArraySize; i++) {
			splitArray1[i] = array[i];
		}
		for (int i = 0, j = leftArraySize; j < array.length; i++, j++) {
			splitArray2[i] = array[j];
		}
		return new TwoGenericObjects<>(splitArray1, splitArray2);
	}

	static boolean isArrayPalindrome(final int[] array) {
		int size = array.length - 1;
		boolean isPalindrome = true;
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[size--]) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

	static TwoGenericObjects<Integer, Integer> largestAndSmallestElementOfAnArray(final int[] array) {
		Integer largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
			if (array[i] < smallest) {
				smallest = array[i];
			}

		}
		return new TwoGenericObjects<Integer, Integer>(largest, smallest);
	}

	static void printTwoDimArray(int[][] twoDimArray) {
		System.out.println("{");
		for (int i = 0; i < twoDimArray.length; i++) {
			System.out.print("[");
			for (int j = 0; j < twoDimArray[i].length; j++) {
				System.out.print(twoDimArray[i][j]);
				if (j != twoDimArray[i].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println("]");
		}
		System.out.print("}");
	}

	static int[][] readElementsTwoDimension() {
		int rowSize, columnSize;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Row Size : ");
		rowSize = scanner.nextInt();
		System.out.println("Enter column Size : ");
		columnSize = scanner.nextInt();
		int[][] twoDimArray = new int[rowSize][columnSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				twoDimArray[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		return twoDimArray;
	}

	private static void productofArray(int[] array) {
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}
		System.out.println("The Product of Array :" + product);
	}

	private static void sumOfArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("The sum of the Array : " + sum);
	}

	private static int[] readElements(int size, Scanner sc, int[] array) {
		System.out.println("Enter the elements : ");
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}

	private static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ",");
		}

		System.out.print(array[array.length - 1]);
		System.out.println("]");
	}

	static boolean findElementInArray(int elementToFind, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (elementToFind == array[i]) {
				// when the goal of the function is achieved just use RETURN to say its done
				return true;
			}
		}
		return false;

	}

	private static void typesOfNumbers(int[] array) {
		int even = 0, positive = 0, negative = 0, odd = 0, zero = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				positive++;
			} else if (array[i] < 0) {
				negative++;
			} else {
				zero++;
			}
			if (array[i] % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("Postive Numbers :" + positive);
		System.out.println("Negative Numbers :" + negative);
		System.out.println("Even Numbers :" + even);
		System.out.println("Odd Numbers :" + odd);
		System.out.println("Zeros :" + zero);
	}

	static int[] copyInReverseOrder(int[] array) {
		int size = array.length - 1;
		final int[] reverseArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			// Post decrement operator
			reverseArray[i] = array[size--];
		}
		return reverseArray;
	}
}