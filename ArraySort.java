import java.util.Arrays;
import java.util.Collections;

public class ArraySort {

	public static void main(String[] args) {

		int arr[] = { 1, 43, 43, 13, 53, 54, 23, 123, 11, 21, 2 };
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		Integer b[] = { 1, -3, 33, 3, -73, 57, 23, 03, -1, 21, 2 };

		Arrays.sort(b, Collections.reverseOrder());
		System.out.println(Arrays.toString(b));

	}
}
