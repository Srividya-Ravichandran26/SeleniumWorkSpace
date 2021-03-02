package week1.day2;

public class DuplicateNumberArray {

	public static void main(String[] args) {
		int[] arr = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20, 14 };

		int count;

		for (int i = 0; i < arr.length; i++) {
			count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					arr[j] = 0; // if we have multiple duplicates of same number, then replace the number and
								// ignore in below if condition
				}

			}
			if (count > 0 && arr[i] != 0) {
				System.out.println(arr[i] + " is duplicate value");
			}
		}

	}

}
