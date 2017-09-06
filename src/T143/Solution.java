package T143;

public class Solution {

	public void reorderList(ListNode head) {
		if (head == null) return;
		int len = getLength(head);
		int rightIndex = (len + 1) / 2;
		ListNode leftEnd = getNode(head, rightIndex - 1), rightStart = leftEnd.next;
		leftEnd.next = null;
		ListNode reversedRight = reverseList(rightStart);
		// one by one combine left and reversedRight
		ListNode left = head, right = reversedRight, pre = null;
		boolean isLeft = true;
		while (left != null || right != null) {
			ListNode cur = null;
			if (isLeft) {
				cur = left;
				left = left.next;
			}
			else {
				cur = right;
				right = right.next;
			}
			if (pre != null) pre.next = cur;
			pre = cur; isLeft = !isLeft;
		}
		pre.next = null;
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len ++; head = head.next;
		}
		return len;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode node = head, pre = null;
		while (node != null) {
			ListNode next = node.next;
			node.next = pre; pre = node; node = next;
		}
		return pre;
	}
	
	private ListNode getNode(ListNode head, int index) {
		for (int i = 0; i < index; i ++)
			head = head.next;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode head = node1;
		node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
		node5.next = node6; node6.next = node7; node7.next = node8; node8.next = node9;
		new Solution().reorderList(head);
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
