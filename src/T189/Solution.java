package T189;

public class Solution {

	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int[] t = new int[k];
		System.arraycopy(nums, nums.length - k, t, 0, k);
		for (int i = nums.length - 1; i >= k; i --)
			nums[i] = nums[i - k];
		System.arraycopy(t, 0, nums, 0, k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6,7};
		new Solution().rotate(nums, 3);
		for (int i = 0; i < nums.length; i ++)
			System.out.print(nums[i] + ", ");
	}

}
