public class extractWords{
	public static void main(String[] args) {
		String str= "I am Divya Daggupati";
		String[] words= str.split(" ",4);
		for (String string : words) {
			System.out.println(string);
		}
	}
}