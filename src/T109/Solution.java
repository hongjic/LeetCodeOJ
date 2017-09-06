package T109;

public class Solution {

	public TreeNode sortedListToBST(ListNode head) {
		int length = getLength(head);
		return transfer(head, length);
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len ++; head = head.next;
		}
		return len;
	}
	
	private TreeNode transfer(ListNode head, int length) {
		if (length < 1) return null;
		int mid = (length + 1) / 2 - 1;
		ListNode node = head;
		for (int i = 0; i < mid; i ++) node = node.next;
		TreeNode root = new TreeNode(node.val);
		root.left = transfer(head, (length + 1) / 2 - 1);
		root.right = transfer(node.next, length - (length + 1) / 2);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2; node2.next = node3; node3.next = node4;
		node4.next = node5; node5.next = node6;
		TreeNode root = new Solution().sortedListToBST(node1);
		System.out.println(root.val);
		System.out.println(root.right.val);
	}

}
