package T280;

public class Solution2 {
	
	public void wiggleSort(int[] nums) {
		wiggleSort(nums, 0, nums.length - 1);
	}
	
	private void wiggleSort(int[] nums, int left, int right) {
		if (left >= right) return;
		if (left + 1 == right) {
			if (nums[left] > nums[right])
				swap(nums, left, right);
			return;
		}
		int mid = left + (right - left) / 2;
		int leftEnd = 0, rightStart = 0;
		if (((mid - left + 1) & 1) == 1) {
			// odd: divide --> left .. mid - 1, mid ..right
			leftEnd = mid - 1;
			rightStart = mid;
		}
		else {
			// even: divide --> left .. mid, mid + 1 .. right
			leftEnd = mid;
			rightStart = mid + 1;
		}
		// swap: leftEnd = max of left part
		int max = nums[left], maxIndex = left;
		for (int i = left + 1; i <= leftEnd; i ++)
			if (nums[i] > max) {
				max = nums[left];
				maxIndex = i;
			}
		swap(nums, maxIndex, leftEnd);
		// swap: rightStart = min of right part
		int min = nums[right], minIndex = right;
		for (int i = right; i >= rightStart; i --)
			if (nums[i] < min) {
				min = nums[i];
				minIndex = i;
			}
		swap(nums, minIndex, rightStart);
		if (nums[leftEnd] < nums[rightStart])
			swap(nums, leftEnd, rightStart);
		wiggleSort(nums, left, leftEnd);
		wiggleSort(nums, rightStart, right);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {3,5,2,1,6,4,-1,0,-2,-3,-4,-5};
		int[] nums = {2,1};
		new Solution2().wiggleSort(nums);
		for (int i = 0; i < nums.length; i ++)
			System.out.print(nums[i] + " ,");
	}

}
