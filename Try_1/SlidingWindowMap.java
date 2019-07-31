package Try_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SlidingWindowMap {

	private static Map<Integer, Integer> map = new LinkedHashMap<>();

	public static void main(String[] args) {
		System.out.println("Distinct elements of window of size 2");
		distinctElements(new int[] { 1, 2, 1, 3, 4, 2, 3, 6, 7 }, 2);

		System.out.println("Distinct elements of window of size 3");
		distinctElements(new int[] { 1, 2, 1, 3, 4, 2, 3, 6, 7 }, 3);

		System.out.println("Distinct elements of window of size 4");
		distinctElements(new int[] { 1, 2, 1, 3, 4, 2, 3, 6, 7 }, 4);

		System.out.println("Distinct elements of window of size 5");
		distinctElements(new int[] { 1, 2, 1, 3, 4, 2, 3, 6, 7 }, 5);
	}

	private static int distinctElements(int[] arr, int k) {
		// TODO Auto-generated method stub

		int i;

		for (i = 0; i < k; i++) {

			int count = 0;

			if (map.containsKey(arr[i]))
				count = map.get(arr[i]);
			map.put(arr[i], ++count);
		}

		i = 0;
		for (int j = k; j < arr.length; j++) {

			int value = map.get(arr[i]);
			if (value == 1)
				map.remove(arr[i]);
			else
				map.put(arr[i], value - 1);

			i++;

			if (map.containsKey(arr[j])) {
				int count = map.get(arr[j]);
				map.put(arr[j], count + 1);
			} else
				map.put(arr[j], 1);

			printMap();
		}
		return 0;
	}

	private static void printMap() {
		System.out.print(map.keySet());
		System.out.print(" and count is " + map.keySet().size() + "\n");
	}

}
