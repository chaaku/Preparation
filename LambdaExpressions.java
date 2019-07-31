
public class LambdaExpressions {

	@FunctionalInterface
	interface LambdaExample {
		public void draw();
	}

	public static void main(String[] args) {

		int width = 10;

		LambdaExample le = () -> {
			System.out.println("Drawing with with width : " + width);
		};
		le.draw();
	}

}
