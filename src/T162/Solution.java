package T162;

public class Solution {

	// the principle is: if nums[mid] < nums[mid + 1], then there must be a peek in the right half
	// but there may be no peek in the left half.
	public int findPeakElement(int[] nums) {
		int len = nums.length;
		int left = 0, right = len - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1])
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findPeakElement(new int[] {1, 1, 1, 1, 1, 2, 3, 4, 2, 1, 5, 2}));
	}

}
