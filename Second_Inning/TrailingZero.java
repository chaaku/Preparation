package Second_Inning;

import java.util.Arrays;

public class TrailingZero {

	public static void main(String[] args) {
		int arr[] = { 12, 0, 7, 0, 8, 0, 3, 8, 9, 5, 7, 0 };
					//[12, 7, 0, 8, 0, 3, 0, 8, 9, 5, 7, 0]
		zeroInEnd(arr);

	}

	private static void zeroInEnd(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] != 0) {
				a[count] = a[i];
				count++;
			}
		}

		while (count < a.length) {
			a[count] = 0;
			count++;
		}

		System.out.print(Arrays.toString(a));			

	}

}
