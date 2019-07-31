package SPOJ_ProblemSolving;

import java.util.*;


class getLargest implements Comparable<getLargest>{
	int elment;
	public getLargest(int element) {
		this.elment=element;			
	}
	
	@Override
	public int compareTo(getLargest o) {
		// TODO Auto-generated method stub
		return o.elment-elment;
	}
	
}

public class FIndKthSmallestorLargestInUnsortedArray {
	public static void main(String[] args) {

		int[] arr = { 13, 45, 23, 1, 52, 41, 121, 11, 4, 67, 3, 135, 43, 33 }; 
		int k = 4;
		System.out.println("4th smallest element: " + findNthSmallest(arr, k));
		System.out.println("4th Largest element: " + findNthLargest(arr, k));
		
		System.out.print("Aftre sorting : ");
		Arrays.sort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static int findNthLargest(int[] arr, int k) {
		Queue<getLargest> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.offer(new getLargest(arr[i]));
		}
		int n = -1;
		while (k > 0) {
			n = pq.poll().elment;
			k--;
		}
		return n;
	}
	
	public static int findNthSmallest(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<>(/*stringLengthComparator*/);
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		int n = -1;
		while (k > 0) {
			n = pq.poll();
			k--;
		}
		return n;
	}

}
