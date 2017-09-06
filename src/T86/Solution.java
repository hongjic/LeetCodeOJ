package T86;

public class Solution {

	public ListNode parition(ListNode head, int x) {
		ListNode p1 = head, p2 = head, pre1 = null, pre2 = null;
		while (p2 != null) {
			while (p2 != null && p2.val >= x) {
				pre2 = p2;
				p2 = p2.next;
			}
			if (p2 == null) break;
			// pre2 即为需要调换的前一个
			if (pre1 != pre2) {
				ListNode t = p2;
				p2 = p2.next;
				ListNode headNew = swap(pre1, pre2, head);
				pre1 = t;
				if (headNew != null) head = headNew;
			}
			else {
				pre1 = p1;
				p1 = p1.next;
				pre2 = p2;
				p2 = p2.next;
			}
		}
		return head;
	}
	
	private ListNode swap(ListNode pre1, ListNode pre2, ListNode head) {
		ListNode p2 = null;
		if (pre2 == null) {
			p2 = head;
			head = head.next;
		}
		else {
			p2 = pre2.next;
			pre2.next = pre2.next.next;
		}
		if (pre1 == null) {
			p2.next = head;
			return p2;
		}
		p2.next = pre1.next;
		pre1.next = p2;
		return null;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode head = new Solution().parition(node1, 3);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

}
