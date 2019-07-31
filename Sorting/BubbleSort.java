package Sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {

				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i : arr)
			System.out.print(Integer.toString(i) + " ");
	}

}
