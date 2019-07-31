package Wallmart;

public class MaximumNumberOfOneIn2DArray {
	
	static final int N =4;
	
	static void findMaxOne(int [][] arr) {
		
		int row=0, i, j;		
		for(i =0, j=N-1; i<N; i++) {
			while(arr[i][j]==1 && j>=0) {
				row =i;
				j--;
			}
		}
		System.out.println("row is "+ (row) + " and max one count is "+ (N-j-1)) ;
	}
	
	private static void findMaxZero(int[][] arr) {
		// TODO Auto-generated method stub
		
		int row=0, i, j;
		for(i =0, j=0; i<N; i++) {
			
			while(arr[i][j]==0 && j<N) {				
				row =i;
				j++;
			}	
		}
		System.out.println("row is "+ (row) + " and max zero count is "+ j) ;
	}
	
    public static void main(String[] args) { 
        int arr[][] = {{0, 0, 0, 1},  
                       {0, 1, 1, 1},  
                       {0, 0, 1, 1},  
                       {0, 1, 1, 1}}; 
        findMaxOne(arr); 
        findMaxZero(arr); 
    }

	

}
