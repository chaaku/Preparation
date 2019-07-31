package Second_Inning;

	// Java program to find 
	// missing and repeating 
import java.io.*; 

public class MissingAndRepeating {
 
	    static void printTwoElements(int arr[], int size) 
	    { 
	        int i; 
	        System.out.print("The repeating element is "); 
	  
	        for (i = 0; i < size; i++) { 
	            int abs_val = Math.abs(arr[i]); 
	          //  System.out.println(abs_val);
	            if (arr[abs_val - 1] > 0) 
	                arr[abs_val - 1] = -arr[abs_val - 1]; 
	            else
	                System.out.print(abs_val+" "); 
	        } 
	        System.out.println("array :");
	  for(int k:arr)
		  System.out.print(k+" ");
	        System.out.print("\nAnd the missing element is "); 
	        for (i = 0; i < size; i++) { 
	            if (arr[i] > 0) 
	                System.out.print(i + 1+" "); 
	        } 
	    } 
	  
	    /* Driver program to test above function */
	    public static void main(String[] args) 
	    { 
	        int arr[] = { 7, 3, 3,4, 5, 5, 6, 2 }; 
	        int n = arr.length; 
	        printTwoElements(arr, n); 
	    } 
	} 
	  
	// This code is contributed by Gitanjali 
