package Matrix;

public class Matrix {
	public static void main(String[] args) {
		Matrix m = new Matrix();
		int[][] matrix1 = new int[][] { { 1, 6, 11, 16, 21 }, { 2, 7, 12, 17, 22 }, { 3, 8, 13, 18, 23 },
				{ 4, 9, 14, 19, 24 }, { 5, 10, 15, 20, 25 } };

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Matrix: ");
		Matrix.printMatrix(matrix);

		int[][] transpose = m.transpose(matrix);
		System.out.println("\nTranspose of Matrix");
		Matrix.printMatrix(transpose);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		m.horizontalReflection(matrix);
		System.out.println("\nHorizontal Reflection of Matrix");
		Matrix.printMatrix(matrix);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		m.verticalReflection(matrix);
		System.out.println("\nVertical Reflection of Matrix");
		Matrix.printMatrix(matrix);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		transpose = m.transpose(matrix);
		m.horizontalReflection(transpose);
		System.out.println("\n90 degree rotation of Matrix( Transpose -> horizontal reflection )");
		Matrix.printMatrix(transpose);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		m.horizontalReflection(matrix);
		m.verticalReflection(matrix);
		System.out.println("\n180 degree rotation of Matrix ( horizontal reflection -> Vertical reflection  )");
		Matrix.printMatrix(matrix);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		m.horizontalReflection(matrix);
		transpose = m.transpose(matrix);
		System.out.println("\n270 degree rotation of Matrix ( transpose -> verticsl revlection )");
		Matrix.printMatrix(transpose);

		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// m.ms(matrix);
		transpose = m.transpose(matrix);
		m.horizontalReflection(transpose);
		m.verticalReflection(transpose);
		System.out.println("\nMS interview question");
		Matrix.printMatrix(transpose);

	}

	/*
	 * Method to get transpose of a matrix. It creates a new matrix to copy the
	 * elements because the physical structure of the matrix may change as a part of
	 * the transpose operation in case its not a square matrix.
	 */
	public int[][] transpose(int[][] mat) {
		if (mat == null)
			return null;

		int m = mat.length;
		int n = mat[0].length;
		
		int[][] matResult = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matResult[j][i] = mat[i][j];
			}
		}
		return matResult;
	}

	/*
	 * Method to get the horizontal reflection of the matrix.
	 */
	public void horizontalReflection(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int temp = 0;
		for (int i = 0; i < m / 2; i++) {
			for (int j = 0; j < n; j++) {
				temp = mat[i][j];
				mat[i][j] = mat[m - (i + 1)][j];
				mat[m - (i + 1)][j] = temp;
			}
		}
	}

	/*
	 * Method to get the vertical reflection of the given matrix
	 */
	public void verticalReflection(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int temp = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n / 2; j++) {
				temp = mat[i][j];
				mat[i][j] = mat[i][n - (j + 1)];
				mat[i][m - (j + 1)] = temp;
			}
		}
	}

	/*
	 * Utility method to print the matrix.
	 */
	public static void printMatrix(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println();
		}
	}
}