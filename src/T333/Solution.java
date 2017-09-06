package T333;

public class Solution {
	
	private static class Info{
		int size, max, min;
		boolean bst;
		public Info(int s, boolean f) {
			size = s; bst = f;
		}
	}

	private int maxSize;
	
	public int largestBSTSubtree(TreeNode root) {
		maxSize = 0;
		traverse(root);
		return maxSize;
	}
	
	private Info traverse(TreeNode root) {
		if (root == null) return new Info(0, true);
		if (root.left == null && root.right == null) {
			Info info = new Info(1, true);
			info.max = root.val; info.min = root.val;
			if (info.size > maxSize) maxSize = info.size;
			return info;
		}
		Info leftInfo = traverse(root.left), rightInfo = traverse(root.right);
		if (!leftInfo.bst || !rightInfo.bst) return new Info(0, false);
		if ((leftInfo.size == 0 || leftInfo.max < root.val) && (rightInfo.size == 0 || rightInfo.min > root.val)) {
			Info info = new Info(rightInfo.size + leftInfo.size + 1, true);
			if (leftInfo.size == 0) info.min = root.val;
			else info.min = leftInfo.min; 
			if (rightInfo.size == 0) info.max = root.val;
			else info.max = rightInfo.max;
			if (info.size > maxSize) maxSize = info.size;
			return info;
		}
		return new Info(0, false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		System.out.println(new Solution().largestBSTSubtree(null));
	}

}
