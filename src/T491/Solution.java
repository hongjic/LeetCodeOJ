package T491;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Solution {

	public List<List<Integer>> findSubsequences	(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		helper(nums, 0, -200, new ArrayList<Integer>(), res);
		return new ArrayList<List<Integer>>(res);
	}
	
	private void helper(int[] nums, int index, int pre, ArrayList<Integer> sub, Set<List<Integer>> res) {
		if (index == nums.length)
			return;
		if (nums[index] >= pre) {
			sub.add(index);
			if (sub.size() >= 2) addRes(nums, sub, res);
			helper(nums, index + 1, nums[index], sub, res);
			sub.remove(sub.size() - 1);
		}
		helper(nums, index + 1, pre, sub, res);
	}
	
	private void addRes(int[] nums, ArrayList<Integer> sub, Set<List<Integer>> res) {
		List<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < sub.size(); i ++)
			r.add(nums[sub.get(i)]);
		res.add(r);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {4, 6, 7, 7};
		List<List<Integer>> res = new Solution().findSubsequences(nums);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j));
			System.out.println();
		}
	}

}
