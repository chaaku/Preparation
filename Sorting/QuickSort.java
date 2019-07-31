package Sorting;

public class QuickSort {
	// https://www.youtube.com/watch?v=_efAqdi69EU

	public static void main(String[] args) {

		// int a [] = {14,24,17,1,32,4,6,8,26,18,95};
		int a[] = { 11, 14, 2, 7, 13, 10, 3 };
		int number = a.length;

		quickSort(a, 0, number - 1);

		for (int i : a)
			System.out.print(i + " ");
	}

	static void quickSort(int[] a, int low, int high) {

		int i = low, j = high;

		// Get the pivot element from the middle of the list
		int pivot = a[(low + high) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller than the pivot
			// element then get the next element from the left list
			while (a[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger than the pivot
			// element then get the next element from the right list
			while (a[j] > pivot) {
				j--;
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(a, i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j) {
			quickSort(a, low, j);
		}
		if (i < high) {
			quickSort(a, i, high);
		}
	}

	private static void exchange(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
