package T167;

public class Solution {

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) return null;
		int left = 1, right = numbers.length;
		while (left < right) {
			if (numbers[left - 1] + numbers[right - 1] < target) left ++;
			else if (numbers[left - 1] + numbers[right - 1] > target) right --;
			else return new int[] {left, right}; 
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] indexes = new Solution().twoSum(new int[]{2,7,11,15}, 9);
		System.out.println(indexes[0] + " " + indexes[1]);
	}

}
