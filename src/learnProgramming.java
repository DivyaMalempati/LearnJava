import java.util.Scanner;

class learnProgramming {
	public static void main(String[] args) {
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :");
		number = sc.nextInt();
		printIntegersTillTheNumber(number);
		int spaces = 50;
		printLine(spaces);
		printRightStarsLeftBottomSpaces(number);
		printLine(spaces);
		printLeftStarsRightTopSpaces(number);
		printLine(spaces);
		printPyramid(number);
		printLine(spaces);
		printLeftTopStarsRightBottomSpaces(number);
		printLine(spaces);
		printRightStarsLeftTopSpaces(number);
		printLine(spaces);
		sc.close();
	}

	private static void printLeftTopStarsRightBottomSpaces(int number) {
		for (int i = 0; i < number; i++) {
			for (int j = number; j > i; j--) {
				System.out.print("* ");
			}
			for (int k = 1; k < i; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	private static void printLeftStarsRightTopSpaces(int number) {
		for (int i = 0; i <= number; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}

	private static void printPyramid(int number) {
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < (number - 1 - i); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printRightStarsLeftTopSpaces(int number) {
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - 1 - i; j++) {
				System.out.print("  ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void printRightStarsLeftBottomSpaces(int number) {
		for (int i = 0; i < number; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("  ");
			}
			for (int j = 0; j < number - i; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}

	private static void printLine(int number) {
		for (int i = 0; i <= number; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private static void printIntegersTillTheNumber(int number) {
		for (int i = 1; i <= number; i++) {
			System.out.println(i);
		}
	}

}