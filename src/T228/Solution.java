package T228;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums.length == 0) return res;
		int left = nums[0], right = left, i = 1;
		while (i < nums.length) {
			if (nums[i] == right + 1) 
				right ++;
			else {
				res.add(summary(left, right));
				left = nums[i]; right = left;
			}
			i ++;
		}
		res.add(summary(left, right));
		return res;
	}
	
	private String summary(int left, int right) {
		if (left == right) return String.valueOf(left);
		return String.format("%d->%d", left, right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
		for (int i = 0; i < res.size(); i ++)
			System.out.print(res.get(i) + ", ");
	}

}
