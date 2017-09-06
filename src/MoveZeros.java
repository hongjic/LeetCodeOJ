
/**
 * @author chenhongji
 *	moveZero problem 
 *  minimize the writes
 */
public class MoveZeros {

	/**
	 * @param args
	 */
	public int moveZeros(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int len = nums.length;
		int left = 0, right = len - 1;
		while (left <right) {
			while (left < right && nums[left] != 0) left ++;
			while (left < right && nums[right] == 0) right --;
			if (left == right) break;
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left ++; right --;
		}
		if (nums[left] == 0) return left - 1;
		return left;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 2, 0, 0, 3, 0, 0, 10};
		int left = new MoveZeros().moveZeros(nums);
		System.out.println(left);
		for (int i = 0; i < nums.length; i ++)
			System.out.print(nums[i] + " ");
	}

}
