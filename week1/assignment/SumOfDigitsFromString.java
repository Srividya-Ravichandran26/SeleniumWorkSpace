package week1.assignment;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// Method 1
		String text = "Tes12Le79af65";
		int sum = 0;
		String replacedText = text.replaceAll("[a-zA-Z]", "");
		char[] charArray = replacedText.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
//			System.out.println(charArray[i]);
			int numericValue = Character.getNumericValue(charArray[i]);
			sum = sum + numericValue;
		}
		System.out.println("Sum Of Digits from String using Method 1 is: " + sum);
		
		// Method 2
		int sum2 = 0;
		for (int i = 0; i < text.length(); i++) {
			if(Character.isDigit(text.charAt(i)))
			{
				int numValue = Character.getNumericValue(text.charAt(i));
				sum2 = sum2 + numValue;
			}
		}
		System.out.println("Sum Of Digits from String using Method 2 is: " + sum2);
	}
}
