import java.util.Scanner;

class primeNumberPrograms{
	public static void main(String[] args) {
		int startNumber,endNumber;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a start Interval :");
		startNumber=sc.nextInt();
		System.out.println("Enter a end Interval :");
		endNumber= sc.nextInt();
		if(startNumber>endNumber) {
			int temp;
			temp=startNumber;
			startNumber=endNumber;
			endNumber=temp;
		}
		while(startNumber<endNumber) {
			if(checkPrimeNumber(startNumber)) {
				System.out.println(startNumber);
			}
			startNumber++;
		}
		
		sc.close();
	}

	private static boolean checkPrimeNumber(int startNumber) {
		boolean flag=true;
		for(int i=2;i<=startNumber/2;i++) {
			if(startNumber%i==0) {
				flag=false;
				break;
			}
		}
		return flag;
	}
}