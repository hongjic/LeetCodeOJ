package T449;

public class Codec {
	
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder preorder = new StringBuilder();
		preorderTraverse(root, preorder);
		StringBuilder inorder = new StringBuilder();
		inorderTraverse(root, inorder);
		return preorder.toString() + ' ' + inorder.toString();
	}
	
	private void inorderTraverse(TreeNode root, StringBuilder sb) {
		if (root == null) return;
		inorderTraverse(root.left, sb);
		if (sb.length() == 0) sb.append(root.val);
		else sb.append(',').append(root.val);
		inorderTraverse(root.right, sb);
	}
	
	private void preorderTraverse(TreeNode root, StringBuilder sb) {
		if (root == null) return;
		if (sb.length() == 0) sb.append(root.val);
		else sb.append(',').append(root.val);
		preorderTraverse(root.left, sb);
		preorderTraverse(root.right, sb);
	}
	
	public TreeNode deserialize(String data) {
		if (data.length() == 0) return null;
		String[] d = data.split(" ");
		String[] preorder = d[0].split(","), inorder = d[1].split(",");
		return deserialize(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private TreeNode deserialize(String[] preorder, int pl, int pr, String[] inorder, int il, int ir) {
		if (pl > pr) return null;
		int val = Integer.valueOf(preorder[pl]);
		TreeNode root = new TreeNode(val);
		int left = il, right = ir;
		while (left < right) {
			int mid = (left + right) / 2;
			if (Integer.valueOf(inorder[mid]) < val) left = mid + 1;
			else right = mid;
		}
		root.left = deserialize(preorder, pl + 1, pl + left - il, inorder, il, left - 1);
		root.right = deserialize(preorder, pl + left - il + 1, pr, inorder, left + 1, ir);
		return root;
	}
	
	public static void main(String[] args) {
		Codec codec = new Codec();
		System.out.println(codec.serialize(codec.deserialize("4,2,1,3,7,5,6 1,2,3,4,5,6,7")));
		System.out.println(codec.serialize(codec.deserialize("")));
		System.out.println(codec.serialize(null));
	}
}
