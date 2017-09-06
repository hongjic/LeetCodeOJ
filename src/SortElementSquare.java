
public class SortElementSquare {

	public int[] sort(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int len = nums.length;
		int[] result = new int[len];
		int left = 0, right = len - 1, index = 0;
		// right search for negative
		// left search for non-negative
		while (left < len || right >= 0) {
			while (left < len && nums[left] < 0) left ++;
			while (right >= 0 && nums[right] >= 0) right --;
			if (left == len && right < 0) break;
			if (left == len) {
				result[index] = nums[right] * nums[right];
				index ++;
				right --;
			}
			else if (right < 0) {
				result[index] = nums[left] * nums[left];
				index ++;
				left ++;
			}
			else {
				if (nums[left] <= -nums[right]) {
					result[index] = nums[left] * nums[left];
					index ++;
					left ++;
				}
				else {
					result[index] = nums[right] * nums[right];
					index ++;
					right --;
				}
			}
		}
		return result;
	}
	
	public int[] sort2(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int len = nums.length;
		int left = 0, right = len - 1, index = len - 1;
		int[] result = new int[len];
		// left search for non-positive
		// right search for positive
		while (nums[left] <= 0 || nums[right] > 0) {
			if (nums[left] > 0 || nums[right] >= -nums[left]) {
				result[index] = nums[right] * nums[right];
				index --;
				right --;
			}
			else /*if (nums[right] <=0 || -nums[left] > nums[right]) */ {
				result[index] = nums[left] * nums[left];
				index --;
				left ++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortElementSquare sol = new SortElementSquare();
		int[] nums = new int[]{-9,-3,-1,2,4,6};
		int[] result = sol.sort2(nums);
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + " ");
	}

}
