
public class CountPossibleStrings {

	public static void main(String[] args) {

		String s = "12240";

		// 1,1,22; 1,12,2; 11,22; 11,2,2; 1,1,2,2;

		System.out.println(numDecodings(s));
	}

	private static int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));

			int second = Integer.valueOf(s.substring(i - 2, i));

			if (first >= 1 && first <= 9) {
				arr[i] += arr[i - 1];
			}

			if (second >= 10 && second <= 26) {
				arr[i] += arr[i - 2];
			}
		}
		return arr[n];
	}

}
