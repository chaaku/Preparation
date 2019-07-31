package src.Matrix;

public class PrintSpiralMatrix {
	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		boolean leftToRight = true;

		System.out.println("Matrix: ");
		Matrix.printMatrix(arr);
		System.out.println("\nSpiral: \n");
		
		int m = arr.length;
		int n = arr[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (leftToRight)
					System.out.print(arr[i][j] + " ");
				else
					System.out.print(arr[i][n - (j + 1)] + " ");
			}
			System.out.println();

			if (leftToRight)
				leftToRight = false;
			else
				leftToRight = true;
		}

	}
}
