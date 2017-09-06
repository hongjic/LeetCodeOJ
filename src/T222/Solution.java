package T222;

public class Solution {
	
	private int height(TreeNode root) {
		return root == null ? 0 : 1 + height(root.left);
	}

	public int countNodes(TreeNode root) {
		int h = height(root);
		if (h == 0) return 0;
		return height(root.right) == h - 1 ? (1 << h - 1) + countNodes(root.right)
				: (1 << h - 2) + countNodes(root.left);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		TreeNode node6 = new TreeNode(0);
		TreeNode node7 = new TreeNode(0);
		TreeNode node8 = new TreeNode(0);
		TreeNode node9 = new TreeNode(0);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		System.out.println(new Solution().countNodes(node1));
	}
}
