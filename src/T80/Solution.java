package T80;

public class Solution {

	private static int dup = 2;
	
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int t = 0, i = 0, j = 0;
		while (j < nums.length) {
			if (t == dup) {
				while (j < nums.length && nums[j] == nums[j - 1]) j ++;
				if (j == nums.length) break;
			}
			nums[i] = nums[j];
			if (i == 0 || nums[i] != nums[i - 1])
				t = 1;
			else t ++;
			i ++; j ++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1,1,1,2,2,3,3,3,3,3,3,3,3};
		int len = new Solution().removeDuplicates(nums);
		for (int i = 0; i < len; i ++)
			System.out.print(nums[i] + ", ");
	}

}
