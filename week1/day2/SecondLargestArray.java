package week1.day2;

import java.util.Arrays;

public class SecondLargestArray {

	public static void main(String[] args) {

		int[] num = {3,2,11,4,6,7};
		
		Arrays.sort(num);
		System.out.println("Sorting order:");
		
		for(int i=0;i<num.length;i++)
		{
			System.out.println(num[i]);
		}
		System.out.println("The second largest number is: " + num[num.length-2]);

	}

}
