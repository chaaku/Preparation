package Wallmart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestInAnArrayInWindow {
	
	public static void main(String[] args) {
		
		int arr [] = {1,5,2,6,3,1,24,7};
		int k =3;
		findMax(arr,k);		
	}
	
	private static void findMax(int[] arr, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		
		System.out.print("Max windows :");
		for(int i=0; i<=n-k;i++) {
			System.out.print(findMaxInWindow(Arrays.copyOfRange(arr,i,n),k)+" ");
		}
		System.out.print("\nMin windows :");
		for(int i=0; i<=n-k;i++) {
			System.out.print(findMinInWindow(Arrays.copyOfRange(arr,i,n),k)+" ");
		}
		System.out.print("\nSum windows :");
		for(int i=0; i<=n-k;i++) {
			System.out.print(findSumInWindow(Arrays.copyOfRange(arr,i,n),k)+" ");
		}
		
//		System.out.print("\nSum windows :");
//
//		int index=0 ; 
//		for(int i=0; i<=n-k;i++) {
//			int intermediate[] = new int[arr.length];
//			for(int j =i; j<n;j++) {
//				intermediate[index++] = arr[j];
//			}
//			System.out.print(findSumInWindow(intermediate,k)+" ");
//		}
		
	}


	private static int findMaxInWindow(int[] copyOfRange, int k) {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE;
		for(int i=0;i<k;i++) {
			if(copyOfRange[i]>max)
				max=copyOfRange[i];
		}
		return max;
	}
	
	private static int findMinInWindow(int[] copyOfRange, int k) {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		for(int i=0;i<k;i++) {
			if(copyOfRange[i]<min)
				min=copyOfRange[i];
		}
		return min;
	}
	
	private static int findSumInWindow(int[] copyOfRange, int k) {
		// TODO Auto-generated method stub
		
		int sum=0;
		for(int i=0;i<k;i++) {
			sum+=copyOfRange[i];
		}
		return sum;
	}

}
