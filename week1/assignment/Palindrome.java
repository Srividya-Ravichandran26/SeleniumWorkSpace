package week1.assignment;

public class Palindrome {

	public static void main(String[] args) {
		String name = "madam";
		String rev = "";
		
		int length = name.length()-1;
		
		for (int i = length; i >= 0; i--) {
			rev = rev + name.charAt(i);
		}
		
		if(rev.equalsIgnoreCase(name))
		{
			System.out.println("Orginal String is : " + name);
			System.out.println("Reversed String is : " + rev);
			System.out.println("This is palinDrome");
		}

	}

}
