package T129;

public class Solution {

	private int sum;
	
	public int sumNumbers(TreeNode root) {
		sum = 0;
		traverse(root, 0);
		return sum;
	}
	
	private void traverse(TreeNode root, int num) {
		if (root == null) return;
		int cur = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += cur;
			return;
		}
		traverse(root.left, cur);
		traverse(root.right, cur);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2; node1.right = node3;
		System.out.println(new Solution().sumNumbers(node1));
		
	}

}
