package T20;

import java.util.Stack;

public class Solution {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c: s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') stack.push(c);
			if (c == ')') {
				if (stack.empty() || stack.peek() != '(') return false;
				stack.pop();
			}
			if (c == ']') {
				if (stack.empty() || stack.peek() != '[') return false;
				stack.pop();
			}
			if (c == '}') {
				if (stack.empty() || stack.peek() != '{') return false;
				stack.pop();
			}
		}
		if (stack.empty()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isValid("([)]"));
	}

}
