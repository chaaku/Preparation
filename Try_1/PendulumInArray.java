package Try_1;

import java.util.*;

public class PendulumInArray {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 2, 8, 9, 5, 7, 6 };
		for(int i:arr)
			System.out.print(i+" ");
		// int arr [] = {11,12,31,14,5};
		System.out.print("\nIn Same array : ");
		calcInSameArray(arr, arr.length);
		System.out.print("with use of other array : ");
		calc(arr, arr.length);
	}

	// 1 2 3 4 5 6 7 8 9
	// 5 11 12 14 31

	static void calc(int[] arr, int n) {
		int ans[] = new int[n];
		Arrays.sort(arr);
		int k = (n - 1) / 2;
		ans[k] = arr[0];
		int j = 1;
		for (int i = 1; i < n - 1; i += 2) {
			ans[k + j] = arr[i];
			ans[k - j] = arr[i + 1];
			j++;
		}
		if (n % 2 == 0) {
			ans[n - 1] = arr[n - 1];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

	static void calcInSameArray(int[] a, int len) {
		Arrays.sort(a);
		for (int i = len - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				System.out.print(a[i]);
				System.out.print(" ");

			}
		}
		for (int i = 1; i <= len - 1; i++) {

			if (i == len - 2 && i % 2 != 0)
				System.out.println(a[i]);

			else if (i % 2 != 0) {
				System.out.print(a[i] + " ");
			}
		}

	}

}
