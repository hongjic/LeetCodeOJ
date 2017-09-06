package LongestArithmeticSubsequence;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	public int longestArithmeticSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		ArrayList<Map<Integer, Integer>> f = new ArrayList<Map<Integer, Integer>>();
		int maxLen = 1;
		f.add(new HashMap<Integer, Integer>());
		for (int i = 1; i < nums.length; i ++) {
			Map<Integer, Integer> sf = new HashMap<Integer, Integer>();
			for (int j = 0; j < i; j ++)  {
				int diff = nums[i] - nums[j];
				int llen = 1;
				if (diff >= 0) {
					if (f.get(j).containsKey(diff)) {
						llen = f.get(j).get(diff) + 1;
					}
					else llen = 2;
				}
				maxLen = Math.max(maxLen, llen);
				sf.put(diff, Math.max(llen, sf.getOrDefault(diff, 0)));
			}
			f.add(sf);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,6,8,10,5,9,13,17,21};
		System.out.println(new Solution().longestArithmeticSubsequence(nums));
	}

}
