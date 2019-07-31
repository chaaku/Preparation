package JudgementDay;

public class RemoveDuplicateFromArray {
	

	public static void main(String[] args) {

		 int[] nums = { 2, 3, 1,2 };
		 int[] arr = { 4, 5,6,7,3,1,2, 1, 5, 1, 3,7, 1 };
		
		System.out.print("Non duplicates : ");

		String str = convertToString1(arr);
		
		for(int i=0; i<str.length();i++) {
			char ch =str.charAt(i);
			
			if(str.indexOf(ch)==str.lastIndexOf(ch))
				System.out.print(ch+ " ");
			else
				continue;
		}
		
//		for (int i = 0; i < arr.length; i++) {
//
//			int temp = arr[i];
//			
//			if (str.indexOf(Integer.toString(temp)) == str.lastIndexOf(Integer.toString(temp))) {
//				System.out.print(temp + " ");
//				
//			} else
//				continue;
//		}
		System.out.println();
		System.out.print("Duplicates : ");

		findDuplicateInArray(nums);

	}

	private static void findDuplicateInArray(int [] nums) {
		// TODO Auto-generated method stub

		for(int i=0;i<nums.length;i++) {	
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
			}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]<0) {
				System.out.print(Math.abs(nums[i])+" ");
			}
		}
	}
	public static String convertToString1(int [] arr) {
		String str = "";
		for (int i : arr)
			str += Integer.toString(i);

		return str;
	}

}
