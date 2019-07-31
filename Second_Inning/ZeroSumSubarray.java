package Second_Inning;

public class ZeroSumSubarray {

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	static int subArraySum(int arr[], int n, int sum) {
		if(arr.length<=0)
			return -1;
		
		int curr_sum, i, j; boolean found=false;
		// Pick a starting point
		for (i = 0; i < n; i++) {
			curr_sum = arr[i];

			// try all subarrays starting with 'i'
			for (j = i + 1; j <= n; j++) {
				if (curr_sum == sum) {
					int p = j - 1;
					System.out.println("Sum found between indexes " + i + " and " + p);
					//j++;
					found=true;
				}
				if (curr_sum > sum || j == n)
					break;
				curr_sum = curr_sum + arr[j];
			}
		}
		
		if(found==false)
		System.out.println("No subarray found");
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 23,10 };
		int n = arr.length;
		int sum = 23;
		subArraySum(arr, n, sum);
	}
}