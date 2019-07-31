package Sorting;

public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i : arr)
			System.out.println(i);
	}

}
