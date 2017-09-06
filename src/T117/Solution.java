package T117;

public class Solution {

	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode preHead = root, curHead = null, curEnd = null;
		while (preHead != null) {
			TreeLinkNode father = preHead;
			while (father != null) {
				if (father.left != null) {
					if (curHead == null) curHead = father.left;
					if (curEnd != null) curEnd.next = father.left;
					curEnd = father.left;
				}
				if (father.right != null) {
					if (curHead == null) curHead = father.right;
					if (curEnd != null) curEnd.next = father.right;
					curEnd = father.right;
				}
				father = father.next;
			}
			preHead = curHead;
			curHead = null; curEnd = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(7);
		node1.left = node2; node1.right = node3; node2.left = node4;
		node2.right = node5; node3.right = node6;
		new Solution().connect(node1);
	}

}
