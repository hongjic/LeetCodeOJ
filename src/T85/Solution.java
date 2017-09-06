package T85;

import java.util.Arrays;

public class Solution {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) return 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		// becuase for each row: left, right and height only depend on the previous row,
		// so don't need 2D array
		int[] left = new int[cols], right = new int[cols], height = new int[cols];
		Arrays.fill(left, 0);
		Arrays.fill(right, cols);
		Arrays.fill(height, 0);
		int max = 0;
		for (int i = 0; i < rows; i ++) {
			int curLeft = 0, curRight = cols;
			for (int j = 0; j < cols; j ++)
				if (matrix[i][j] == '1') height[j] ++;
				else height[j] = 0;
			for (int j = 0; j < cols; j ++)
				if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
				else {
					left[j] = 0; curLeft = j + 1; // here, left persists exact left boundary
				}
			for (int j = cols - 1; j >= 0; j --)
				if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
				else {
					right[j] = cols; curRight = j; // here , right persists the right boundary + 1 
				}
			for (int j = 0; j < cols; j ++)
				max = Math.max(max, (right[j] - left[j]) * height[j]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][] {
				"10100".toCharArray(),
				"10111".toCharArray(),
				"11111".toCharArray(),
				"10010".toCharArray()
		};
		System.out.println(new Solution().maximalRectangle(matrix));
	}

}
