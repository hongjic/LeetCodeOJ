package T463;

public class Solution {

	private static final int[][] D = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public int islandPerimeter(int[][] grid) {
		int rows = grid.length, sum = 0;
		if (rows == 0) return sum;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i ++) 
			for (int j = 0; j < cols; j ++) 
				if (grid[i][j] == 1) {
					for (int d = 0; d < 4; d ++) 
						if (!(i + D[d][0] >= 0 && i + D[d][0] < rows && j + D[d][1] >= 0 && j + D[d][1] < cols)
						|| grid[i + D[d][0]][j + D[d][1]] == 0) sum ++;
				}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		System.out.println(new Solution().islandPerimeter(grid));
	}

}
