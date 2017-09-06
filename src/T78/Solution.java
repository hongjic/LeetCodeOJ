package T78;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	private void helper(boolean[] tf, int len, int index, List<List<Integer>> result, int[] nums) {
		if (index == len) {
			List<Integer> one = new ArrayList<Integer>();
			for (int i = 0; i < len; i ++)
				if (tf[i]) one.add(nums[i]);
			result.add(one);
			return;
		}
		tf[index] = true;
		helper(tf, len, index + 1, result, nums);
		tf[index] = false;
		helper(tf, len, index + 1, result, nums);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) 
			return result;
		int len = nums.length;
		helper(new boolean[len], len, 0, result, nums);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = {1, 2, 3};
		List<List<Integer>> set = sol.subsets(nums);
		for (int i = 0; i < set.size(); i ++) {
			for (int j = 0; j < set.get(i).size(); j ++)
				System.out.print(set.get(i).get(j));
			System.out.println();
		}
	}

}
