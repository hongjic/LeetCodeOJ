package T538;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	private int sum;
	
	public TreeNode convertBST(TreeNode root) {
		sum = 0;
		inorder(root);
		overWrite(root);
		return root;
	}
	
	private void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		inorder(root.right);
		sum += root.val;
	}
	
	private void overWrite(TreeNode root) {
		if (root == null) return;
		overWrite(root.left);
		int t = root.val;
		root.val = sum;
		sum -= t;
		overWrite(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(13);
		node1.left = node2;
		node1.right = node3;
		new Solution().convertBST(node3);
		System.out.println(node1.val);
		System.out.println(node2.val);
		System.out.println(node3.val);
	}

}
