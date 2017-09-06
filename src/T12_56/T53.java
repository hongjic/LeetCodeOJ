package T12_56;
public class T53 {

	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;
		int max = nums[0],
			min_sum = 0,
			sum = 0;
		for (int i = 1; i<=len; i++) {
			sum = sum + nums[i-1];
			if (sum - min_sum > max) max = sum - min_sum;
			if (sum < min_sum) min_sum = sum;
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T53 t53 = new T53();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(t53.maxSubArray(nums));
	}

}
