package T331;

import java.util.Stack;

class NodeStatus {
	String val;
	boolean finish;
	NodeStatus(String x) {
		val = x; finish = false;
	}
}

public class Solution {

	public boolean isValidSerialization(String preorder) {
		String[] vals = preorder.split(",");
		int i = 0, len = vals.length;
		Stack<NodeStatus> stack = new Stack<NodeStatus>();
		while (i < len && (!stack.isEmpty() || i == 0)) {
			while (i < len && !vals[i].equals("#"))
				stack.push(new NodeStatus(vals[i ++]));
			if (!stack.isEmpty()) {
				NodeStatus p = stack.peek();
				if (!p.finish) p.finish = true;
				else {
					while (!stack.isEmpty() && stack.peek().finish) stack.pop();
					if (!stack.isEmpty()) stack.peek().finish = true;
				}
			}
			i ++;
		}
		if (i < len || !stack.isEmpty()) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String preorder = "1,#,#,#";
		System.out.println(new Solution().isValidSerialization(preorder));
	}

}
