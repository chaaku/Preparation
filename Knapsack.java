public class Knapsack {
	public static void main(String[] args) {

		int[] val = new int[] { 60, 100, 340, 320, 100, 120 };
		int[] wt = new int[] { 10, 20, 30, 35, 45, 60 };
		int W = 80;
		int n = val.length;

		System.out.println(knapsack(W, wt, val, n));
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static int knapsack(int W, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub

		
		if (n == 0)
			return 0;

		if (wt[n - 1] > W)
			return knapsack(W, wt, val, n - 1);

		else {
			return max(val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1), knapsack(W, wt, val, n - 1));
		}
	}
}
