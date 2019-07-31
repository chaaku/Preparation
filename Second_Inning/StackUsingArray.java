package Second_Inning;

public class StackUsingArray {

	int size;
	int arr[];
	int top;

	StackUsingArray(int size) {
		this.size = size;
		this.top = -1;
		this.arr = new int[size];

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (size - 1 == top);
	}

	public int peek() {
		return arr[top];
	}

	public void push(int pushedElement) {

		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
		} else
			System.out.println("Stack is full");
	}

	public int pop() {
		if (!isEmpty()) {
			int returned = arr[top];
			top--;
			return returned;
		}

		else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public static void main(String[] args) {

		StackUsingArray s = new StackUsingArray(10);
		s.push(20);
		s.push(50);
		s.push(80);
		s.push(40);
		s.push(60);
		s.push(75);
		s.push(50);
		s.push(80);
		s.push(40);
		s.push(60);
		s.push(75);

		System.out.println("peek : " + s.peek());

		System.out.println("Size: " + s.size);

		while (!s.isEmpty())
			System.out.println(s.pop());
	}

}
