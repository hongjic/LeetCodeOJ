package T287;

public class Solution {

	// same principle as T142.
	// the only difference is the linkedlist is hidden. 
	// becuase all integers are from 1 to n, the linkedlist is nums[x] = y
	public int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];;
				fast = nums[nums[fast]];
			}
			fast = 0;
			while (fast != slow) {
				slow = nums[slow];
				fast = nums[fast];
			}
			return slow;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findDuplicate(new int[]{1,1}));
	}

}
