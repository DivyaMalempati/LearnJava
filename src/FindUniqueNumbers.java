import java.util.Scanner;

class FindUniqueNumbers {
	private static final String DELIMITER_BETWEEN_NUMBERS = ",";

	public static void main(String[] args) {
		int numberOfTestCases = 0;
		Scanner scanner = new Scanner(System.in);
		numberOfTestCases = Integer.parseInt(scanner.nextLine());
		for (int initialTestCase = 0; initialTestCase < numberOfTestCases; initialTestCase++) {
			int arraySize;
			String lineOfNumbers = scanner.nextLine();
			String[] inputNumberStringArray = lineOfNumbers.split(DELIMITER_BETWEEN_NUMBERS);

			arraySize = inputNumberStringArray.length;
			int[] array = new int[arraySize];
			for (int currentIndex = 0; currentIndex < arraySize; currentIndex++) {
				array[currentIndex] = Integer.parseInt(inputNumberStringArray[currentIndex]);
			}
			printArray(array);
			int[] uniqueArray = findUniqueNumbersWithMemory(array);
			printArray(uniqueArray);
			uniqueArray = findUniqueNumbersWithOutMemory(array);
			printArray(uniqueArray);
		}
		scanner.close();
	}

	private static int[] findUniqueNumbersWithOutMemory(int[] array) {
		int[] uniqueArray = new int[array.length];
		int uniqueArrayActualSize = 0;
		for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
			boolean isUnique = true;
			for (int previousIndex = 0; previousIndex < currentIndex; previousIndex++) {
				if (array[previousIndex] == array[currentIndex]) {
					isUnique = false;
					break;
				}
			}
			if (isUnique) {
				uniqueArray[uniqueArrayActualSize] = array[currentIndex];
				uniqueArrayActualSize++;
			}
		}

		return uniqueArray;
	}

	private static int[] findUniqueNumbersWithMemory(int[] array) {
		int[] uniqueArray = new int[array.length];
		int uniqueArrayActualSize = 0;
		for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
			boolean isUnique = true;
			for (int uniqueArrayIndex = 0; uniqueArrayIndex < uniqueArrayActualSize; uniqueArrayIndex++) {
				if (uniqueArray[uniqueArrayIndex] == array[currentIndex]) {
					isUnique = false;
					break;
				}
			}
			if (isUnique) {
				uniqueArray[uniqueArrayActualSize] = array[currentIndex];
				uniqueArrayActualSize++;
			}
		}

		return uniqueArray;
	}

	private static void printArray(int[] array) {
		System.out.print("[");
		for (int i : array) {
			System.out.print(i + DELIMITER_BETWEEN_NUMBERS);
		}
		System.out.println("]");
	}
}