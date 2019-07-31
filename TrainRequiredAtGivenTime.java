package Wallmart;

import java.util.Arrays;

public class TrainRequiredAtGivenTime {
	private static int platformRequired(int[] arr, int[] dep, int n) {
		// TODO Auto-generated method stub
		
		Arrays.sort(dep);
		
		int res=1, plat=1, i=1, j=0;
		
		while(i<n&& j<n) {
			if(arr[i]<=dep[j]) {
				plat++;
				i++;
				if(res<plat)
					res=plat;
				}
			else {
				plat--;
				j++;
			}
		}
		return res;
	}
	public static void main(String[] args) {

	    int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    int n = arr.length; 
	    
	    System.out.println("Minimum Number of Platforms Required = " +platformRequired(arr, dep, n)); 
	}

}
