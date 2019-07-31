
public class AngleBetweenHourAndMinute {
	
	public static void main(String[] args) {
		
	//	System.out.println(calculate(12,30));
		printReversedFib(-4);
		
	}

	private static int printFibonacciInReverse(int n) {
		// TODO Auto-generated method stub

		
		if(n<=1)
			return n;
		else
			return printFibonacciInReverse(n-1) + printFibonacciInReverse(n-2);
	}
	
	static void printReversedFib(int x){
		if(x<0)
			System.out.println("Not a valid input");
		
		else if (x==1 || x==0)
			System.out.println(printFibonacciInReverse(x));
		else {
			System.out.println(printFibonacciInReverse(x));
			printReversedFib(x-1);			
		}
	}

	private static int calculate(double h, double m) {
		// TODO Auto-generated method stub
		
		if(h>12 ||m>60)
			return -1;

		int minuteAngle= (int) (6*m);
		int hourAngle = (int)(30*h +0.5*m);
		
		int angle=Math.abs(minuteAngle-hourAngle);
		return (Math.min(360-angle, angle));
		
	}

}
