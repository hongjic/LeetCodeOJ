package T84;

import java.util.Stack;


public class Solution2 {
	
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0, len = heights.length;
		int i = 0;
		while (i < len) {
			if (stack.empty() || heights[i] >= heights[stack.peek()])
				stack.push(i ++);
			else {
				int top = stack.pop();
				max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		while (!stack.empty()) {
			int top = stack.pop();
			max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = new int[] {2,1,5,6,3,4,7,8,2,9,3,6,7,8,2,4,3,6,7,7,7};
		System.out.println(new Solution2().largestRectangleArea(heights));
	}

}
