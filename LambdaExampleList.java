import java.util.Arrays;
import java.util.List;
public class LambdaExampleList {
	static boolean zeroFoundFlag = false;
	
	@FunctionalInterface
	interface face1{
		int operations(int a, int b);
	}
	
	public static void main(String[] args) {

		face1 add = (int x, int y)->  x+y;
		face1 multiply = (int x, int y)->  x*y;
		
		int addition = add.operations(3, 7);
		int multiplication = multiply.operations(2, 10);
	
		System.out.println("addition :"+ addition + " Multiplication :" +multiplication );
		
		//	Use of List in a lambda expression
		List <Integer> list = Arrays.asList(1,4,6,2,4,0,5,7);
		
		list.forEach(num-> {
			if(num!=0 && zeroFoundFlag ==false) 
				System.out.println(num);
			else {
				zeroFoundFlag=true;
			}
		});
		
		System.out.println("here i am");
}
}
