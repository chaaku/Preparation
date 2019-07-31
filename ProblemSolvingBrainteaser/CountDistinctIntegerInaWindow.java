package ProblemSolvingBrainteaser;

// Simple Java program to count distinct elements in every 
// window of size k 

import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctIntegerInaWindow {
	
	static int max =0;

	// Counts distinct elements in window of size k
	static int countWindowDistinct(int win[], int k) {
		// int dist_count = 0;
		//
		//// // Traverse the window
		// for (int i = 0; i < k; i++)
		// {
		// int j;
		// for (j = 0; j < i; j++) {
		// if (win[i] == win[j])
		// break;
		// }
		// if (j == i)
		// dist_count++;
		// }
		//// return dist_count;

		// HashMap approach
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0, dist_count = 0;
		for (int i = 0; i < k; i++) {
			if (!map.containsKey(win[i])) {
				dist_count++;
			}
			map.put(win[i], ++count);
		}
		return dist_count;
	}

	// Counts distinct elements in all windows of size k
	static void countDistinct(int arr[], int n, int k) {
		// Traverse through every window
		System.out.print("Distinct count in the window : ");
		for (int i = 0; i <= n - k; i++) {
			System.out.print(countWindowDistinct(copyOfRange(arr, i, arr.length), k) + " ");
		}

		System.out.print("\nMaximum integer in the window : ");
		for (int i = 0; i <= n - k; i++) {
			System.out.print(findMaximuminAllWindow(copyOfRange(arr, i, arr.length), k) + " ");
		}
	}
	
	public static int[] copyOfRange(int[] original, int from, int to) {
		int [] copy = new int[to];
		
		int k=0;
		for(int i =from; i<to;i++) {
			copy[k++] = original[i];
		}
		return copy;
	}
	
	public static void slidingWindow(int[] nums, int k) {

		for (int i = 0; i < nums.length - k; i++) {
			int max = nums[i];
			for (int j = i+1; j < k; j++) {
				if (nums[i + j] > max)
					max = nums[i + j];
			}
			System.out.print(max + " ");
		}
	}

	private static int findMaximuminAllWindow(int[] win, int k) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			if (win[i] > max)
				max = win[i];
		}

		return max;
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 3;

		countDistinct(arr, arr.length, k);
		System.out.print("\n With new function maximum ");
		countDistinct1(arr, arr.length, k,0);
		System.out.print("\nSliding window Naive : ");
		slidingWindow(arr, k);
	}

	private static void countDistinct1(int[] arr, int length, int k, int limit) {
		// TODO Auto-generated method stub
		
		for(int i=limit++; i<k;i++) {
			if(arr[i]>max)
				max= arr[i];
		}
		System.out.print(max+ " ");
		for(int j=limit; j<length-k;j++) {
			countDistinct1(arr, length, k, j);
		}
	}
}