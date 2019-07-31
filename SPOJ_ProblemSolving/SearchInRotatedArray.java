package SPOJ_ProblemSolving;

// sorted , inASorted, searchINSORTED, searchinasortedarray
public class SearchInRotatedArray {
	public static void main(String[] args) {

		int[] arr = { 3, 4, 5, 1, 2 };

		System.out.println(findElement(7, arr));
	}

	private static int findElement(int n, int[] arr) {

		int pivot = -1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1])
				pivot = i;
		}

		if (pivot == -1) {
			System.out.println("Not a rotated array ");
		}

		int index = searchinSubarray(arr, n, 0, pivot - 1);

		if (index == -1)
			index = searchinSubarray(arr, n, pivot, arr.length - 1);

		return index;

	}

	private static int searchinSubarray(int[] arr, int key, int start, int end) {

		int result = -1;

		for (int i = start; i <= end; i++) {

			if (arr[i] == key)
				result = i;
		}
		return result;
	}

}
