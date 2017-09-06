package T442;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> dup = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i ++)
			while (nums[i] != -1 && nums[i] != i + 1)
				swap(nums, i, nums[i] - 1, dup);
		return dup;
	}
	
	private void swap(int[] nums, int i, int j, List<Integer> dup) {
		if (nums[i] == nums[j]) {
			dup.add(nums[i]); nums[i] = -1;
		}
		else {
			int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> dup = new Solution().findDuplicates(new int[]{4,3,2,7,8,2,3,1});
		for (int i = 0; i < dup.size(); i ++)
			System.out.print(dup.get(i) + ", ");
	}

}
