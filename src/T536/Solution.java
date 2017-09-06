package T536;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	public TreeNode str2tree(String s) {
		if (s.length() == 0) return null;
		String v = getNext(s, 0);
		int p = v.length();
		TreeNode root = new TreeNode(Integer.valueOf(v));
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (p < s.length()) {
			if (s.charAt(p) == '(') {
				p ++; continue;
			}
			if (s.charAt(p) == ')') {
				stack.pop(); 
				p ++; continue;
			}
			v = getNext(s, p);
			TreeNode node = new TreeNode(Integer.valueOf(v));
			if (stack.peek().left == null) stack.peek().left = node;
			else stack.peek().right = node;
			stack.push(node);
		
			p += v.length();
		}
		return root;
	}
	
	private String getNext(String s, int index) {
		StringBuffer sb = new StringBuffer();
		int i = index;
		while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')')
			sb.append(s.charAt(i ++));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "4(2(-3)(1))(6(5))";
//		String s = "";
		TreeNode root = new Solution().str2tree(s);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
	}

}
