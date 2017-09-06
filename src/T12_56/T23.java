package T12_56;


public class T23 {

//	private static ListNode mergeKLists(ListNode[] lists) {
//		if (lists.length==0) return null;
//		int min = Integer.MAX_VALUE, min_index = 0;
//		ListNode min_node = null;
//		for (int i=0; i<lists.length; i++) 
//			if (lists[i]!=null && min>lists[i].val) {
//				min = lists[i].val;
//				min_node = lists[i];
//				min_index = i;
//			}
//		if (min_node==null) return null;
//		lists[min_index] = lists[min_index].next;
//		min_node.next = mergeKLists(lists);
//		return min_node;
//	}
	
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val<=l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
	}
	
	private static ListNode helper(ListNode[] lists, int s, int t) {
		int n = t-s+1;
		if (n==1) return lists[s];
		if (n==2) return mergeTwoLists(lists[s], lists[s+1]);
		int p = n/2;
		//divide into 2 lists
		return mergeTwoLists(helper(lists, s, s+p-1), helper(lists, s+p, t));
	}
	
	private static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length==0) return null;
		if (lists.length==1) return lists[0];
		return helper(lists, 0, lists.length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
