package T136;

public class Solution {

	public int singleNumber(int[] nums) {
		int x = 0;
		for (int num: nums) x ^= num;
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().singleNumber(new int[]{1,1,2,2,3,3,4,4,5,6,7,5,7}));
	}

}
