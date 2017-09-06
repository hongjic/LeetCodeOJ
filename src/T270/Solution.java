package T270;

public class Solution {

	public int closestValue(TreeNode root, double target) {
		double droot = Math.abs(target - (double) root.val);
		if (root.val < target && root.right != null) {
			int closestRight = closestValue(root.right, target);
			if (Math.abs(target - (double)closestRight) < droot) return closestRight;
		}
		if (root.val > target && root.left != null) {
			int closestLeft = closestValue(root.left, target);
			if (Math.abs(target - (double)closestLeft) < droot) return closestLeft;
		}
		return root.val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		System.out.println(new Solution().closestValue(node4, 7.9));
	}

}
