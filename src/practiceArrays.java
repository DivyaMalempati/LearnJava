import java.util.Scanner;

class practiceArrays {
	public static void main(String[] args) {
		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array :");
		size = sc.nextInt();
		int[] array = new int[size];
		int[] reverseArray = new int[size];
		readElements(size, sc, array);
		printArray(array);
		findElementinArray(sc, array);
		typesOfNumbers(array);
		copyInReverseOrder(array,reverseArray);
		sumOfArray(array);
		productofArray(array);
		sc.close();
	}


	private static void productofArray(int[] array) {
		int product=1;
		for(int i=0;i<array.length;i++) {
			product*=array[i];
		}
		System.out.println("The Product of Array :"+product);
	}


	private static void sumOfArray(int[] array) {
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		System.out.println("The sum of the Array : "+sum);
	}


	private static void readElements(int size, Scanner sc, int[] array) {
		System.out.println("Enter the elements : ");
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
	}

	private static void printArray(int[] array) {
		System.out.print("The Elements in the Array are : [");
		 for(int i=0;i<array.length;i++) {
			 System.out.print(array[i]);
			 if(i!=array.length-1) {
				 System.out.print(",");
			 }
		 }
		 System.out.println("]");
	}

	private static void findElementinArray(Scanner sc, int[] array) {
		int elementToFind = 0, counter = 0;
		System.out.println("Enter the number to be searched in Array :");
		elementToFind = sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			if (elementToFind == array[i]) {
				counter++;
				//System.out.println(counter);
				break;
			}
		}
		if (counter > 0) {
			System.out.println("Element found");
		} else {
			System.out.println("Element not found");
		}
	}

	private static void typesOfNumbers(int[] array) {
		int even = 0, pos = 0, neg = 0, odd = 0, zero = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				pos++;
			}
			if (array[i] < 0) {
				neg++;
			}
			if (array[i] % 2 == 0) {
				even++;
			}
			if (array[i] % 2 != 0) {
				odd++;
			}
			if (array[i] == 0) {
				zero++;
			}
		}
		System.out.println("Postive Numbers :" + pos);
		System.out.println("Negative Numbers :" + neg);
		System.out.println("Even Numbers :" + even);
		System.out.println("Odd Numbers :" + odd);
		System.out.println("Zeros :" + zero);

	}
	

	private static void copyInReverseOrder(int[] array, int[] reverseArray) {
		int size=array.length-1;
		for(int i=0;i<array.length;i++) {
			reverseArray[i]=array[size--];
		}
		printArray(reverseArray);
	}
}