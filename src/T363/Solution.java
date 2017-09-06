package T363;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

	// a combination of "max sum of retangle"
	// and sub array no larger than k
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int rows = matrix.length, cols = matrix[0].length;
		int[] sum = new int[rows];
		int max = Integer.MIN_VALUE;

			
		for (int left = 0; left < cols; left ++) {
			Arrays.fill(sum, 0);
			
			for (int right = left; right < cols; right ++) {
				for (int j = 0; j < rows; j ++)
					sum[j] += matrix[j][right];
				
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(0);
				int curSum = 0, curMax = Integer.MIN_VALUE;
				for (int j = 0; j < rows; j ++) {
					curSum += sum[j];
					Integer preSum = set.ceiling(curSum - k);
					if (preSum != null) curMax = Math.max(curMax, curSum - preSum);
					set.add(curSum);
				}
				max = Math.max(max, curMax);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {
				{1, 0, 1},
				{0, -2, 3}
		};
		System.out.println(new Solution().maxSumSubmatrix(matrix, 2));
	}

}
