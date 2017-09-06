package T124;

public class Solution {

	private int maxPath;
	
	public int maxPathSum(TreeNode root) {
		this.maxPath = Integer.MIN_VALUE;
		maxToRoot(root);
		return maxPath;
	}
	
	private Integer maxToRoot(TreeNode root) {
		if (root == null) return null;
		Integer leftMaxToRoot = maxToRoot(root.left);
		Integer rightMaxToRoot = maxToRoot(root.right);
		if (leftMaxToRoot == null && rightMaxToRoot == null) {
			maxPath = Math.max(maxPath, root.val);
			return root.val;
		}
		if (leftMaxToRoot == null) {
			int maxToRoot = root.val + Math.max(rightMaxToRoot, 0);
			maxPath = Math.max(maxPath, maxToRoot);
			return maxToRoot;
		}
		if (rightMaxToRoot == null) {
			int maxToRoot = root.val + Math.max(leftMaxToRoot, 0);
			maxPath = Math.max(maxPath, maxToRoot);
			return maxToRoot;
		}
		maxPath = Math.max(maxPath, Math.max(leftMaxToRoot, 0) + Math.max(rightMaxToRoot, 0) + root.val);
		return Math.max(0, Math.max(leftMaxToRoot, rightMaxToRoot)) + root.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(-1);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(-4);
		node1.left = node2;
		node2.left = node3;
		node3.right = node4;
		node4.left = node5;
		System.out.println(new Solution().maxPathSum(node1));
	}

}
