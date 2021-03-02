package week1.day2;

public class SumOfDigits {

	public static void main(String[] args) {

		int input = 123, reminder, sum = 0;

		while (input > 0) {
			reminder = input % 10; // Getting last digit of the input number e.g: 3
			sum = sum + reminder; // assigning reminder value with existing sum value
			input = input / 10; // divider - quotient value e.g: 12
		}
		System.out.println("Sum of digits: " + sum);
		

	}

}
