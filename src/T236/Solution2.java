package T236;

import T236.Solution.TreeNode;

public class Solution2 {

	private TreeNode anc;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		anc = null;
		find(root, p, q);
		return anc;
	}
	
	private boolean[] find(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return new boolean[2];
		boolean[] res = new boolean[2];
		boolean[] left = find(root.left, p, q);
		if (anc != null) return null;
		boolean[] right = find(root.right, p, q);
		if (anc != null) return null;
		res[0] = left[0] || right[0] || root == p;
		res[1] = left[1] || right[1] || root == q;
		if (res[0] && res[1] && anc == null) anc = root;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5),
				node2 = new TreeNode(3),
				node3 = new TreeNode(1),
				node4 = new TreeNode(4),
				node5 = new TreeNode(8),
				node6 = new TreeNode(6),
				node7 = new TreeNode(9);
		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node1.right = node5;
		node5.left = node6;
		node5.right = node7;
		TreeNode anc = new Solution2().lowestCommonAncestor(node1, node3, node6);
		System.out.println(anc.val);
	}

}
