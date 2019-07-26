public class Palindrome {
	public static void main(String[] args) {
		int x = 121;
		boolean isPalindrome=isPalindrome(x);
		if(isPalindrome) {
			System.out.println(x+" is palindrome");
		}
		else{
			System.out.println(x+" is not Palindrome");
		}
	}
    public static boolean isPalindrome(int x) {
    	int reversed=0,temp=x;
        if(x<=0){
            return false;
        }
        while(x!=0){
            x=x%10;
            reversed=reversed*10+x;
            x=x/10;
        }
        if(temp==reversed){
            return true;
        }
        else{
            return false;
        }
        
    }
}