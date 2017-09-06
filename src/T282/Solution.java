package T282;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	private static final String[] adds = {"*", "+", "-", ""};
	
	private static final Map<Character, Integer> priority;
	
	static {
		priority = new HashMap<Character, Integer>(3);
		priority.put('.', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
	}
	
	private boolean isNumber(char c) {
		return (c >= 48 && c <= 57); 
	}
	
	private long cal2(long num1, long num2, char op) {
		if (op == '*') 
			return num1 * num2;
		if (op == '+')
			return num1 + num2;
		return num1 - num2;
	}
	
	private long calculate(String exp) {
		Stack<Long> numbers = new Stack<Long>();
		Stack<Character> ops = new Stack<Character>();
		int len = exp.length();
		int i = 0; 
		StringBuffer numberBuffer = new StringBuffer();
		while (i < len) {
			char c = exp.charAt(i);
			if (isNumber(c)) {
				numberBuffer.append(c);
			}
			else {
				//  将堆栈顶优先级大于等于当前操作符的操作完成
				long number = Long.valueOf(numberBuffer.toString());
				numberBuffer.delete(0, numberBuffer.length());
				while (!ops.isEmpty() && priority.get(ops.peek()) >= priority.get(c)) {
					long preNumber = numbers.pop();
					number = cal2(preNumber, number, ops.pop());
				}
				// 将数字放入堆栈中
				numbers.push(number);
				// 将当前符号放入堆栈
				ops.push(c);
			}
			i ++;
		}
		return numbers.peek();
	}
	
	private void getAll(String num, int len, int index, int target, List<String> results, StringBuffer result) {
		if (index == len - 1) {
			result.append(num.charAt(index));
			String resultStr = result.toString();
			if (calculate(resultStr + '.') == target)
				results.add(resultStr);
			result.deleteCharAt(result.length() - 1);
			return;
		}
		int options = adds.length;
		if ((result.length() == 0 || !isNumber(result.charAt(result.length() - 1))) && num.charAt(index) == '0')
			options = adds.length - 1;
		result.append(num.charAt(index));
		for (int i = 0; i < options; i ++) {
			result.append(adds[i]);
			getAll(num, len, index + 1, target, results, result);
			if (!adds[i].equals("")) result.deleteCharAt(result.length() - 1);
		}
		result.deleteCharAt(result.length() - 1);
	}

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		if (num == null || num.length() == 0) return result;
		getAll(num, num.length(), 0, target, result, new StringBuffer());
		return result;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> result = sol.addOperators("10009", 9);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
		
	}

}
