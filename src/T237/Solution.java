package T237;

public class Solution {

	// this problem is misleading. ignore it.
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
