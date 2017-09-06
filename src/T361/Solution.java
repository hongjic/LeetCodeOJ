package T361;

public class Solution {

	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length, cols = grid[0].length;
		
		// horizontal
		int[][] horizontal = new int[rows][cols];
		for (int i = 0; i < rows; i ++) {
			int start = 0;
			while (start < cols) {
				while (start < cols && grid[i][start] == 'W') start ++;
				if (start == cols) break;
				int end = start;
				int count = 0;
				while (end < cols && grid[i][end] != 'W') {
					if (grid[i][end] == 'E') count ++;
					end ++;
				}
				for (int j = start; j < end; j ++)
					if (grid[i][j] == '0')
						horizontal[i][j] = count;
				start = end;
			}
		}
		
		// vertical
		int[][] vertical = new int[rows][cols];
		for (int j = 0; j < cols; j ++) {
			int start = 0;
			while (start < rows) {
				while (start < rows && grid[start][j] == 'W') start ++;
				if (start == rows) break;
				int end = start;
				int count = 0;
				while (end < rows && grid[end][j] != 'W') {
					if (grid[end][j] == 'E') count ++;
					end ++;
				}
				for (int i = start; i < end; i ++)
					if (grid[i][j] == '0')
						vertical[i][j] = count;
				start = end;
					
			}
		}
	
		// iterate
		int max = 0;
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (grid[i][j] == '0')
					max = Math.max(max, horizontal[i][j] + vertical[i][j]);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = new char[][] {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
		System.out.println(new Solution().maxKilledEnemies(grid));
		
	}

}
