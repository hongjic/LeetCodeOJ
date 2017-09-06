package T303;

public class NumArray {

	private int[] sums;
	
	public NumArray(int[] nums) {
		this.sums = new int[nums.length];
		for (int i = 0; i < nums.length; i ++)
			if (i == 0) sums[i] = nums[i];
			else sums[i] = sums[i - 1] + nums[i];
	}
	
	public int sumRange(int i, int j) {
		if (i == 0) return sums[j];
		return sums[j] - sums[i - 1];
	}
}
