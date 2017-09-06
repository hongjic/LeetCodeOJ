package T215;

public class Solution {

	public Integer findKthLargest(int[] nums, int k) {
		if (nums == null || k > nums.length) 
			return null;
		int len = nums.length;
		int index = len - k;
		return quickSelect(nums, 0, len - 1, index);
	}
	
	private int quickSelect(int[] nums, int left, int right, int index) {
		if (left == right)
			return nums[left];
		int mid = (left + right) / 2;
		int pivot = nums[mid];
		nums[mid] = nums[left];
		int i = left, j = right;
		while (i < j) {
			while (i < j && nums[j] > pivot) j --;
			if (i == j) break;
			nums[i] = nums[j]; i ++;
			while (i < j && nums[i] < pivot) i ++;
			if (i == j) break;
			nums[j] = nums[i]; j --;
		}
		nums[i] = pivot;
		if (i == index) return nums[index];
		if (i > index) return quickSelect(nums, left, i - 1, index);
		return quickSelect(nums, i + 1, right, index); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = {3,1,2,4};
		int k = 2;
		System.out.println(sol.findKthLargest(nums, k));
	}

}
