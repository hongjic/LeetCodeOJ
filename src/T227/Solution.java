package T227;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
	
	private static Map<Character, Integer> p;
	
	static {
		p = new HashMap<Character, Integer>();
		p.put('+', 1);
		p.put('-', 1);
		p.put('*', 2);
		p.put('/', 2);
	}

	public int calculate(String s) {
		// if number put in stack, if operater and priority is less than the previous one,
		// calculate previous
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i ++)
			if (s.charAt(i) != ' ')
				sb.append(s.charAt(i));
		char[] ss = sb.toString().toCharArray();
		len = ss.length;
		int i = 0;
		while (i < len) {
			if (ss[i] >= '0' && ss[i] <= '9') {
				int num = 0;
				while (i < len && ss[i] >= '0' && ss[i] <= '9')
					num = num * 10 + ss[i ++] - 48;
				nums.push(num);
			}
			else { //ss[i] = operator
				while (!ops.isEmpty() && p.get(ss[i]) <= p.get(ops.peek())) {
					int num2 = nums.pop(), num1 = nums.pop();
					char op = ops.pop();
					nums.push(calculateOne(num1, num2, op));
				}
				ops.push(ss[i ++]);
			}
		}
		while (!ops.isEmpty()) {
			int num2 = nums.pop(), num1 = nums.pop();
			char op = ops.pop();
			nums.push(calculateOne(num1, num2, op));
		}
		return nums.pop();
	}
	
	private int calculateOne(int num1, int num2, char op) {
		if (op == '+') return num1 + num2;
		if (op == '-') return num1 - num2;
		if (op == '*') return num1 * num2;
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().calculate("3 + 2 * 2 2 - 3 * 5"));
	}

}
