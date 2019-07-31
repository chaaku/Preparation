package Try_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximuNumberFormedFromArray {
	public static void main(String[] args) {

		Integer[] arr = { 54, 546, 548, 60 };
		// 5485465460
		// 5454654860
		
		String test ="";
		System.out.println(9+8+test+89);

		List<Integer> list = new ArrayList<>(Arrays.asList(arr));

		Collections.sort(list, new sortedClass());

		String out = "";
		for (int i = 0; i < list.size(); i++) {
			out += list.get(i);
		}
		System.out.println(out);
	}

}

class sortedClass implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {

		String first = a + "" + b;
		String second = b + "" + a;

		return second.compareTo(first);
	}

}