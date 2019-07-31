package SPOJ_ProblemSolving;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	private static int max_length;

	public static void main(String[] args) {

		 int arr [] = {10, 22, 9,10,11,12, 33, 21, 50, 41, 60,45,54,56};

		//int arr[] = { 9,3,7, 4, 5 , 6,1, 3, 6, 9, 10, 12 };
		// int arr [] = {60, 52, 49,31, 23, 12};// 9,3,7, 4, 5 , 6,1};

		// int arr [] = {10, 22, 9};

		int n = arr.length;

		System.out.println("Length of lIS is : " + lengthOfLIS(arr));
		System.out.println("Length of length Of LIS LogN is : " + lengthOfLISLogN(arr));

	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] lis = new int[n]; // dp[0] = 0
		int max = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(lis[i], max);
		}
		return max + 1; // Continuously increased max times, the sequence length is max+1
	}

	public static int lengthOfLISLogN(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
				list.add(nums[i]);
			} else {
				int index = binarySearch(list, nums[i]);
				//System.out.println("for " + nums[i] +" index is : "+index);
				list.set(index, nums[i]);
				//System.out.println(list);
			}
		}
		return list.size();
	}

	public static int binarySearch(List<Integer> list, int target) {
		int start = 0;
		int end = list.size() - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid) == target) {
				return mid;
			} else if (list.get(mid) < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return list.get(start) >= target ? start : end;
	}

}
