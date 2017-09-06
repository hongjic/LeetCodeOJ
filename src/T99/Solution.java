package T99;

public class Solution {

	private TreeNode first, second, pre = new TreeNode(Integer.MIN_VALUE);
	
	public void recoverTree(TreeNode root) {
		traverse(root);
		
		int t = first.val; first.val = second.val; second.val = t;
	}
	
	public void traverse(TreeNode root) {
		if (root == null) return;
		traverse(root.left);
		
		if (first == null && pre.val >= root.val)
			first = pre;
		if (first != null && pre.val >= root.val)
			second = root;
		pre = root;
		
		traverse(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(3);
		node4.left = node2;
		node4.right = node6;
		node2.left = node1;
		node2.right = node3;
		node6.left = node5;
		node6.right = node7;
		System.out.println(node4.left.right.val);
		new Solution().recoverTree(node4);
		System.out.println(node4.left.right.val);
	}

}
