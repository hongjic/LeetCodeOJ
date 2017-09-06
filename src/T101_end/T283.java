package T101_end;

public class T283 {

	public void moveZeroes(int[] nums) {
		//two pointer
		if (nums == null || nums.length < 2) return;
		int len = nums.length;
		int j = 0;
		for (int i = 0; i < len; ++ i)
			if (nums[i] != 0) {
				nums[j] = nums[i];
				++ j;
			}
		for (int i = j; i <len; ++ i)
			nums[i] = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T283 t283 = new T283();
		int[] nums = {0, 1, 0, 3, 12};
		t283.moveZeroes(nums);
		for (int i = 0; i < nums.length; ++ i)
			System.out.print(nums[i] + " ");
	}

}
