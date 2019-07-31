package Wallmart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class W1 {

	static int count =0;
	public static void main(String[] args) {	
		int arr [] = {3,2,1};
		int N =4;
		findSubset(arr, N);
		
	}

	private static void findSubset(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(backTrack(arr,n,list,0));
		list.clear();
	}

	private static int backTrack(int[] arr, int target, List<Integer> list,int index) {
		// TODO Auto-generated method stub
		
		if(target==0)
			count++;
		else {
		for(int i=index; i<arr.length;i++) {
			
			if(arr[i]>target) continue ;
			list.add(arr[i]);
			backTrack(arr, target-arr[i], list,i);
			list.remove(list.size()-1);
		}
		}
		return count;
	}
}
