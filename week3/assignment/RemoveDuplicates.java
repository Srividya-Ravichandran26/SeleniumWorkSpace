package week3.assignment;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String input = "PayPal India";
		char[] charArray = input.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();

		for (int i = 0; i < charArray.length; i++) {
			boolean addedResult = charSet.add(charArray[i]);
			if (addedResult == false) {
				dupCharSet.add(charArray[i]);
			}
		}
		for (Character eachValue : charSet) {
			if (eachValue != ' ')
				System.out.print(eachValue);
		}

	}

}
