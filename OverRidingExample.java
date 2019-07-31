class Rectangle extends OverRidingExample {
	@Override
	public void draw() {
		System.out.println("Drawing rectangle");
	}
}

class Circle extends OverRidingExample {
	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}
}

public class OverRidingExample {

	public void draw() {
		System.out.println("Drawing Shape");
	}
	
	public static void main(String[] args) {
		
		OverRidingExample s0 = new OverRidingExample();
		s0.draw();
		
		OverRidingExample s1 = new Rectangle();
		s1.draw();

		OverRidingExample s2 = new Circle();
		s2.draw();
	}

}

