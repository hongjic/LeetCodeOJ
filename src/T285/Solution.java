package T285;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	
	private static class Status {
		private boolean find;
		public Status() { find = false; }
		public void found() { find = true; }
		public boolean isFound() { return find; }
	}
	
	private TreeNode helper(TreeNode root, TreeNode p, Status status) {
		if (root == null) return null;
		TreeNode node = null;
		node = helper(root.left, p, status);
		if (node != null) return node;
		if (status.isFound()) return root;
		if (p == root) status.found();
		node = helper(root.right, p, status);
		return node;
	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return helper(root, p, new Status());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		TreeNode node1 = new TreeNode(1),
				node2 = new TreeNode(2),
				node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		TreeNode result = sol.inorderSuccessor(node1, node3);
		if (result != null)
			System.out.println(result.val);
		else System.out.println("null");
	}

}
