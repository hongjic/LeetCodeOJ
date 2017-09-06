package T12_56;
public class T55 {

	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len <= 1) return true;
		int max_access = 0;
		for (int i = 0; i < len; i++)
			if (i <= max_access) {
				if (i + nums[i] > max_access)
					max_access = i + nums[i];
			}
			else break;
		return max_access >= len - 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T55 t55 = new T55();
		int[] nums = {2, 0, 0};
		System.out.println(t55.canJump(nums));
	}

}
