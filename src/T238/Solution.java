package T238;

public class Solution {

	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		result[0] = 1;
		for (int i = 1; i < len; i ++)
			result[i] = result[i - 1] * nums[i - 1];
		int right = 1;
		for (int i = len - 1; i >= 0; i --) {
			result[i] *= right;
			right *= nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = new int[] { 1,2,3,4,5 };
		int[] result = sol.productExceptSelf(nums);
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + " ");
	}

}
