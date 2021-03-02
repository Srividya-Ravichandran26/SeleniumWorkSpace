package week1.assignment;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range = 8, firstNum = 0, secondNum = 1, sum;

		System.out.println(firstNum);
		System.out.println(secondNum);
		for (int i = 2; i < range; i++) {

			sum = firstNum + secondNum;
			System.out.println(sum);
			firstNum = secondNum;
			secondNum = sum;

		}

	}

}
