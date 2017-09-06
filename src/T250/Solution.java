package T250;

public class Solution {

	private int sum;
	
	public int countUnivalSubtrees(TreeNode root) {
		sum = 0;
		if (root != null) traverse(root);
		return sum;
	}
	
	// 1) uni exist return uni 2) uni doesn't exist return null 3) no element X
	private Integer traverse(TreeNode root) {
		Integer uniLeft = null, uniRight = null;
		if (root.left != null) uniLeft = traverse(root.left);
		if (root.right != null) uniRight = traverse(root.right);
		if (root.left != null && (uniLeft == null || root.val != uniLeft)) return null;
		if (root.right != null && (uniRight == null || root.val != uniRight)) return null;
		sum ++;
		return root.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(5);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.right = node6;
		System.out.println(new Solution().countUnivalSubtrees(node1));
	}

}
