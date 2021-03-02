package week1.day2;

public class ArmStrong {

	public static void main(String[] args) {
		// Cube of number is arm strong number
		int input = 153, reminder, sum = 0;

		int original = input;

		while (input != 0) {
			reminder = input % 10; // Getting last digit of the input number e.g: 3
			sum = sum + (reminder * reminder * reminder); // assigning reminder value with existing sum value
			input = input / 10; // divider - quotient value e.g: 12
		}
		if (sum == original)
			System.out.println(original + " is an Armstrong number.");
		else
			System.out.println(original + " is not an Armstrong number.");

	}

}
