package T360;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	private int calculate(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int[] result = new int[nums.length];
		if (a == 0) {
			if (b == 0)
				for (int i = 0; i < nums.length; i ++)
					result[i] = c;
			else if (b > 0) 
				for (int i = 0; i < nums.length; i ++)
					result[i] = calculate(nums[i], a, b, c);
			else 
				for (int i = nums.length - 1; i >= 0; i --)
					result[nums.length - 1 - i] = calculate(nums[i], a, b, c);
			return result;
		}
		double mid = (double) b / (-2 * a);
		int left = Arrays.binarySearch(nums, (int)mid);
		if (left >= 0) {
			if (mid < 0) left --;
		}
		else {
			left = -left - 2;
		}
		int right = left + 1;
		if (a > 0) {
			int i = left, j = right, k = 0;
			while (i >= 0 || j < nums.length) {
				if (i < 0 || (i >= 0 && j < nums.length && Math.abs((double)nums[j] - mid) <= Math.abs((double)nums[i] - mid)))
					result[k ++] = calculate(nums[j ++], a, b, c);
				else
					result[k ++] = calculate(nums[i --], a, b, c);
			}
		}
		else {
			int i = 0, j = nums.length - 1, k = 0;
			while (i <= left || j >= right) {
				if (i > left || (i <= left && j >= right && Math.abs((double)nums[j] - mid) >= Math.abs((double)nums[i] - mid)))
					result[k ++] = calculate(nums[j --], a, b, c);
				else
					result[k ++] = calculate(nums[i ++], a, b, c);
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = new Solution().sortTransformedArray(new int[] {-4, -2, 2, 4}, -1, 3, 5);
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + ", ");
	}

}
