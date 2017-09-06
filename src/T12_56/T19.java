package T12_56;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class T19 {
	
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1 = head;
		ListNode p2 = p1;
		for (int i=0; i<n-1; i++)
			p2 = p2.next;
		if (p2.next==null)
			return head.next;
		while (p2.next.next!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln1 = new ListNode(1);
//		ListNode ln2 = new ListNode(2);
//		ListNode ln3 = new ListNode(3);
//		ListNode ln4 = new ListNode(4);
//		ListNode ln5 = new ListNode(5);
//		ln1.next = ln2;
//		ln2.next = ln3;
//		ln3.next = ln4;
//		ln4.next = ln5;
		ListNode ln = removeNthFromEnd(ln1, 1);
		
	}

}
