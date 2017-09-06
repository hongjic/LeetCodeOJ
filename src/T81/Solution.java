package T81;

public class Solution {

	public boolean search(int[] nums, int target) {
		int len = nums.length;
		int left = 0, right = len - 1;
		while (left < right) {
			if (nums[right] == target) return true;
			while (left < right && nums[right] == nums[left]) right --;
			if (left == right) break;
			if (nums[right] > nums[left])
				return binarySearch(nums, target, left, right);
			// now nums[right] < nums[left]
			int mid = (left + right) / 2;
			if (nums[mid] >= nums[left]) {
				if (target >= nums[left] && target <= nums[mid]) right = mid;
				else left = mid + 1;
			}
			else {
				if (target >= nums[left] || target <= nums[mid]) right = mid;
				else left = mid + 1;
			}
		}
		return target == nums[left];
	}
	
	private boolean binarySearch(int[] nums, int target, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) left = mid + 1;
			else right = mid;
		}
		return target == nums[left];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().search(new int[]{1,1,1,3,1}, 3));
	}

}
