package T448;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> mis = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++) {
			while (nums[i] != -1 && nums[i] != i + 1)
				swap(nums, i, nums[i] - 1);
		}
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] == -1) mis.add(i + 1);
		return mis;
	}
	
	private void swap(int[] nums, int i, int j) {
		if (nums[i] == nums[j]) nums[i] = -1;
		else {
			int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new Solution().findDisappearedNumbers(new int[] {1,3,1});
		for (int i = 0; i < res.size(); i ++)
			System.out.print(res.get(i) + ", ");
	}

}
