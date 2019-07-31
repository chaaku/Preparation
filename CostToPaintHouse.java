import java.util.*;
public class CostToPaintHouse {

	/*
	 
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no 
two adjacent houses have the same color.
	
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] 
is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

	Java Solution
	
	A typical DP problem.
	
	*/
	public static int minCost(int[][] costs) {
	    if(costs==null||costs.length==0)
	        return 0;
	 
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
	    }
	 
	    int m = costs.length-1;
	    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}
 
public static void main(String[] args) {
		int[][] cost = new int[][] { 
				new int[] { 7, 3, 8},
				new int[] { 5, 6, 7}, // 8, 13, 10
				new int[] {4, 2, 1},  // 14, 10, 9
				new int[] {3, 9, 4},  // 12, 18, 12
				new int[] {11, 7, 2}  // 25, 19, 14 
		};

		System.out.println("Cost: " + minCost(cost));
	}
}
