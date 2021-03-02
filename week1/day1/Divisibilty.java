package week1.day1;

public class Divisibilty {

	public static void main(String[] args) {

		for (int num = 1; num <= 25; num++) {
			if (num % 3 == 0 && num % 7 == 0) {
				System.out.println(num + " is bizfiz");
			} else if (num % 3 == 0) {
				System.out.println(num + " is biz");
			} else if (num % 7 == 0) {
				System.out.println(num + " is fiz");
			} else {
//				System.out.println(num + " is not divisible by 3 or 7");
			}
		}
	}

}
