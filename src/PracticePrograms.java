public class PracticePrograms{
	public static void main(String[] args) {
		printStarsAscendingOrder();
		printLine();
		System.out.println();
		System.out.println();
		printSandClock();
	}
	private static void printSandClock() {
		for(int index=1;index<=5;index++) {
			for(int jIndex=0;jIndex<index;jIndex++) {
				System.out.print(" ");
			}
			for(int kIndex=index;kIndex<=5;kIndex++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int index = 5-1; index >= 1; index--) 
        {
             for (int jIndex = 1; jIndex < index; jIndex++) 
            {
                System.out.print(" ");
            }
            for (int kIndex = index; kIndex <= 5; kIndex++)
            {
                System.out.print(" *");
            }
             
            System.out.println();
        }
	}
	private static void printLine() {
		for(int index=0;index<25;index++) {
			System.out.print("_");
		}
	}
	public static void printStarsAscendingOrder(){
		for(int index=0;index<5;index++) {
			for(int jIndex=0;jIndex<index;jIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
}