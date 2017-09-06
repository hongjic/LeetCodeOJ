package T450;

public class Solution {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		// find key
		TreeNode node = root, pre = null; boolean left = true;
		while (node.left != null 
				|| node.right != null) {
			if (key > node.val) {
				pre = node; node = node.right; left = false;
			}
			else if (key < node.val) {
				pre = node; node = node.left; left = true;
			}
			else break;
		}
		if (node.val != key) return root; // not found
		if (pre == null) return deleteNode(node);
		if (left) pre.left = deleteNode(node);
		else pre.right = deleteNode(node);
		return root;
	}
	
	// delete root
	private TreeNode deleteNode(TreeNode root) {
		TreeNode left = root.left, right = root.right;
		if (left == null && right == null) return null;
		if (left == null) return right;
		if (right == null) return left;
		TreeNode t = right.left, node = left;
		// add t to left ( all nodes in t are larger than left)
		while (node.right != null) node = node.right;
		node.right = t;
		right.left = left;
		return right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.right = node6;
		TreeNode root = new Solution().deleteNode(node1, 3);
	}

}
