package T230;

public class Solution {

	private static class Result {
		int num;
		TreeNode node;
		Result(int x, TreeNode n) {
			num = x;
			node = n;
		}
	}


	public int kthSmallest(TreeNode root, int k) {
		Result result = search(root, k, 0);
		return result.node.val;
	}
	
	private Result search(TreeNode root, int k, int before) {
		if (root == null)
			return new Result(before, null);
		Result leftR = search(root.left, k, before);
		if (leftR.node != null) return leftR;
		if (leftR.num == k - 1) return new Result(k, root);
		Result rightR = search(root.right, k, leftR.num + 1);
		if (rightR.node != null) return rightR;
		return rightR;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node3.left = node2;
		node2.left = node1;
		node3.right = node5;
		node5.left = node4;
		node5.right = node6;
		System.out.println(new Solution().kthSmallest(node3, 7));
	}

}
