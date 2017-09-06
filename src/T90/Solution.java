package T90;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	private void helper(int[] use, int len, int index, List<List<Integer>> results, List<Integer> noDup, List<Integer> num) {
		if (index == len) {
			List<Integer> result = new ArrayList<Integer>();
			for (int i = 0; i < len; i ++)
				for (int r = 0 ; r < use[i]; r ++)
					result.add(noDup.get(i));
			results.add(result);
			return;
		}
		for (int r = 0; r <= num.get(index); r ++) {
			use[index] = r;
			helper(use, len, index + 1, results, noDup, num);
		}
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) 
			return results;
		Arrays.sort(nums);
		List<Integer> noDup = new ArrayList<Integer>();
		List<Integer> num = new ArrayList<Integer>();
		int i = 0, len = 0;
		while (i < nums.length) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				noDup.add(nums[i]);
				num.add(1);
				len ++;
			}
			else num.set(len - 1, num.get(len - 1) + 1);
			i ++;
		}
		int[] use = new int[len];
		helper(use, len, 0, results, noDup, num);
		return results;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = {1, 2, 2};
		List<List<Integer>> results = sol.subsetsWithDup(nums);
		for (int i = 0; i < results.size(); i ++) {
			for (int j = 0; j < results.get(i).size(); j ++)
				System.out.print(results.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
