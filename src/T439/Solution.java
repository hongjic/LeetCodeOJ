package T439;

import java.util.Stack;

class Expression{
	boolean flag;
	String option1, option2;
	Expression(char condition) {
		flag = false;
		if (condition == 'T') flag = true;
	}
	
	String value() {
		return flag ? option1 : option2;
	}
}

public class Solution {
	
	public String parseTernary(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
		String res = "";
		int i = 0;
		while (i < expression.length() && (!stack.empty() || i == 0)) {
			while (i + 1 < expression.length() && expression.charAt(i + 1) != ':') {
				stack.push(new Expression(expression.charAt(i)));
				i += 2;
			}
			if (stack.peek().option1 == null) stack.peek().option1 = String.valueOf(expression.charAt(i));
			else stack.peek().option2 = String.valueOf(expression.charAt(i));
			while (stack.peek().option1 != null && stack.peek().option2 != null) {
				res = stack.pop().value(); 
				if (stack.empty()) break;
				if (stack.peek().option1 == null) stack.peek().option1 = res;
				else stack.peek().option2 = res;
			}
			i += 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().parseTernary("F?T:F?T?1:2:F?3:4"));
	}

}
