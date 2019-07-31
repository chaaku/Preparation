package Sorting;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = { 342, 14, 24, 13, 56, 73, 19, 66, 33, 81, 21 };

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {

					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i : arr)
			System.out.print(i + " ");

	}

}
