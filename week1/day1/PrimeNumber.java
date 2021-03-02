package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		int number = 21;
		int count = 0;

		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count = count + 1;
			}

		}

		if (count == 2) {
			System.out.println(number + " is prime number");
		} else
			System.out.println(number + " is not prime number");

	}

}
