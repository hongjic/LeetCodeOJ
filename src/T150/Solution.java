package T150;

import java.util.Stack;

/*
 * The time of this implementation shows try catch is very slow.
 */

public class Solution {

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i ++) 
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(calculate(tokens[i], left, right));
			}
			else 
				stack.push(Integer.parseInt(tokens[i]));
		return stack.pop();
	}
	
	private int calculate(String operator, int left, int right) {
		if (operator.equals("+"))
			return left + right;
		else if (operator.equals("-"))
			return left - right;
		else if (operator.equals("*"))
			return left * right;
		else
			return left/ right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = new String[] {"2", "1", "+", "3", "*"};
		System.out.println(new Solution().evalRPN(tokens));
	}

}
