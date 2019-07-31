
// intuit
public class SegregateEvenAndOddNumbers {
			    // fuction is rearrange the array in given way. 
		    
	static void rearrangeEvenAndOdd(int arr[], int n) 
		    { 
		        // variables 
		        int j = -1,temp; 
		      
		        // quick sort method 
		        for (int i = 0; i < n; i++) { 
		      
		            // if array of element 
		            // is odd then swap 
		            if (arr[i] % 2 != 0) { 
		      
		                // increment j by one 
		                j++; 
		      
		                // swap the element 
		                temp = arr[i]; 
		                arr[i] = arr[j]; 
		                arr[j] = temp; 
		            } 
		        } 
		    } 
	
	    // Driver code 
		    public static void main(String args[]) 
		    { 
		      //  int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 }; 
		        int[] arr = { 18, 3, 5, 2, 4, 9, 6, 7, 12, 15, 13, 14, 16 };
		        int n = arr.length; 
		      
		        rearrangeEvenAndOdd(arr, n); 
		      
		        for (int i = 0; i < n; i++) 
		            System.out.print(arr[i] + " "); 
		    } 
		} 
		 
