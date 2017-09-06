package T156;

public class Solution {

	private TreeNode flip(TreeNode root, TreeNode rightSubling, TreeNode father) {
		TreeNode newRoot = null;
		if (root.left == null)
			newRoot = root;
		else 
			newRoot = flip(root.left, root.right, root);
		root.left = rightSubling;
		root.right = father;
		return newRoot;
	}
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) return null;
		return flip(root, null, null);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		TreeNode newRoot = new Solution().upsideDownBinaryTree(node1);
		System.out.println(newRoot.val);
		System.out.println(newRoot.left.val);
		System.out.println(newRoot.right.val);
		System.out.println(newRoot.right.left.val);
		System.out.println(newRoot.right.right.val);
	}

}
