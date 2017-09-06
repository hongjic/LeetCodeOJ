package T229;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) return res;
		int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] == candidate1)
				count1 ++;
			else if (nums[i] == candidate2)
				count2 ++;
			else if (count1 == 0) {
				candidate1 = nums[i];
				count1 = 1;
			}
			else if (count2 == 0) {
				candidate2 = nums[i];
				count2 = 1;
			}
			else {
				count1 --; count2 --;
			}
		}
		count1 = 0; count2 = 0;
		for (int i = 0; i < nums.length; i ++)
			if (nums[i] == candidate1) count1 ++;
			else if (nums[i] == candidate2) count2 ++;
		if (count1 > nums.length / 3) res.add(candidate1);
		if (count2 > nums.length / 3) res.add(candidate2);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new Solution().majorityElement(new int[]{1,1,1,3,4,4});
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
