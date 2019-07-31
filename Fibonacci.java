
public class Fibonacci{

	public static void main(String agrs[]){

		int n1=0,n2=1,n3,i,count=10;    
		
		System.out.print(n1+" "+n2); //printing 0 and 1    
		    
		 while(count>2) //loop starts from 2 because 0 and 1 are already printed    
		 {    
			 n3=n1+n2;    
			 
			 System.out.print(" "+n3);    
			 n1=n2;    
			 n2=n3;  
			 count--;
		 }    
	}
}

// using iteration
//public class Fibonacci {
//
//	public static int fib(int n) {
//		return n < 2 ? n : fib(n - 1) + fib(n - 2);
//	}
//
//	public static void main(String[] args) {
//		for (int i = 0; i <= 10; i++) {
//			System.out.print(fib(i) + " ");
//		}
//		System.out.println("...");
//	}
//}

// using recursion
/*
 * class Fibonacci{
 * 
 * 
 * static int n1=0,n2=1,n3=0; 
 * public static void main(String args[]){
	  int count=10;
	  System.out.print(n1+" "+n2);
	  fib(count-2); 
  	}
  static void fib(int n){
  	if(n>0)
 * 	{ 
 * 		n3 = n1 + n2; 
 * 		n1 = n2; 
 * 		n2 = n3; 
 * 		System.out.print(" "+n3); 
 * 		fib(n-1);
 * 	} 
 * }
 * 
 * 
 * }
 */
