package Algorithms.TwoSum;

public class TwoSum {
	
	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i<nums.length; i++) 
			for (int j = i+1; j<nums.length; j++) 
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 2, 4, 3};
		int target = 6;
		int[] result = twoSum(arr, target);
		System.out.println(result.length);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
