package T232;

import java.util.Stack;

public class MyQueue {
	
	private Stack<Integer> stack, reverse;
	private boolean flag;
	
	public MyQueue() {
		stack = new Stack<Integer>();
		reverse = new Stack<Integer>();
		flag = true;
	}

	public void push(int x) {
		if (!flag) reverseBack();
		stack.push(x);
	}
	
	public void pop() {
		if (flag) reverse();
		reverse.pop();
	}
	
	public int peek() {
		if (flag) reverse();
		return reverse.peek();
	}
	
	public boolean empty() {
		if (flag) return stack.isEmpty();
		return reverse.isEmpty();
	}
	
	private void reverse() {
		while (!stack.isEmpty()) reverse.push(stack.pop());
		flag = false;
	}
	
	private void reverseBack() {
		while (!reverse.isEmpty()) stack.push(reverse.pop());
		flag = true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
