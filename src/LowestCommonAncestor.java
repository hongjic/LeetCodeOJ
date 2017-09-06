import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int val ){ this.val = val;}
}

public class LowestCommonAncestor {
	
	private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> nodeSet) {
		if (root == null) return null;
		if (nodeSet.contains(root)) return root;
		TreeNode ln = lowestCommonAncestor(root.left, nodeSet);
		TreeNode rn = lowestCommonAncestor(root.right, nodeSet);
		if (ln != null && rn != null)
			return root;
		return (ln == null ? rn : ln);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		TreeNode[] nodeList = {node2, node7};
		TreeNode ancestor = new LowestCommonAncestor().lowestCommonAncestor(node1, new HashSet<TreeNode>(Arrays.asList(nodeList)));
		System.out.println(ancestor.val);
	}

}
