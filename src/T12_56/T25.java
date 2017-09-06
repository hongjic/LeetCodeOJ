package T12_56;

public class T25 {

	private static ListNode reverseKGroup(ListNode head, int k) {
		if (k==1) return head;
		ListNode check = head;
		ListNode[] reverse = new ListNode[k];
		for (int i=0; i<k; i++) {
			if (check==null) return head;
			reverse[i] = check;
			check = check.next;
		}
		for (int i=k-1; i>0; i--)
			reverse[i].next = reverse[i-1];
		reverse[0].next = reverseKGroup(check, k);
		return reverse[k-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		l1.next= l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;l7.next=l8;
		ListNode head = reverseKGroup(l1, 2);
		while (head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		
	}

}
