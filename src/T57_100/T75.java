package T57_100;

public class T75 {
	
	public void sortColors(int[] nums) {
		int len = nums.length;
		if (len == 0) return;
		int[] sums = new int[3];
		for (int i = 0; i < len; ++ i) 
			++ sums[nums[i]];
		int k = -1;
		for (int i = 0; i < 3; ++ i)
			for (int j = 0; j < sums[i]; ++ j)
				nums[++ k] = i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T75 t75 = new T75();
		int[] nums = {0,2,1,2,2,1,1,1,0,0,2,2,1,0,0,0,1,2,2};
		int len = nums.length;
		t75.sortColors(nums);
		for (int i = 0; i < len; ++ i) 
			System.out.print(nums[i]+" ");
	}

}
