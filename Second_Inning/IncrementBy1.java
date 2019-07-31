package Second_Inning;

public class IncrementBy1 {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 9 };

		int b[] = incr(arr);

		for (int i : b)
			System.out.println(i);
	}

	static int[] incr(int[] arr) {
		// [239 to be fixed]
		int i = 0;
		while (i < arr.length - 1) {
			i++;
			continue;
		}

		if (i == arr.length - 1) {
			int temp = arr[i] + 1;
			arr[i] = temp;
		}
		return arr;
	}
}
