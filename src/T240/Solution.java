package T240;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows == 0) return false;
		int cols = matrix[0].length;
		if (cols == 0) return false;
		int leftCol = 0, rightCol = cols - 1, topRow = 0, bottomRow = rows - 1;
		return searchMatrix(matrix, leftCol, rightCol, topRow, bottomRow, target);
	}
	
	private boolean searchMatrix(int[][] matrix, int leftCol, int rightCol, int topRow, int bottomRow, int target) {
		if (leftCol > rightCol || topRow > bottomRow) return false;
		if (leftCol == rightCol && topRow == bottomRow)
			return matrix[topRow][leftCol] == target;
		if (matrix[topRow][leftCol] > target || matrix[bottomRow][rightCol] < target) return false;
		int midCol = leftCol + (rightCol - leftCol) / 2;
		int midRow = topRow + (bottomRow - topRow) / 2;
		return searchMatrix(matrix, leftCol, midCol, topRow, midRow, target) 
				|| searchMatrix(matrix, midCol + 1, rightCol, topRow, midRow, target)
				|| searchMatrix(matrix, leftCol, midCol, midRow + 1, bottomRow, target) 
				|| searchMatrix(matrix, midCol + 1, rightCol, midRow + 1, bottomRow, target);		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
//		int[][] matrix = {{-1, 3}};
		int target = 5;
		System.out.println(new Solution().searchMatrix(matrix, target));

	}

}
