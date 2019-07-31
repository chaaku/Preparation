
public class StackUsingLinkedList {

	private Node head;

	public static class Node {
		int value;
		Node next;

	}

	public boolean find(int findthis) {

		if (head != null) {

			while (head.next != null) {

				if (head.value == findthis)
					return true;
				else
					head = head.next;
			}

		} else {

			System.out.println("Stack is empty");
			return false;
		}
		return false;
	}

	public int pop() {

		if (head != null) {

			int returned = head.value;
			head = head.next;
			return returned;

		} else {

			System.out.println("Stack is empty");
			return -1;
		}
	}

	public void push(int pushed) {

		Node oldHead = head;

		head = new Node();
		head.value = pushed;
		head.next = oldHead;

	}

	public int size() {

		int count = 0;

		if (head != null) {

			while (head.next != null) {

				count = count + 1;
				head = head.next;
			}

		} else {

			count = -1;
			;

		}

		return count;

	}

	public int peek() {

		return (head.value);
	}

	public static void main(String[] args) {

		StackUsingLinkedList lls = new StackUsingLinkedList();

		lls.push(20);
		lls.push(50);
		lls.push(80);
		lls.push(40);
		lls.push(60);
		lls.push(75);

		System.out.println("Size in start : " + lls.size());

		System.out.println("Searching for element : " + lls.find(50));
		System.out.println("Element removed from LinkedList: " + lls.pop());
		System.out.println("Element removed from LinkedList: " + lls.pop());
		lls.push(10);
		System.out.println("Element removed from LinkedList: " + lls.pop());

		System.out.println("Size in end  : " + lls.size());
		printList(lls.head);

	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
}
