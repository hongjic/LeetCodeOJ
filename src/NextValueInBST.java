
public class NextValueInBST {
	
	public static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode (int v) {val = v; }
	}
	
	private int search(TreeNode root, int value) {
		if (root.val <= value) {
			if (root.right != null) { 
				return search(root.right, value);
			}
			return root.val;
		}
		// root.val > value
		if (root.left != null) {
			int result = search(root.left, value);
			if (result > value) return result;
			return root.val;
		}
		return root.val;
	}
	
	public int nextValue(TreeNode root, int value) {
		int result = search(root, value);
		if (result <= value) return -1;
		return result;
	}
	
	public static void main(String[] args) {
		NextValueInBST sol = new NextValueInBST();
		TreeNode node1 = new TreeNode(6),
				node2 = new TreeNode(4),
				node3 = new TreeNode(8),
				node4 = new TreeNode(2),
				node5 = new TreeNode(5),
				node6 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		System.out.println(sol.nextValue(node1, 8));
		
	}
}
