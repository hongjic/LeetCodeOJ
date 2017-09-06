package T543;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	private int max;
	
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		max = Integer.MIN_VALUE;
		getMaxDepth(root);
		return max;
	}
	
	private int getMaxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);
		if (left + right > max) max = left + right;
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		System.out.println(new Solution().diameterOfBinaryTree(node1));
	}

}
