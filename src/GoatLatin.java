
/**
 *A sentence S is given, composed of words separated by spaces. Each word consists of lower case and upper case letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.
     
    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".
     
    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin.  
*/
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class GoatLatin {
	public String goatLatinOfWord(String s) {
		String[] splitString = new String[s.length()];
		splitString = s.split(" ");
		StringBuilder aString = new StringBuilder();
		for (int index = 0; index < splitString.length; index++) {
			char start = splitString[index].charAt(0);
			if (start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u' || start == 'A'
					|| start == 'E' || start == 'I' || start == 'O' || start == 'U') {
				splitString[index] = splitString[index].concat("ma");
			} else {
				splitString[index] = splitString[index].substring(1).concat(start + "ma");
			}
			aString = aString.append("a");
			splitString[index] = splitString[index].concat(aString.toString());
		}
		StringBuilder outputString = new StringBuilder();
		for (int index = 0; index < splitString.length; index++) {
			outputString.append(splitString[index]);
			if (index != splitString.length - 1) {
				outputString.append(" ");
			}
		}
		return outputString.toString();
	}

	@Test
	public void goatLatinTest() {
		assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", goatLatinOfWord("I speak Goat Latin"));
	}
}
