package week1.assignment;

public class CharOccurance {

	public static void main(String[] args) {

		// using replace
		String str = "welcome to chennai";
		int OriginalLength = str.length();
		String replaceStr = str.replace("e", "");
		int replaceLength = replaceStr.length();
		System.out.println("number of occurrences of a char (eg 'e') using replace is: " 
							+ (OriginalLength - replaceLength));

		// using charAt
		int count = 0;
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'e') {
				count++;
			}
		}
		System.out.println("number of occurrences of a char (eg 'e') using charAt is: " + count);

	}

}
