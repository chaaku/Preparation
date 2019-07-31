package SPOJ_ProblemSolving;

public class Test {

	static int arr[] = { 1, 0, 5, 7, 7, 4, 3, 6, 0, 9, 0, 6, 5, 4, 0, 9, 0, 6, 0, 6, 6 };

	public static void main(String[] args) {

		int zeroCount = 0, nonZeroCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int index = findNextZero(i);
				swapIndex(i, index);
			}
			else
				continue;
		}
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void swapIndex(int i, int index) {
		// TODO Auto-generated method stub

		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	private static int findNextZero(int i) {
		// TODO Auto-generated method stub

		int index = i;
		while (arr[i] != 0 && i < arr.length - 1) {
			index++;
		}
		return index;
	}

}
