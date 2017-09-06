package T160;

public class Solution {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = getLength(headA), lenB = getLength(headB);
		if (lenA < lenB) return binarySearch(headA, lenA, headB, lenB);
		else return binarySearch(headB, lenB, headA, lenA);
	}
	
	private ListNode binarySearch(ListNode head1, int len1, ListNode head2, int len2) {
		int left1 = 0, right1 = len1 - 1, left2 = len2 - len1, right2 = len2 - 1;
		while (left1 < right1) {
			int mid1 = (left1 + right1) / 2, mid2 = (left2 + right2) / 2;
			if (getNode(head1, mid1) == getNode(head2, mid2)) {
				right1 = mid1; right2 = mid2;
			}
			else {
				left1 = mid1 + 1; left2 = mid2 + 1;
			}
		}
		ListNode n1 = getNode(head1, left1), n2 = getNode(head2, left2);
		return n1 == n2 ? n1 : null;
	}
	
	private ListNode getNode(ListNode head, int index) {
		for (int i = 0; i < index; i ++)
			head = head.next;
		return head;
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len ++; head = head.next;
		}
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		ListNode b1 = new ListNode(6);
		ListNode b2 = new ListNode(7);
		ListNode b3 = new ListNode(8);
		a1.next = a2; a2.next = c1; c1.next = c2; c2.next = c3;
		b1.next = b2; b2.next = b3; 
		ListNode node = new Solution().getIntersectionNode(null, null);
		System.out.println(node == null ? "null" : node.val);
	}

}
