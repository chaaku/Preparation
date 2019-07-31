package Second_Inning;

class BaseF implements Cloneable {

	int i;
	String s;

	public BaseF(int i, String s) {
		this.i = i;
		this.s = s;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class CloneableExample {

	public static void main(String[] args) throws CloneNotSupportedException {

		BaseF a = new BaseF(20, "This is clone");
		BaseF b = (BaseF) a.clone();

		System.out.println(b.i);
		System.out.println(b.s);
	}
}
