package T105;

public class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) return null;
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
		if (pl > pr) return null;
		TreeNode root = new TreeNode(preorder[pl]);
		int mid = il;
		for (mid = il; mid <= ir; mid ++)
			if (inorder[mid] == preorder[pl]) break;
		root.left = buildTree(preorder, pl + 1, pl + mid - il, inorder, il, mid - 1);
		root.right = buildTree(preorder, pl + mid - il + 1, pr, inorder, mid + 1, ir);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[] {1,2};
		int[] inorder = new int[] {2,1};
		TreeNode root = new Solution().buildTree(preorder, inorder);
	}

}
