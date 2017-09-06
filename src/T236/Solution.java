package T236;

public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	private static class Result {
		boolean foundP, foundQ;
		TreeNode result;
		Result() {
			foundP = false;
			foundQ = false;
			result = null;
		
		}
		Result(Result left, Result right) {
			foundP = left.foundP || right.foundP;
			foundQ = left.foundQ || right.foundQ;
		}
		
		boolean success() {
			if (foundP && foundQ) return true;
			return false;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return binarySearchAncestor(root, p, q).result;
	}
	
	private Result binarySearchAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result();
		Result leftResult = binarySearchAncestor(root.left, p, q);
		if (leftResult.result != null) return leftResult;
		Result rightResult = binarySearchAncestor(root.right, p, q);
		if (rightResult.result != null) return rightResult;
		Result result = new Result(leftResult, rightResult);
		if (root == p) result.foundP = true;
		if (root == q) result.foundQ = true;
		if (result.success()) result.result = root;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
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
		TreeNode LCA = sol.lowestCommonAncestor(node1, node3, node6);
		System.out.println(LCA.val);
	}

}
