package SPOJ_ProblemSolving;

public class MoveAllZeroInStart {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 7, 7, 4, 3, 6, 0, 9, 0, 6, 5, 4, 0, 9, 0, 6, 0, 6, 6 };
		int j=-1;
		for (int i = 0; i < arr.length; i++) {	
			if(arr[i]==0) {
				j++;
				swap(arr,j,i);
			}
		}
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void swap(int arr[], int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
