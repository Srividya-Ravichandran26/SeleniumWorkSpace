package week1.assignment;

public class FindIntersection {

	public static void main(String[] args) {
		int[] num = { 3, 2, 11, 4, 6, 7 };
		int[] arr = { 1, 2, 8, 4, 9, 7 };

		System.out.println("Matching Values are: ");

		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if (num[i] == arr[j]) {
					System.out.println(num[i]);
				}

			}

		}

	}

}
