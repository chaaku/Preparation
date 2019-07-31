
public class Finally_Garbage_Example {

	@Override
	public void finalize() {
		System.out.println("object is garbage collected");
	}

	public String toString() {
		return "Printing from toString";
	}
	
	public static void main(String args[]) {

		Finally_Garbage_Example s1 = new Finally_Garbage_Example();
		Finally_Garbage_Example s2 = new Finally_Garbage_Example();

		// s1=null;
		s2 = null;

		System.gc();

		System.out.println("print s1  :" + s1.toString());
		System.out.println("print null :  " + null);
		System.out.println("print s2 :  " + s2.toString());

	}
}