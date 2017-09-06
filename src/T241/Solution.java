package T241;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> nums = new ArrayList<Integer>();
		List<Character> ops = new ArrayList<Character>();
		parseInput(input, nums, ops);
		return searchWays(nums, ops, 0, nums.size() - 1);
	}
	
	private List<Integer> searchWays(List<Integer> nums, List<Character> ops, int left, int right) {
		if (left == right) return Arrays.asList(nums.get(left));
		if (left + 1 == right) return Arrays.asList(calculateOne(nums.get(left), nums.get(right), ops.get(left)));
		List<Integer> res = new ArrayList<Integer>();
		for (int mid = left; mid <= right - 1; mid ++) {
			List<Integer> leftWays = searchWays(nums, ops, left, mid);
			List<Integer> rightWays = searchWays(nums, ops, mid + 1, right);
			for (int i = 0; i < leftWays.size(); i ++)
				for (int j = 0; j < rightWays.size(); j ++)
					res.add(calculateOne(leftWays.get(i), rightWays.get(j), ops.get(mid)));
		}
		return res;
	}
	
	private int calculateOne(int left, int right, char op) {
		if (op == '+') return left + right;
		if (op == '-') return left - right;
		return left * right;
	}
	
	private void parseInput(String input, List<Integer> nums, List<Character> ops) {
		char[] s = input.toCharArray();
		int i = 0;
		while (i < s.length) {
			if (s[i] >= '0' && s[i] <= '9') {
				int num = 0;
				while (i < s.length && s[i] >= '0' && s[i] <= '9')
					num = num * 10 + s[i ++] - 48;
				nums.add(num);
				i --;
			}
			else ops.add(s[i]);
			i ++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new Solution().diffWaysToCompute("2*3-4*5");
		for (int i = 0 ; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
