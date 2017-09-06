package T106;

public class Solution {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	
	private TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
		if (il > ir) return null;
		TreeNode root = new TreeNode(postorder[pr]);
		int mid = il;
		while (inorder[mid] != postorder[pr]) mid ++;
		root.left = buildTree(inorder, il, mid - 1, postorder, pl, pl + mid - 1 - il);
		root.right = buildTree(inorder, mid + 1, ir, postorder, pl + mid - il, pr - 1);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = new int[] {4,2,5,1,6,3,7};
		int[] postorder = new int[] {4,5,2,6,7,3,1};
		TreeNode root = new Solution().buildTree(inorder, postorder);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}

}
