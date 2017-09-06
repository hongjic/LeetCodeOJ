package T280;

public class Solution {

	// find the smallest on right --> find the largest on right --> smallest
	// O(n^2)
	
	public void wiggleSort(int[] nums) {
		int len = nums.length;
		boolean smallest = true;
		for (int i = 0; i < len; i ++) {
			int target, index = 0;
			if (smallest) {
				target = Integer.MAX_VALUE;
				for (int j = i; j < len; j ++) 
					if (nums[j] < target) {
						target = nums[j];
						index = j;
					}
			}
			else {
				target = Integer.MIN_VALUE;
				for (int j = i; j < len; j ++)
					if (nums[j] > target) {
						target = nums[j];
						index = j;
					}
			}
			swap(nums, i, index);
			smallest = !smallest;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 3,5,2,1,6,4 };
		new Solution().wiggleSort(nums);
		for (int i = 0; i < nums.length; i ++)
			System.out.print(nums[i] + " ,");
	}

}
