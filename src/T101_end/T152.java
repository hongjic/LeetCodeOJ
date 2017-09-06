package T101_end;

public class T152 {

	public int maxProduct(int[] nums) {
		if (nums == null) return 0;
		int len = nums.length;
		int max = nums[0], 
			min = nums[0];
		int result = nums[0];
		for (int i = 1; i < len; i ++) {
			if (nums[i] > 0) {
				max = Math.max(nums[i], max * nums[i]);
				min = Math.min(nums[i], min * nums[i]);
			}
			else if (nums[i] < 0) {
				int preMax = max;
				max = Math.max(nums[i], min * nums[i]);
				min = Math.min(nums[i], preMax * nums[i]);
			}
			else {
				max = 0;
				min = 0;
			}
			if (max > result)
				result = max;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T152 t152 = new T152();
		int[] nums = {-2, 5, 0, 6, -2, 3, -7, 3, 6, 1, -1, 9, 0, 9, 9, -10};
		System.out.println(t152.maxProduct(nums));
	}

}
