	package Second_Inning;

	import java.util.Arrays;
	import java.util.Map.Entry;
	import java.util.TreeMap;

	public class TripletWithASum {

		static int min = Integer.MAX_VALUE;

		private class TripLetNumbers {
			int first, second, third;

			public TripLetNumbers(int first, int second, int third) {
				this.first = first;
				this.second = second;
				this.third = third;
			}

			@Override
			public String toString() {
				return this.first + " " + this.second + " " + this.third;

			}

		}

		// returns true if there is triplet with sum equal
		// to 'sum' present in A[]. Also, prints the triplet
		boolean find3Numbers(int A[], int arr_size, int sum) {
			int l, r;

			/* Sort the elements */
			Arrays.sort(A);

			TreeMap<Integer, TripLetNumbers> map = new TreeMap<>();

			/*
			 * Now fix the first element one by one and find the other two elements
			 */
			for (int i = 0; i < arr_size - 2; i++) {

				// To find the other two elements, start two index variables
				// from two corners of the array and move them toward each
				// other
				l = i + 1; // index of the first element in the remaining elements
				r = arr_size - 1; // index of the last element
				while (l < r) {

					if (A[i] + A[l] + A[r] == sum) {
						System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
						return true;
					} else if (A[i] + A[l] + A[r] < sum) {

						int diff = sum - (A[i] + A[l] + A[r]);
						if (min > diff) {
							min = diff;
							map.put(min, new TripLetNumbers(A[i], A[l], A[r]));
						}
						l++;
					} else {
						// A[i] + A[l] + A[r] > sum
						int diff = (A[i] + A[l] + A[r] - sum);
						if (diff < min) {
							min = diff;
							map.put(min, new TripLetNumbers(A[i], A[l], A[r]));
						}
						r--;
					}
				}
			}

			for (Entry<Integer, TripLetNumbers> entry : map.entrySet()) {

				System.out.println("Key : " + entry.getKey() + " " + "value : " + entry.getValue().toString());
				// break;
			}
			// If we reach here, then no triplet was found
			return false;
		}

		// Driver program to test above functions
		public static void main(String[] args) {
			TripletWithASum triplet = new TripletWithASum();
			int A[] = { 1, 4, 45, 6, 10, 8 };
			int sum = 32;
			int arr_size = A.length;

			triplet.find3Numbers(A, arr_size, sum);
		}
	}