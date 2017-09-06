package T57_100;

public class T61 {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	private ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		// initialize the two point( k in distance ) and check whether
		// k is greater than the list length.
		ListNode p1 = head, p2 = p1, p3 = null;
		for (int i = 0; i < k; i ++) {
			p2 = p2.next;
			if (p2 == null) {
				k = k % (i + 1);
				break;
			}
		}
		if (k == 0) return head;
		p2 = p1;
		for (int i = 0; i < k; i ++)
			p2 = p2.next;
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p3 = p1.next;
		p1.next = null;
		p2.next = head;
		return p3;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T61 t61 = new T61();
		ListNode ln1 = new ListNode(1),
				ln2 = new ListNode(2),
				ln3 = new ListNode(3),
				ln4 = new ListNode(4),
				ln5 = new ListNode(5);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = null;
		int k = 2;
		ListNode head = t61.rotateRight(ln1, k);
		while (head != null) {
			System.out.println(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}

}
