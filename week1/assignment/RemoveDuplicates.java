package week1.assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println("Original Text: " + text);
		String[] splitWords = text.split(" ");
		
		for (int i = 0; i < splitWords.length; i++) {
			for (int j = i + 1; j < splitWords.length; j++) {
				if (splitWords[i].equalsIgnoreCase(splitWords[j])) {
					splitWords[j] = splitWords[j].replace(splitWords[j], "");					
				}
			}			
		}		
		System.out.print("Final Text: ");
		for (int k = 0; k < splitWords.length; k++) {
			System.out.print(splitWords[k] + " ");
		}
	}
}
