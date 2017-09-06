package T155;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> min;
	
	public MinStack() {
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
	}
	
	public void push(int x) {
		if (min.isEmpty() || x <= min.peek())
			min.push(x);
		stack.push(x);
	}
	
	public void pop() {
		int p = stack.pop();
		if (min.peek() == p) min.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return min.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());
	}

}
