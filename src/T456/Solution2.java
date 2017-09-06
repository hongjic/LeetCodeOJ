package T456;

import java.util.Stack;

public class Solution2 {

	//O(n)  s1 s2 s3     s1 < s3 < s2
	public boolean find132pattern(int[] nums) {
		int s3 = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = nums.length - 1; i >= 0; i --) {
			// we already have s2(int stack) and s3, if we find a number smaller than s3, than it is a valid 132 pattern 
			if (nums[i] < s3) return true;
			else
				// our purpose is to find the max s3
				while (!stack.empty() && nums[i] > stack.peek()) 
					s3 = stack.pop();
			stack.push(nums[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution2().find132pattern(new int[] {3,5,4,6,2,1}));
	}

}
