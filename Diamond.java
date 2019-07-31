class Diamond {

	public static void main(String[] args) {
		int noOfRows = 10;

		// Getting midRow of the diamond

		int midRow = (noOfRows) / 2;

		// Initializing row with 1

		int row = 1;
		System.out.println("Here Is Your Diamond of " + noOfRows + " rows :");
		System.out.println();
		// Printing upper half of the diamond

		for (int i = 5; i > 0; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing j *'s at the end of each row

			for (int j = 1; j <= row; j++) {
				System.out.print(j + " ");
			}

			System.out.println();

			// Incrementing the row

			row++;
		}

		// Printing lower half of the diamond
		/*
		 * for (int i = 0; i <= midRow; i++) { //Printing i spaces at the beginning of
		 * each row
		 * 
		 * for (int j = 1; j <= i; j++) { System.out.print(" "); }
		 * 
		 * //Printing j *'s at the end of each row
		 * 
		 * for (int j = row; j > 0; j--) { System.out.print("* "); }
		 * 
		 * System.out.println();
		 * 
		 * //Decrementing the row
		 * 
		 * row--; }
		 */}
}
