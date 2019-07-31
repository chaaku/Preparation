package Wallmart;

	// JAVA code to partition a set into two subsets 
	// such that the difference of subset sums 
	// is minimum 
import java.util.*; 
public class W5 {
//		public static void main(String[] args) 
//		{ 
//			int arr[] = {3, 1, 4, 2, 2, 1}; 
//			int n = arr.length;
//			int sum= 0;
//			for(int i:arr)
//				sum+=i;
//			
//			System.out.println(minimumDifference(arr,n,0,sum));
//		}
//		private static int minimumDifference(int[] arr, int i, int sumTillHere, int totalSum) {
//			// TODO Auto-generated method stub
//			
//			if(i==0) {
//				Math.abs((totalSum-sumTillHere)-sumTillHere);
//			}
//			
//			return Math.min(minimumDifference(arr, i-1, sumTillHere + arr[i-1], totalSum),minimumDifference(arr, i-1, sumTillHere, totalSum));	
//		} 
//}
	   // Function to find the minimum sum 
    public static int findMinRec(int arr[], int n,int sumCalculated, int sumTotal) 
    { 
        // If we have reached last element. 
        // Sum of one subset is sumCalculated, 
        // sum of other subset is sumTotal- 
        // sumCalculated.  Return absolute  
        // difference of two sums. 
        if (n == 0) 
            return Math.abs((sumTotal-sumCalculated) - sumCalculated); 
       
        // For every item arr[i], we have two choices 
        // (1) We do not include it first set 
        // (2) We include it in first set 
        // We return minimum of two choices 
        return Math.min(findMinRec(arr, n - 1, sumCalculated  + arr[n-1], sumTotal),  findMinRec(arr, n-1, sumCalculated, sumTotal)); 
    } 
       
    // Returns minimum possible difference between 
    // sums of two subsets 
    public static int findMin(int arr[], int n) 
    { 
        // Compute total sum of elements 
        int sumTotal = 0; 
        for (int i = 0; i < n; i++) 
            sumTotal += arr[i]; 
       
        // Compute result using recursive function 
        return findMinRec(arr, n, 0, sumTotal); 
    } 
      
    /* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = {3, 1, 4, 2, 2, 1}; 
        int n = arr.length; 
        System.out.print("The minimum difference"+  " between two sets is " + findMin(arr, n)); 
    } 
} 