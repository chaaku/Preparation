package ProblemSolvingBrainteaser;

/* 
 * For 2 unsorted array if you want to sort and make a single array then first add them 
 * into a single array and then sort them using Arrays.sort or use any sorting algorithm
 * 
 */

public class MergerTwoSortedArray {

	public static void main(String[] args) {

		int[] a = { 0, 1, 2, 5, 7, 9, 11 };
		int[] b = { 1, 4, 10, 17 };

		int m = a.length;
		int n = b.length;

		int[] result = new int[m + n];

		sorted(a, b, m, n, result);

		for (int i : result)
			System.out.println(i);

	}

	public static int[] sorted(int[] a, int[] b, int m, int n, int[] result) {

		if (m <= 0)
			return b;
		if (n <= 0)
			return a;

		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {

			if (a[i] < b[j])
				result[k++] = a[i++];

			else
				result[k++] = b[j++];
		}

		while (i < m)
			result[k++] = a[i++];

		while (j < n)
			result[k++] = b[j++];

		return result;

	}
}
