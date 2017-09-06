package T114;

public class Solution {

	private TreeNode pre;
	
	//post order: right, left, root
	public void flatten(TreeNode root) {
		pre = null;
		traverse(root);
	}
	
	public void traverse(TreeNode root) {
		if (root == null) return;
		TreeNode left = root.left, right = root.right;
		if (pre != null) { 
			pre.left = null;
			pre.right = root;
		}
		pre = root;
		traverse(left);
		traverse(right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		new Solution().flatten(node1);
		System.out.println(node1.val);
		System.out.println(node1.right.val);
	}

}
