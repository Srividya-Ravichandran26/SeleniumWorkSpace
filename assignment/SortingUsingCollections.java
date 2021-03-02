package week3.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollections {

	public static void main(String[] args) {
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		List<String> arrObj = new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {
			arrObj.add(input[i]);
		}
		Collections.sort(arrObj);
		for (int i = arrObj.size()-1; i >= 0; i--) {
			if(i!=0)
				System.out.print(arrObj.get(i) + ", ");
			else
				System.out.print(arrObj.get(i));
		}

	}

}
