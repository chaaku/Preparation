package SPOJ_ProblemSolving;

import java.util.Stack;

public class TwoStackInAnArray {

	int size;
	int top1, top2;
	int[] arr;

	TwoStackInAnArray(int n) {
		size = n;
		top1 = -1;
		top2 = size;
		arr = new int[n];
	}

	public static void main(String[] args) {

		TwoStackInAnArray ts = new TwoStackInAnArray(5);
		
		ts.push1(1);
		ts.push2(3);
		ts.push1(4);
		ts.push2(5);
		ts.push2(6);

		System.out.println("popped element from stack one is : " + ts.pop1());
		System.out.println("popped element from stack two is : " + ts.pop2());
		System.out.println("popped element from stack one is : " + ts.pop1());
		System.out.println("popped element from stack one is : " + ts.pop1());

	}

	void push1(int x) {
		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	void push2(int i) {

		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = i;
		} else {
			System.out.println("Overflow Stack 2");
			System.exit(1);
		}
	}

	int pop1() {

		if (top1 >= 0) {
			int x = arr[top1];
			top1--;
			return x;
		} else {
			System.out.println("Stack Underflow 1");
			System.exit(1);
		}
		return 0;
	}

	int pop2() {

		if (top2 < size) {
			int x = arr[top2];
			top2++;
			return x;
		} else {
			System.out.println("Stack Underflow 2");
			System.exit(1);
		}
		return 0;
	}
}
