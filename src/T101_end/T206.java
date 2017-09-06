package T101_end;

public class T206 {
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode cur = head,
				pre = null;
		while (cur != null) {
			ListNode t = cur.next;
			cur.next = pre;
			pre = cur;
			cur = t;
		}
		return pre;
	}

}
