package T101_end;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class T144 {
	
	
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) return result;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Boolean> left = new Stack<Boolean>();
		Stack<Boolean> right = new Stack<Boolean>();
		nodeStack.push(root);
		left.push(false);
		right.push(false);
		result.add(root.val);
		while (!nodeStack.isEmpty()) {
			TreeNode cur = nodeStack.peek();
			if (left.peek() == false) {
				if (cur.left == null) 
					left.set(left.size() - 1, true);
				else {
					nodeStack.push(cur.left);
					left.push(false);
					right.push(false);
					result.add(cur.left.val);
				}
			}
			else if (right.peek() == false){
				if (cur.right == null)
					right.set(right.size() - 1, true);
				else {
					nodeStack.push(cur.right);
					left.push(false);
					right.push(false);
					result.add(cur.right.val);
				}
			}
			else {
				while (!left.isEmpty() && left.peek() && right.peek()) {
					nodeStack.pop();
					left.pop();
					right.pop();
				}
				if (!left.isEmpty())
					if (left.peek() == false)
						left.set(left.size() - 1, true);
					else 
						right.set(right.size() - 1, true);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T144 t144 = new T144();
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode root = new TreeNode(1);
		root.right = n1;
		n1.left = n2;
		List<Integer> result = t144.preorderTraversal(root);
		for (int i = 0; i < result.size(); ++ i)
			System.out.print(result.get(i) + " ");
	}

}
