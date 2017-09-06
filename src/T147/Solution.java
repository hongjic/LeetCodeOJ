package T147;

public class Solution {

	public ListNode insertionSortList(ListNode head) {
		if (head == null) return null;
		ListNode sorted = head, p = head.next;
		sorted.next = null;
		while (p != null) {
			ListNode next = p.next;
			sorted = addNode(sorted, p);
			p = next;
		}
		return sorted;
	}
	
	private ListNode addNode(ListNode head, ListNode add) {
		ListNode node = head, pre = null;
		while (node != null && node.val < add.val) {
			pre = node;
			node = node.next;
		}
		if (pre == null) {
			add.next = head; return add;
		}
		add.next = node; pre.next = add;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(6);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(5);
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
		node5.next = node6; node6.next = node7; node7.next = node8; node8.next = node9;
		ListNode sorted = new Solution().insertionSortList(null);
		while (sorted != null) {
			System.out.print(sorted.val + ", ");
			sorted = sorted.next;
		}
	}

}
