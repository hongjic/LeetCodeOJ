package T47;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	private void helper(Map<Integer, Integer> map, List<List<Integer>> res, int index, int len, ArrayList<Integer> cur) {
		if (index == len) {
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(cur);
			res.add(l);
			return;
		}
		for (int num: map.keySet())
			if (map.get(num) > 0) {
				map.put(num, map.get(num) - 1);
				cur.add(num);
				helper(map, res, index + 1, len, cur);
				cur.remove(cur.size() - 1);
				map.put(num, map.get(num) + 1);
			}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i ++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(map, res, 0, nums.length, new ArrayList<Integer>());
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {};
		List<List<Integer>> res = new Solution().permuteUnique(nums);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}

}
