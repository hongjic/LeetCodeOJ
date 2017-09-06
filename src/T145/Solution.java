package T145;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class NodeStatus {
	TreeNode node;
	boolean finish;
	NodeStatus(TreeNode n) {
		node = n; finish = false;
	}
}

public class Solution {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<NodeStatus> stack = new Stack<NodeStatus>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(new NodeStatus(node));
				node = node.left;
			}
			NodeStatus cur = stack.peek();
			if (cur.finish) {
				res.add(cur.node.val);
				stack.pop();
				node = null;
			}
			else {
				cur.finish = true;
				node = cur.node.right;
			}
		}
		return res;
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
		List<Integer> res = new Solution().postorderTraversal(node1);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
