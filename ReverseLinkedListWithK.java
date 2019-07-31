package Wallmart;

class LinkedListNode
{
	int data;
	LinkedListNode next;

	LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
}

	// Helper function to print linked list starting from current node
	public void print()
	{
		LinkedListNode ptr = this;
		while (ptr.next != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}
		System.out.println(ptr.data);
	}
};

public class ReverseLinkedListWithK {
	
	
	// Method implementations
	
	private static LinkedListNode reverseInGroups(LinkedListNode head, int k) {
		// TODO Auto-generated method stub
		
		if(head==null)
			return null;
		
		LinkedListNode previous =null;
		LinkedListNode current =head;
		
		int count =0;
		while(current!=null && count++< k) {
			LinkedListNode next = current.next;
			current.next= previous;
			previous= current;
			current=next;
		}
		
		head.next = reverseInGroups(current,k);
		return previous;
	}

	public static void main(String[] args) {
		
		int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8 };

		LinkedListNode head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new LinkedListNode(keys[i], head);
		}

		head = reverseInGroups(head, 3);
		head.print();
	}

		
}
	
