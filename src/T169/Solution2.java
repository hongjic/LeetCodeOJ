package T169;

public class Solution2 {

	// this problem assumes the majority element exists, so finally "major" will comes to that.
	public int majorityElement(int[] nums) {
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i ++)
			if (count == 0) {
				major = nums[i];
				count ++;
			}
			else if (major == nums[i]) 
				count ++;
			else count --;
		return major;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().majorityElement(new int[]{1,2,3,5,5,5,1,1,1,1}));
	}

}
