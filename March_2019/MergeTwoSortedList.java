package March_2019;

class Node{
	Node next;
	int value;
	
	public Node(int value) {
		this.value=value;
	}
}

public class MergeTwoSortedList {
	
	public static void main(String[] args) {
		
		Node head4=  new Node(1);
		head4.next = new Node(17);
		head4.next.next = new Node(19);
		
		Node head3=  new Node(11);
		head3.next = new Node(12);
		head3.next.next = new Node(13);
		head3.next.next.next = new Node(14);
		head3.next.next.next.next = new Node(15);
		head3.next.next.next.next.next = new Node(18);
		head3.next.next.next.next.next.next = new Node(23);
		
		Node result = mergeTwoList(head3,head4);
		print(result);
			
	}

	private static void print(Node result) {
		// TODO Auto-generated method stub
		
		while(result!=null) {
			System.out.println(result.value);
			result=result.next;
		}
	}

	private static Node mergeTwoList(Node head3, Node head4) {
		// TODO Auto-generated method stub
		
		if(head3==null)
			return head4;
		
		
		if(head4==null)
			return head3;
		
		if(head3.value<head4.value) {
			head3.next= mergeTwoList(head3.next, head4);
			return head3;
		}
		else {
			head4.next= mergeTwoList(head3, head4.next);
			return head4;
		}
		
	}

}
