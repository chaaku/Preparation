
public class LambdaExpressionExample {

	@FunctionalInterface
	interface drawable {
		public void draw();
	}

	public static void main(String[] args) {

		int width = 10;

		// Without Lambda expressiom

		drawable d = new drawable() {

			@Override
			public void draw() {
				// TODO Auto-generated method stub
				System.out.println("draw without lambda :  " + width);
			}
		};

		d.draw();

		// with lambda expression

		drawable d2 = () -> {
			// do your work
			System.out.println("draw with lambda : " + width);
		};

		d2.draw();

	}

}
