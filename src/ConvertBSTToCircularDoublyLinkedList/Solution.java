package ConvertBSTToCircularDoublyLinkedList;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int v) {val = v;}
	}
	
	public static class HeadEnd {
		TreeNode head;
		TreeNode end;
		HeadEnd(TreeNode h, TreeNode e) {
			head = h; end = e;
		}
	}
	
	private HeadEnd helper(TreeNode root) {
		if (root == null) return null;
		TreeNode head = root, end = root;
		HeadEnd left = helper(root.left);
		if (left != null) {
			left.end.right = root;
			root.left = left.end;
			head = left.head;
		}
		HeadEnd right = helper(root.right);
		if (right != null) {
			root.right = right.head;
			right.head.left = root;
			end = right.end;
		}
		return new HeadEnd(head, end);
	}
	
	public TreeNode convertBSTtoCircularDoublyLinkedList(TreeNode root) {
		HeadEnd headend = helper(root);
		if (headend == null) return null;
		headend.end.right = headend.head;
		headend.head.left = headend.end;
		return headend.head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1),
				node2 = new TreeNode(2),
				node3 = new TreeNode(3),
				node4 = new TreeNode(4),
				node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		TreeNode head = sol.convertBSTtoCircularDoublyLinkedList(node1);
		System.out.println(head.val);
		TreeNode cur = head.right;
		while (cur != head) {
			System.out.println(cur.val);
			cur = cur.right;
		}
	}

}
