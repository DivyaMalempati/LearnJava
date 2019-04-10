import java.util.Scanner;

public class CheckNumberPalindromeOrNotPalindromeClass{
	public static void main(String[] args) {
		int reminder=0,reversedInteger=0;
		Scanner sc = new Scanner(System.in);
		// reading an integer 
		System.out.println("Enter an Integer :");
		int palindromeNumber=sc.nextInt();
		int tempNumber=palindromeNumber;
		while(tempNumber!=0) {
			reminder=tempNumber%10;
			System.out.println(reminder);
			reversedInteger=reversedInteger*10+reminder;
			System.out.println(reversedInteger);
			tempNumber/=10;
			System.out.println(tempNumber);
		}
		if (palindromeNumber==reversedInteger) {
			System.out.println(palindromeNumber+" is Palindrome");
		}
		else {
			System.out.println(palindromeNumber+" is not Palindrome");
		}
	}
}