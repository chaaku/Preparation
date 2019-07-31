package Try_1;

public class MultiplyLeftAndRighArraySum {
	public static void main(String[] args) {

		int[] arr = { 5, 6, 8 };
		int[] arr1 = { 3, 5, 2, 7 };
		findSum(arr);
	}

	private static void findSum(int[] arr) {
		// TODO Auto-generated method stub
		if (arr.length == 0)
			return;

		int n = arr.length, sumfirstHalf = 0, secondHalf = 0;

		for (int i = 0; i < n / 2; i++) {
			sumfirstHalf += arr[i];
		}
		for (int i = n / 2; i < n; i++) {
			secondHalf += arr[i];
		}

		System.out.println("Sum :" + sumfirstHalf * secondHalf);

	}

}
