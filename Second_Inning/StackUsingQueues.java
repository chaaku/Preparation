package Second_Inning;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	int top = -1;
	// https://coderbyte.com/algorithm/implement-queue-using-two-stacks

	void push(int x) {
		top = x;
		queue2.add(x);
		while (!queue1.isEmpty()) {
			queue2.add(queue1.remove());
		}
		// swap the queues
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
	}

	// implement dequeue method by pushing all elements
	// from stack 1 into stack 2, which reverses the order
	// and then popping from stack 2
	int pop() {
		return queue1.remove();

	}

	// Returns top of stack
	int top() {
		if (queue1.isEmpty())
			return -1;
		return queue1.peek();
	}

	// Returns true if Stack is empty else false
	boolean isEmpty() {
		return queue1.isEmpty();
	}

	// Driver program to test above methods
	public static void main(String[] args) {
		StackUsingQueues s = new StackUsingQueues();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.top());
		System.out.println("pop element :" + s.pop());
		// s.pop();
		s.push(30);
		// s.pop();
		System.out.println("pop element :" + s.pop());
		System.out.println("Top element :" + s.top());
	}
}