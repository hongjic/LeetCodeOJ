package T148;

public class Solution {

	public ListNode sortList(ListNode head) {
		int len = 0;
		if (head == null) return null;
		ListNode node = head;
		while (node != null) {
			len ++; node = node.next;
		}
		return sortList(head, len);
	}
	
	private ListNode sortList(ListNode head, int length) {
		if (length == 1) return head;
		ListNode node = head;
		int half = length / 2 - 1;
		while (half > 0) {
			half --; node = node.next;
		}
		// must sort right part first, otherwise "node.next" may be modified
		ListNode cur = null, pre = null, rp = sortList(node.next, length - length / 2), lp = sortList(head, length / 2);
		head = null;
		int il = 0, ir = 0;
		while (il < length / 2 || ir < length - length / 2) {
			if (il == length / 2 || ( il < length / 2 && ir < length - length / 2 && rp.val < lp.val)) {
				cur = rp;
				if (pre != null) pre.next = cur;
				pre = cur; rp = rp.next; ir ++;
			}
			else {
				cur = lp;
				if (pre != null) pre.next = cur;
				pre = cur; lp = lp.next; il ++;
			}
			if (head == null) head = pre;
		}
		pre.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode node1 = new ListNode(5);
//		ListNode node2 = new ListNode(4);
//		ListNode node3 = new ListNode(6);
//		ListNode node4 = new ListNode(3);
//		ListNode node5 = new ListNode(7);
//		ListNode node6 = new ListNode(2);
//		ListNode node7= new ListNode(8);
//		ListNode node8 = new ListNode(1);
//		ListNode node9 = new ListNode(9);
//		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
//		node5.next = node6; node6.next = node7; node7.next = node8; node8.next = node9;
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		ListNode head = new Solution().sortList(node1);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
