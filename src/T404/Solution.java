package T404;

public class Solution {

	private int sum;
	
	public int sumOfLeftLeaves(TreeNode root) {
		sum = 0;
		traverse(root, false);
		return sum;
	}
	
	private void traverse(TreeNode root, boolean left) {
		if (root == null) return;
		if (root.left == null && root.right == null && left) sum += root.val;
		traverse(root.left, true); traverse(root.right, false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
