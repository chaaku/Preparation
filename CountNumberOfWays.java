import java.util.ArrayList;
import java.util.Arrays;

public class CountNumberOfWays {
//	static final int arr [] = {1,2,5}; // all-1, 115, 151, 511, 16, 61
	 static int factcount=0;
	public static void main(String[] args) {
		int arr [] = {5,2,1};
		int N =7;
		
		int array [] = {5,2,3,6,3,1};
		int sum =10;
		
		findSubset(array, sum);
//		System.out.println(countWays(N));
//		int Nums [] = {1,5,2};
//		int size=arr.length;
//		int numofways = ways_num(N,Nums,size);
	//	System.out.println(numofways);

		int res = getCountToReachTarget(arr, N);
		System.out.println(res);
		System.out.println("from DP : "+getCountDp(arr, N));
}	
	static int count = 0;
	
	static void findSubset(int [] arr, int sum){
		// 1 2 4 3 5 6 
		Arrays.sort(arr);		
		ArrayList<Integer> current = new ArrayList<>();
		findSub(arr, sum, current,0);
		
	}

	private static void findSub(int[] arr, int target, ArrayList<Integer> current, int index) {
		// TODO Auto-generated method stub
		
		if(target == 0){
		//	System.out.println("sum "+current);
			System.out.println(current);
		}else{
			for(int i = index; i<arr.length; i++){
				if(arr[i] > target) continue;
				current.add(arr[i]);
				findSub(arr, target-arr[i], current, index+1);
				//System.out.println(current);
				current.remove(current.size()-1);
			}
		}
		
	}

	private static int getCountToReachTarget(int [] nums, int target){
		ArrayList<Integer> current = new ArrayList<>();
		//Arrays.sort(nums);
		backtrack(nums, target, current);
		return count;
		
		
	}

	private static int backtrack(int [] nums, int target, ArrayList<Integer> current){
		// bsae case
		if(target == 0){
		//	System.out.println("sum "+current);
			count++;
		}else{
			for(int i = 0; i<nums.length; i++){
				if(nums[i] > target) continue;
				current.add(nums[i]);
				backtrack(nums, target-nums[i], current);
				//System.out.println(current);
				current.remove(current.size()-1);
			}
		}
		return count;
	} 
	
	private static int getCountDp(int [] nums, int target){
		int [] result = new int[target+1];
		result[0] = 1;

		for(int i = 1; i<=target; i++){
			for(int j = 0; j <nums.length; j++){
				if(nums[j] <= i){
					result[i] += result[i-nums[j]];
					//System.out.println("result array :"+result[i]);
				}
			}
		}

		return result[target];
	}
}
