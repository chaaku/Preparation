package Second_Inning;

import java.util.Arrays;

public class NextSmallestNumber {
	public static void main(String[] args) {

		int i = 61759875; // 9875
		System.out.println(nextSmallest(i));

	}

	private static int nextSmallest(int n) {
		// TODO Auto-generated method stub

		char[] arr = Integer.toString(n).toCharArray();

		int pivot = -1, min = Integer.MAX_VALUE, swapIndex = -1;

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				pivot = i - 1;
				break;
			} else
				continue;
		}
		if (pivot < 0) {
			// System.out.println("No such integer can be formed");
			return -1;
		}
		for (int j = arr.length - 1; j > pivot; j--) { // 61271 6 75
			int d = arr[j] - arr[pivot];
			// System.out.println(d + " " + j); //61759875
			if (d > 0 && d < min) {
				// System.out.println("here");
				min = d;
				swapIndex = j;
			}
		}

		// swap pivot to that element
		// System.out.println(swapIndex);
		int temp = arr[swapIndex];
		arr[swapIndex] = arr[pivot];
		arr[pivot] = (char) temp;

		for (int i = pivot + 1; i < arr.length - 1; i++) {
			for (int j = i; j > pivot; j--) {

				if (arr[j] > arr[j + 1]) {
					int temp2 = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = (char) temp2;
				}

			}
		}

		String out = Arrays.toString(arr);
		// System.out.println(out);
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replaceAll(", ", "");

		return Integer.parseInt(out);

	}
}
