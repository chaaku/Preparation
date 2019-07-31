package Try_1;

public class NthUglyNumber {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(ugly(n));

	}

	private static int ugly(int n) {
		// TODO Auto-generated method stub
		int arr[] = new int[n];
		arr[0] = 1;

		int ugly_Number = 1;
		int multiple_of_2 = 2;
		int multiple_of_3 = 3;
		int multiple_of_5 = 5;
		int countof2 = 0, countof3 = 0, countof5 = 0;

		for (int i = 1; i < n; i++) {

			ugly_Number = Math.min(multiple_of_2, Math.min(multiple_of_5, multiple_of_3));
			arr[i] = ugly_Number;

			if (ugly_Number == multiple_of_2) {
				countof2++;
				multiple_of_2 = arr[countof2] * 2;
			}
			if (ugly_Number == multiple_of_3) {
				countof3++;
				multiple_of_3 = arr[countof3] * 3;
			}
			if (ugly_Number == multiple_of_5) {
				countof5++;
				multiple_of_5 = arr[countof5] * 5;
			}

		}
		return arr[n - 1];
	}

}
