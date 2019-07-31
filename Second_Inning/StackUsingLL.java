package Second_Inning;

import java.util.LinkedList;
import java.util.EmptyStackException;

public class StackUsingLL<E> {

	private LinkedList<E> ll;

	public StackUsingLL() {
		ll = new LinkedList<E>();
	}

	public void push(E item) {
		ll.add(item);
	}

	public E pop() {
		if (!isEmpty())
			return ll.remove(size() - 1);
		else
			throw new EmptyStackException();
	}

	public boolean isEmpty() {
		return (ll.size() == 0);
	}

	public E peek() {
		if (!isEmpty())
			return ll.get(size() - 1);
		else
			throw new EmptyStackException();
	}

	public int size() {
		return ll.size();
	}

	@Override
	public String toString() {
		return "MyStack [al=" + ll.toString() + "]";

	}

	public static void main(String[] args) {
		StackUsingLL st = new StackUsingLL();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);

		try {
			System.out.println(" entries in stack : ");

			while (!st.isEmpty())
				System.out.println(st.pop());

		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}

		try {
			st.pop();
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
	}
}
