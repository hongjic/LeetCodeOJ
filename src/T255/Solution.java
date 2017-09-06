package T255;

import java.util.Stack;

public class Solution {

	public boolean verifyPreorder(int[] preorder) {
		int root = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int num: preorder) {
			if (num < root) return false;
			while (!stack.empty() && num > stack.peek()) 
				root = stack.pop();
			stack.push(num);
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[]{2,1};
		System.out.println(new Solution().verifyPreorder(preorder));
	}

}
