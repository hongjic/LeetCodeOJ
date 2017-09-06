package T57_100;

public class T64 {

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0 || grid[0].length == 0) 
			return 0;
		int n = grid[0].length;
		int[][] f = new int[m][n];
		f[0][0] = grid[0][0];
		for (int i = 1; i < n; i ++)
			f[0][i] = f[0][i - 1] + grid[0][i];
		for (int i = 1; i < m; i ++)
			f[i][0] = f[i - 1][0] + grid[i][0];
		for (int i = 1; i < m; i ++)
			for (int j = 1; j < n; j ++)
				f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
		return f[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		T64 t64 = new T64();
		System.out.println(t64.minPathSum(grid));
	}

}
